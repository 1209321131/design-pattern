package com.kcaco.designpattern.结构型.装饰器模式.费用计算.pay;

import com.kcaco.designpattern.结构型.装饰器模式.费用计算.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

/**
 * @author gim 2021/12/2 8:28 下午
 */
@Getter
@AllArgsConstructor
public enum PayItemTypeEnum implements BaseEnum<PayItemTypeEnum> {

    /**
     * 微信支付
     */
    WECHAT(1, "微信支付"),

    /**
     * 支付宝
     */
    ALIPAY(2, "支付宝"),

    /**
     * 虚拟币
     */
    COIN(3, "虚拟币"),

    /**
     * 活动
     */
    ACTIVITY(4, "活动"),

    /**
     * 会员
     */
    PLUS(5, "会员"),

    /**
     * 限额
     */
    LIMIT(6, "限额");

    private final Integer code;
    private final String name;

    public static Optional<PayItemTypeEnum> of(Integer code) {
        return Optional.ofNullable(BaseEnum.parseByCode(PayItemTypeEnum.class, code));
    }

}