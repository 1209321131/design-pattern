package com.kcaco.designpattern.结构型.装饰器模式.费用计算.fee;


import lombok.AllArgsConstructor;

import java.math.BigDecimal;

/**
 * Description: 抽象费用项
 *
 * @author kcaco
 * @since 2022/10/18 8:47 PM
 */
@AllArgsConstructor
public class AbstractFeeItem<T> implements FeeItem<T> {

    /**
     * 订单信息
     */
    private final T orderInfo;

    /**
     * 费用类型
     */
    private final FeeItemTypeEnum itemType;

    /**
     * 金额
     */
    private final BigDecimal itemMoney;

    @Override
    public BigDecimal getFeeItemOriginMoney() {
        return itemMoney;
    }

    @Override
    public FeeItemTypeEnum getFeeItemType() {
        return itemType;
    }

    @Override
    public T getOrderInfo() {
        return orderInfo;
    }
}
