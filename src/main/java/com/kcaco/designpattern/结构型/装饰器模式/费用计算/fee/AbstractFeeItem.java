package com.kcaco.designpattern.结构型.装饰器模式.费用计算.fee;


import java.math.BigDecimal;

/**
 * 抽象费用项
 */
public class AbstractFeeItem<T> implements FeeItem<T> {

    /**
     * 订单信息
     */
    private final T orderInfo;

    /**
     * 费用类型
     */
    private final FeeItemType itemType;

    /**
     * 金额
     */
    private final BigDecimal itemMoney;

    public AbstractFeeItem(T orderInfo, FeeItemType itemType, BigDecimal itemMoney) {
        this.orderInfo = orderInfo;
        this.itemType = itemType;
        this.itemMoney = itemMoney;
    }

    @Override
    public BigDecimal getFeeItemOriginMoney() {
        return itemMoney;
    }

    @Override
    public FeeItemType getFeeItemType() {
        return itemType;
    }

    @Override
    public T getOrderInfo() {
        return orderInfo;
    }
}
