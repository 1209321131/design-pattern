package com.kcaco.design.结构型.装饰器模式.费用计算.calculate;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.ObjectUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.kcaco.design.结构型.装饰器模式.费用计算.fee.FeeResultEnum;
import com.kcaco.design.结构型.装饰器模式.费用计算.fee.FeeItem;
import com.kcaco.design.结构型.装饰器模式.费用计算.fee.FeeItemTypeEnum;
import com.kcaco.design.结构型.装饰器模式.费用计算.pay.PayItem;

import java.math.BigDecimal;
import java.util.*;

/**
 * Description: 计算器抽象类
 *
 * @author kcaco
 * @since 2022/10/18 9:12 PM
 */
public abstract class AbstractFeeCalculator<T> implements FeeCalculate<T> {

    /**
     * 费用计算器
     */
    private final FeeCalculate<T> feeCalculate;

    /**
     * 计算器唯一编码
     */
    private final Unique unique;

    protected AbstractFeeCalculator(FeeCalculate<T> feeCalculate, Unique unique) {
        this.feeCalculate = feeCalculate;
        this.unique = unique;
    }

    @Override
    public Unique getUnique() {
        return unique;
    }

    /**
     * <当前费用项,抵扣金额>map
     *
     * @param currentWaitPayMoney <当前费用项，实际待支付金额>
     * @param orderInfo           订单信息
     */
    protected abstract Map<FeeItemTypeEnum, BigDecimal> currentDeductMap(Map<FeeItemTypeEnum, BigDecimal> currentWaitPayMoney, T orderInfo);

    /**
     * <当前费用项,抵扣明细>map
     */
    protected abstract Map<FeeItemTypeEnum, List<PayItem>> currentPayItemMap();

    @Override
    public Map<FeeItemTypeEnum, List<PayItem>> payItemMap(List<FeeItem<T>> feeItemList) {
        // 每个费用项对应的抵扣明细
        Map<FeeItemTypeEnum, List<PayItem>> payItemMap;

        // 上一级不为空，并且抵扣项不为空
        if (ObjectUtil.isNotNull(feeCalculate) && CollUtil.isNotEmpty(feeCalculate.payItemMap(feeItemList))) {
            payItemMap = feeCalculate.payItemMap(feeItemList);
        } else {
            payItemMap = Maps.newHashMap();
        }

        // <当前费用项,抵扣明细>
        Map<FeeItemTypeEnum, List<PayItem>> currentPayItemMap = currentPayItemMap();

        // 如果当前存在费用项的抵扣项，则放进去
        if (CollUtil.isNotEmpty(currentPayItemMap)) {
            currentPayItemMap.forEach((key, value) -> {
                List<PayItem> tempList = payItemMap.getOrDefault(key, Lists.newArrayList());
                tempList.addAll(value);
                payItemMap.put(key, tempList);
            });
        }

        return payItemMap;
    }

    @Override
    public Map<FeeItemTypeEnum, BigDecimal> waitPayMoneyMap(List<FeeItem<T>> feeItemList) {
        // 检查费用项是否为空
        if (CollUtil.isEmpty(feeItemList)) {
            throw new RuntimeException(FeeResultEnum.FEE_ITEM_EMPTY.getName());
        }

        // 如果没有上层包装，则直接返回订单的实际金额减去当前抵扣的金额（只有这一个计算器、计费规则）
        if (ObjectUtil.isNull(feeCalculate)) {
            // 当前费用项对应待支付金额
            Map<FeeItemTypeEnum, BigDecimal> currentWaitPayMoney = Maps.newHashMap();
            for (FeeItem<T> item : feeItemList) {
                currentWaitPayMoney.put(item.getFeeItemType(), item.getFeeItemOriginMoney());
            }
            // 待支付金额减去抵扣金额
            Map<FeeItemTypeEnum, BigDecimal> currentDeduct = currentDeductMap(currentWaitPayMoney, feeItemList.get(0).getOrderInfo());
            currentDeduct.forEach((key, value) -> currentWaitPayMoney.put(key, NumberUtil.sub(currentWaitPayMoney.get(key), value)));
            return currentWaitPayMoney;
        } else {
            // 上级：费用项及其对应实际待支付金额
            Map<FeeItemTypeEnum, BigDecimal> left = feeCalculate.waitPayMoneyMap(feeItemList);

            // 如果所有待支付金额不大于0，直接返回
            Optional<BigDecimal> greaterThanZero = new ArrayList<>(left.values()).stream()
                    .filter(waitPayMoney -> NumberUtil.isGreater(waitPayMoney, BigDecimal.ZERO))
                    .findFirst();
            if (!greaterThanZero.isPresent()) {
                return left;
            }

            // 当前<费用项，抵扣金额>
            Map<FeeItemTypeEnum, BigDecimal> currentDeduct = currentDeductMap(left, feeItemList.get(0).getOrderInfo());

            // 减去当前<费用项，抵扣金额>
            Map<FeeItemTypeEnum, BigDecimal> temp = Maps.newHashMap();
            for (FeeItem<T> feeItem : feeItemList) {
                BigDecimal currentDeductMoney = currentDeduct.get(feeItem.getFeeItemType());
                BigDecimal waitPayMoney = left.get(feeItem.getFeeItemType());

                // 如果当前有抵扣
                if (ObjectUtil.isNotNull(currentDeductMoney)) {
                    // 当前费用项抵扣金额大于待支付金额，报错
                    if (NumberUtil.isGreater(currentDeduct.get(feeItem.getFeeItemType()), waitPayMoney)) {
                        throw new RuntimeException(FeeResultEnum.AMOUNT_GREATER_ERROR.getName());
                    }
                    temp.put(feeItem.getFeeItemType(), NumberUtil.sub(waitPayMoney, currentDeductMoney));
                } else {
                    // 如果当前没有抵扣，直接返回剩余金额
                    temp.put(feeItem.getFeeItemType(), left.get(feeItem.getFeeItemType()));
                }
            }
            return temp;
        }
    }
}
