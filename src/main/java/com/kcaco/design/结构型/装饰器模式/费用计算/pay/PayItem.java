package com.kcaco.design.结构型.装饰器模式.费用计算.pay;

import java.math.BigDecimal;

/**
 * Description: 支付项（抵扣项）
 *
 * @author kcaco
 * @since 2022/10/18 9:16 PM
 */
public interface PayItem {

    /**
     * 钱、时间等抽象
     */
    BigDecimal getMoney();

    /**
     * 支付类型
     */
    PayItemTypeEnum getPayType();

    /**
     * 支付分组
     */
    PayGroupEnum getPayGroup();


}
