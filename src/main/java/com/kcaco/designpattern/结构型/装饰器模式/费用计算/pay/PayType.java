package com.kcaco.designpattern.结构型.装饰器模式.费用计算.pay;

import com.kcaco.designpattern.结构型.装饰器模式.费用计算.BaseEnum;

import java.util.Optional;

/**
 * @author gim 2021/12/2 8:28 下午
 */
public enum PayType implements BaseEnum<PayType> {

    WECHAT(1, "微信支付"),
    ALIPAY(2, "支付宝"),
    COIN(3, "虚拟币"),
    ACTIVITY(4, "活动"),

    PLUS(5, "会员"),

    LIMIT(6, "限额");


    PayType(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    private Integer code;
    private String name;

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public static Optional<PayType> of(Integer code) {
        return Optional.ofNullable(BaseEnum.parseByCode(PayType.class, code));
    }

}