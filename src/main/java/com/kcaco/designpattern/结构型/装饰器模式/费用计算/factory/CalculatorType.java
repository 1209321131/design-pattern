package com.kcaco.designpattern.结构型.装饰器模式.费用计算.factory;


import com.kcaco.designpattern.结构型.装饰器模式.费用计算.BaseEnum;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.calculate.Unique;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

@Getter
@AllArgsConstructor
public enum CalculatorType implements BaseEnum<CalculatorType>, Unique {

    /**
     * 免费时长
     */
    FREE_TIME(1, "免费时长"),

    /**
     * 免费次数
     */
    FREE_TIMES(2, "免费次数"),

    /**
     * 会员打折
     */
    PLUS_DISCOUNT(3, "会员打折"),

    /**
     * 最大限额
     */
    MAX_LIMIT(4, "最大限额");

    private final Integer code;
    private final String name;

    public static Optional<CalculatorType> of(Integer code) {
        return Optional.ofNullable(BaseEnum.parseByCode(CalculatorType.class, code));
    }

    @Override
    public Integer getUniqueCode() {
        return this.code;
    }
}