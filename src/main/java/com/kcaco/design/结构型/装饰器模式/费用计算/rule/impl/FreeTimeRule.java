package com.kcaco.design.结构型.装饰器模式.费用计算.rule.impl;

import com.kcaco.design.结构型.装饰器模式.费用计算.rule.AbstractFeeRule;
import com.kcaco.design.结构型.装饰器模式.费用计算.rule.FeeRuleTypeEnum;

import java.math.BigDecimal;

/**
 * Description: 免费时长规则
 *
 * @author kcaco
 * @since 2022/10/18 8:38 PM
 */
public class FreeTimeRule extends AbstractFeeRule {

    public FreeTimeRule(BigDecimal configValue, FeeRuleTypeEnum ruleType, Integer order) {
        super(configValue, ruleType, order);
    }
}
