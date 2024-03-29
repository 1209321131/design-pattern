package com.kcaco.design.结构型.装饰器模式.费用计算.pay;

import com.kcaco.design.结构型.装饰器模式.费用计算.base.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

/**
 * Description: 支付类型
 *
 * @author kcaco
 * @since 2022/11/23 1:53 AM
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
