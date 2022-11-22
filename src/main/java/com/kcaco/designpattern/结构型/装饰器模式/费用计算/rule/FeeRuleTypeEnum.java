package com.kcaco.designpattern.结构型.装饰器模式.费用计算.rule;

import com.kcaco.designpattern.结构型.装饰器模式.费用计算.base.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

/**
 * Description:
 *
 * @author kcaco
 * @since 2022/10/18 8:36 PM
 */
@Getter
@AllArgsConstructor
public enum FeeRuleTypeEnum implements BaseEnum<FeeRuleTypeEnum> {

    /**
     * 免费次数
     */
    FREE_TIMES(1, "免费次数"),

    /**
     * 免费时长规则
     */
    FREE_TIME(2, "免费时长规则"),

    /**
     * plus会员规则
     */
    PLUS_RULE(3, "plus会员规则"),

    /**
     * 限额规则
     */
    MAX_LIMIT(4, "限额规则");

    private final Integer code;
    private final String name;

    public static Optional<FeeRuleTypeEnum> of(Integer code) {
        return Optional.ofNullable(BaseEnum.parseByCode(FeeRuleTypeEnum.class, code));
    }

}
