package com.kcaco.designpattern.结构型.装饰器模式.费用计算.fee;

import com.kcaco.designpattern.结构型.装饰器模式.费用计算.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

/**
 * Description: 费用结果枚举
 *
 * @author kcaco
 * @since 2022/10/18 8:48 PM
 */
@Getter
@AllArgsConstructor
public enum FeeResultEnum implements BaseEnum<FeeResultEnum> {

    /**
     * 抵扣金额过大
     */
    AMOUNT_GREATER_ERROR(2001, "抵扣金额过大,超过需要抵扣的金额"),

    /**
     * 计费项为空
     */
    FEE_ITEM_EMPTY(2002, "计费项为空");

    private final Integer code;
    private final String name;

    public static Optional<FeeResultEnum> of(Integer code) {
        return Optional.ofNullable(BaseEnum.parseByCode(FeeResultEnum.class, code));
    }

}
