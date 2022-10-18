package com.kcaco.designpattern.结构型.装饰器模式.费用计算.calculate;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.ObjectUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.fee.FeeResultEnum;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.fee.FeeItem;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.fee.FeeItemTypeEnum;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.pay.PayItem;

import java.math.BigDecimal;
import java.util.*;

/**
 * Description: 计算器抽象类
 *
 * @author kcaco
 * @since 2022/10/18 9:12 PM
 */
public abstract class AbstractCalculator<T> implements FeeCalculate<T> {

    /**
     * 费用计算器
     */
    private final FeeCalculate<T> feeCalculate;

    /**
     * 计算器唯一编码
     */
    private final Unique unique;

    protected AbstractCalculator(FeeCalculate<T> feeCalculate, Unique unique) {
        this.feeCalculate = feeCalculate;
        this.unique = unique;
    }

    @Override
    public Unique getUnique() {
        return unique;
    }

    /**
     * 当前费用项及其支付金额map
     */
    protected abstract Map<FeeItemTypeEnum, BigDecimal> currentDeductMap(Map<FeeItemTypeEnum, BigDecimal> left, T o);

    /**
     * 当前费用项及其支付详情map
     */
    protected abstract Map<FeeItemTypeEnum, List<PayItem>> currentPayItemMap();

    @Override
    public Map<FeeItemTypeEnum, List<PayItem>> payItemMap(List<FeeItem<T>> list) {
        // 费用项列表
        Map<FeeItemTypeEnum, List<PayItem>> map;

        // 上一级不为空，并且抵扣项不为空
        if (ObjectUtil.isNotNull(feeCalculate) && CollUtil.isNotEmpty(feeCalculate.payItemMap(list))) {
            map = feeCalculate.payItemMap(list);
        } else {
            map = Maps.newHashMap();
        }

        Map<FeeItemTypeEnum, List<PayItem>> currentPayItemMap = currentPayItemMap();
        if (CollUtil.isNotEmpty(currentPayItemMap)) {
            currentPayItemMap.forEach((key, value) -> {
                List<PayItem> tempList = map.getOrDefault(key, Lists.newArrayList());
                tempList.addAll(value);
                map.put(key, tempList);
            });
        }
        return map;
    }

    @Override
    public Map<FeeItemTypeEnum, BigDecimal> waitPayMoneyMap(List<FeeItem<T>> feeItemList) {
        // 检查费用项
        if (CollUtil.isEmpty(feeItemList)) {
            throw new RuntimeException(FeeResultEnum.FEE_ITEM_EMPTY.getName());
        }

        // 如果没有上层包装，则直接返回订单的实际金额减去当前抵扣的金额
        if (ObjectUtil.isNull(feeCalculate)) {
            // 当前费用项对应待支付金额
            Map<FeeItemTypeEnum, BigDecimal> leftMap = Maps.newHashMap();
            for (FeeItem<T> item : feeItemList) {
                leftMap.put(item.getFeeItemType(), item.getFeeItemOriginMoney());
            }
            Map<FeeItemTypeEnum, BigDecimal> currentDeduct = currentDeductMap(leftMap, feeItemList.get(0).getOrderInfo());
            currentDeduct.forEach((key, value) -> leftMap.put(key, NumberUtil.sub(leftMap.get(key), value)));
            return leftMap;
        } else {
            // 上级，当前费用项对应待支付金额
            Map<FeeItemTypeEnum, BigDecimal> left = feeCalculate.waitPayMoneyMap(feeItemList);

            // 如果所有待支付金额不大于0，直接返回
            Optional<BigDecimal> greaterThanZero = new ArrayList<>(left.values()).stream()
                    .filter(waitPayMoney -> NumberUtil.isGreater(waitPayMoney, BigDecimal.ZERO))
                    .findFirst();
            if (!greaterThanZero.isPresent()) {
                return left;
            }

            Map<FeeItemTypeEnum, BigDecimal> currentDeduct = currentDeductMap(left, feeItemList.get(0).getOrderInfo());
            Map<FeeItemTypeEnum, BigDecimal> temp = Maps.newHashMap();
            for (FeeItem<T> item : feeItemList) {
                BigDecimal currentDeductMoney = currentDeduct.get(item.getFeeItemType());
                BigDecimal waitPayMoney = left.get(item.getFeeItemType());

                // 如果当前有抵扣
                if (ObjectUtil.isNotNull(currentDeductMoney)) {
                    // 当前费用项抵扣金额大于待支付金额，报错
                    if (NumberUtil.isGreater(currentDeduct.get(item.getFeeItemType()), waitPayMoney)) {
                        throw new RuntimeException(FeeResultEnum.AMOUNT_GREATER_ERROR.getName());
                    }
                    temp.put(item.getFeeItemType(), NumberUtil.sub(waitPayMoney, currentDeductMoney));
                } else {
                    // 如果当前没有抵扣，直接返回剩余金额
                    temp.put(item.getFeeItemType(), left.get(item.getFeeItemType()));
                }
            }
            return temp;
        }
    }
}
