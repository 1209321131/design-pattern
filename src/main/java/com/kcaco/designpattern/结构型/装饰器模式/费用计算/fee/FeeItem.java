package com.kcaco.designpattern.结构型.装饰器模式.费用计算.fee;

import java.math.BigDecimal;

/**
 * 费用项
 */
public interface FeeItem<T> {

    /**
     * 原始金额
     */
    BigDecimal getFeeItemOriginMoney();

    /**
     * 费用类型
     */
    FeeItemType getFeeItemType();

    /**
     * 订单原始信息
     */
    T getOrderInfo();

}
