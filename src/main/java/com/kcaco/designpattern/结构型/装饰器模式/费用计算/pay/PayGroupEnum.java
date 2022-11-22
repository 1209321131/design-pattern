package com.kcaco.designpattern.结构型.装饰器模式.费用计算.pay;

import com.kcaco.designpattern.结构型.装饰器模式.费用计算.base.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

/**
 * Description: 支付方式分组
 *
 * @author kcaco
 * @since 2022/10/18 9:21 PM
 */
@Getter
@AllArgsConstructor
public enum PayGroupEnum implements BaseEnum<PayGroupEnum> {

    THIRD_PAY(1, "三方支付"),
    PLATFORM_PAY(2, "平台支付"),
    VIRTUAL_PROPERTY(3, "虚拟资产"),
    BANK(4, "银行卡支付"),
    COUPON(5, "优惠劵");

    private final Integer code;
    private final String name;

    public static Optional<PayGroupEnum> of(Integer code) {
        return Optional.ofNullable(BaseEnum.parseByCode(PayGroupEnum.class, code));
    }

}
