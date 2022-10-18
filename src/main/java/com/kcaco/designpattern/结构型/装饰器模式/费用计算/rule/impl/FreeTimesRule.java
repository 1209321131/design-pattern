package com.kcaco.designpattern.结构型.装饰器模式.费用计算.rule.impl;

import com.kcaco.designpattern.结构型.装饰器模式.费用计算.rule.AbstractFeeRule;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.rule.FeeRuleTypeEnum;

import java.math.BigDecimal;


/**
 * Description: 减免次数规则
 *
 * @author kcaco
 * @since 2022/10/18 8:41 PM
 */
public class FreeTimesRule extends AbstractFeeRule {

    public FreeTimesRule(BigDecimal configValue, FeeRuleTypeEnum ruleType, Integer order) {
        super(configValue, ruleType, order);
    }
}
