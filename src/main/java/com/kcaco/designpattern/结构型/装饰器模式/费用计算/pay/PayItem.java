package com.kcaco.designpattern.结构型.装饰器模式.费用计算.pay;

import java.math.BigDecimal;

/**
 * 支付项
 */
public interface PayItem {

    /**
     * 钱、时间等抽象
     */
    BigDecimal getMoney();

    /**
     * 支付类型
     */
    PayType getPayType();

    /**
     * 支付分组
     */
    PayGroup getPayGroup();


}
