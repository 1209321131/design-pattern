package com.kcaco.designpattern.结构型.装饰器模式.费用计算.fee;

import com.kcaco.designpattern.结构型.装饰器模式.费用计算.base.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

/**
 * Description: 费用类型枚举
 *
 * @author kcaco
 * @since 2022/10/18 8:49 PM
 */
@Getter
@AllArgsConstructor
public enum FeeItemTypeEnum implements BaseEnum<FeeItemTypeEnum> {

    /**
     * 服务费
     */
    SERVICE_FEE(1, "服务费"),
    /**
     * 电费
     */
    ELECTRIC_FEE(2, "电费"),
    /**
     * 超重费
     */
    OVER_WEIGHT_FEE(3, "超重费"),
    /**
     * 超时费
     */
    OVER_TIME_FEE(4, "超时费");

    private final Integer code;
    private final String name;

    public static Optional<FeeItemTypeEnum> of(Integer code) {
        return Optional.ofNullable(BaseEnum.parseByCode(FeeItemTypeEnum.class, code));
    }

}
