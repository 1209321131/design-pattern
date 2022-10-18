package com.kcaco.designpattern.结构型.装饰器模式.费用计算.rule.impl;

import com.kcaco.designpattern.结构型.装饰器模式.费用计算.rule.AbstractFeeRule;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.rule.FeeRuleTypeEnum;

import java.math.BigDecimal;


/**
 * Description: 费用上限规则
 *
 * @author kcaco
 * @since 2022/10/18 8:43 PM
 */
public class MaxLimitRule extends AbstractFeeRule {

    public MaxLimitRule(BigDecimal configValue, FeeRuleTypeEnum ruleType, Integer order) {
        super(configValue, ruleType, order);
    }
}
