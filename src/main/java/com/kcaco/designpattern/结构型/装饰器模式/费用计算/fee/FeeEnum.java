package com.kcaco.designpattern.结构型.装饰器模式.费用计算.fee;

import com.kcaco.designpattern.结构型.装饰器模式.费用计算.BaseEnum;

import java.util.Optional;

/**
 * @author gim
 */
public enum FeeEnum implements BaseEnum<FeeEnum> {
    /**
     *
     */
    AMOUNT_GREATER_ERROR(2001, "抵扣金额过大,超过需要抵扣的金额"),
    FEE_ITEM_EMPTY(2002, "计费项为空");

    FeeEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    private final Integer code;
    private final String name;

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public static Optional<FeeEnum> of(Integer code) {
        return Optional.ofNullable(BaseEnum.parseByCode(FeeEnum.class, code));
    }

}
