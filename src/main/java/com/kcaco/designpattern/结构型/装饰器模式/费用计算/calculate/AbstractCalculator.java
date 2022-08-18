package com.kcaco.designpattern.结构型.装饰器模式.费用计算.calculate;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.ObjectUtil;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.fee.FeeEnum;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.fee.FeeItem;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.fee.FeeItemType;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.pay.PayItem;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 抽象计算器
 */
public abstract class AbstractCalculator<T> implements FeeCalculate<T> {

    /**
     * 费用计算器
     */
    private final FeeCalculate<T> feeCalculate;

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
     * 当前费用项抵扣金额map
     */
    protected abstract Map<FeeItemType, BigDecimal> currentDeductMap(Map<FeeItemType, BigDecimal> left, T o);

    /**
     * 当前费用抵扣项map
     */
    protected abstract Map<FeeItemType, List<PayItem>> currentPayItemMap();

    @Override
    public Map<FeeItemType, List<PayItem>> payItemMap(List<FeeItem<T>> list) {
        Map<FeeItemType, List<PayItem>> map;

        // 上一级不为空，并且抵扣项不为空
        if (ObjectUtil.isNotNull(feeCalculate) && CollUtil.isNotEmpty(feeCalculate.payItemMap(list))) {
            map = feeCalculate.payItemMap(list);
        } else {
            map = Maps.newHashMap();
        }

        Map<FeeItemType, List<PayItem>> currentPayItemMap = currentPayItemMap();
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
    public Map<FeeItemType, BigDecimal> waitPayMoneyMap(List<FeeItem<T>> feeItemList) {
        // 检查费用项
        if (CollUtil.isEmpty(feeItemList)) {
            throw new RuntimeException(FeeEnum.FEE_ITEM_EMPTY.getName());
        }

        // 如果没有上层包装，则直接返回订单的实际金额减去当前抵扣的金额
        if (ObjectUtil.isNull(feeCalculate)) {
            // 当前费用项对应待支付金额
            Map<FeeItemType, BigDecimal> leftMap = Maps.newHashMap();
            for (FeeItem<T> item : feeItemList) {
                leftMap.put(item.getFeeItemType(), item.getFeeItemOriginMoney());
            }
            Map<FeeItemType, BigDecimal> currentDeduct = currentDeductMap(leftMap, feeItemList.get(0).getOrderInfo());
            currentDeduct.forEach((key, value) -> leftMap.put(key, NumberUtil.sub(leftMap.get(key), value)));
            return leftMap;
        } else {
            // 上级，当前费用项对应待支付金额
            Map<FeeItemType, BigDecimal> left = feeCalculate.waitPayMoneyMap(feeItemList);

            // 如果所有待支付金额不大于0，直接返回
            Optional<BigDecimal> greaterThanZero = new ArrayList<>(left.values()).stream()
                    .filter(waitPayMoney -> NumberUtil.isGreater(waitPayMoney, BigDecimal.ZERO))
                    .findFirst();
            if (!greaterThanZero.isPresent()) {
                return left;
            }

            Map<FeeItemType, BigDecimal> currentDeduct = currentDeductMap(left, feeItemList.get(0).getOrderInfo());
            Map<FeeItemType, BigDecimal> temp = Maps.newHashMap();
            for (FeeItem<T> item : feeItemList) {
                BigDecimal currentDeductMoney = currentDeduct.get(item.getFeeItemType());
                BigDecimal waitPayMoney = left.get(item.getFeeItemType());

                // 如果当前有抵扣
                if (ObjectUtil.isNotNull(currentDeductMoney)) {
                    // 当前费用项抵扣金额大于待支付金额，报错
                    if (NumberUtil.isGreater(currentDeduct.get(item.getFeeItemType()), waitPayMoney)) {
                        throw new RuntimeException(FeeEnum.AMOUNT_GREATER_ERROR.getName());
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
