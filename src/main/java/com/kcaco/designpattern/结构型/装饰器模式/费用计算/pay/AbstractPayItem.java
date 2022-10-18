package com.kcaco.designpattern.结构型.装饰器模式.费用计算.pay;

import lombok.ToString;

import java.math.BigDecimal;

/**
 * @author gim 2021/12/2 8:31 下午
 */
@ToString
public abstract class AbstractPayItem implements PayItem {

    private final BigDecimal money;

    private final PayItemTypeEnum payItemTypeEnum;

    private final PayGroupEnum payGroupEnum;

    public AbstractPayItem(BigDecimal money, PayItemTypeEnum payItemTypeEnum, PayGroupEnum payGroupEnum) {
        this.money = money;
        this.payItemTypeEnum = payItemTypeEnum;
        this.payGroupEnum = payGroupEnum;
    }

    @Override
    public BigDecimal getMoney() {
        return this.money;
    }

    @Override
    public PayGroupEnum getPayGroup() {
        return this.payGroupEnum;
    }

    @Override
    public PayItemTypeEnum getPayType() {
        return this.payItemTypeEnum;
    }
}
