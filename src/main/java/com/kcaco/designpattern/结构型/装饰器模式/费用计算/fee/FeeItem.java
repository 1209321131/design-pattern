package com.kcaco.designpattern.结构型.装饰器模式.费用计算.fee;

import java.math.BigDecimal;

/**
 * Description: 费用项
 *
 * @author kcaco
 * @since 2022/10/18 8:45 PM
 */
public interface FeeItem<T> {

    /**
     * 原始金额
     */
    BigDecimal getFeeItemOriginMoney();

    /**
     * 费用类型
     */
    FeeItemTypeEnum getFeeItemType();

    /**
     * 订单原始信息
     */
    T getOrderInfo();

}
