package com.kcaco.designpattern.结构型.装饰器模式.费用计算.rule.impl;

import com.kcaco.designpattern.结构型.装饰器模式.费用计算.rule.AbstractFeeRule;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.rule.FeeRuleType;

import java.math.BigDecimal;

/**
 * 减免次数规则
 */
public class FreeTimesRule extends AbstractFeeRule {

    public FreeTimesRule(BigDecimal configValue, FeeRuleType ruleType, Integer order) {
        super(configValue, ruleType, order);
    }
}
