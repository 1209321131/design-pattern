package com.kcaco.designpattern.结构型.装饰器模式.费用计算.pay;

import lombok.ToString;

import java.math.BigDecimal;

/**
 * @author gim 2021/12/2 8:31 下午
 */
@ToString
public abstract class AbstractPayItem implements PayItem {

    private final BigDecimal money;

    private final PayType payType;

    private final PayGroup payGroup;

    public AbstractPayItem(BigDecimal money, PayType payType, PayGroup payGroup) {
        this.money = money;
        this.payType = payType;
        this.payGroup = payGroup;
    }

    @Override
    public BigDecimal getMoney() {
        return this.money;
    }

    @Override
    public PayGroup getPayGroup() {
        return this.payGroup;
    }

    @Override
    public PayType getPayType() {
        return this.payType;
    }
}
