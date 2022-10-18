package com.kcaco.designpattern.结构型.装饰器模式.费用计算.rule;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * 抽象规则接口
 */
@ToString
@Getter
@AllArgsConstructor
public class AbstractFeeRule implements FeeRule {

    /**
     * 值
     */
    private final BigDecimal configValue;

    /**
     * 规则类型
     */
    private final FeeRuleTypeEnum ruleType;

    /**
     * 规则顺序
     */
    private final Integer order;
}
