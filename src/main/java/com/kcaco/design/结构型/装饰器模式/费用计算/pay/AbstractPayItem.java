package com.kcaco.design.结构型.装饰器模式.费用计算.pay;

import lombok.ToString;

import java.math.BigDecimal;

/**
 * @author gim 2021/12/2 8:31 下午
 */
@ToString
public abstract class AbstractPayItem implements PayItem {

    /**
     * 钱、时间等抽象
     */
    private final BigDecimal money;

    /**
     * 支付类型
     */
    private final PayItemTypeEnum payItemTypeEnum;

    /**
     * 支付分组
     */
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
