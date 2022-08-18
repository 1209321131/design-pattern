package com.kcaco.designpattern.结构型.装饰器模式.费用计算.rule.impl;

import java.math.BigDecimal;

import com.kcaco.designpattern.结构型.装饰器模式.费用计算.rule.AbstractFeeRule;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.rule.FeeRuleType;
import lombok.Getter;
import lombok.Setter;

/**
 * 会员
 */
public class PlusRule extends AbstractFeeRule {

    @Setter
    @Getter
    private String cardNo;

    public PlusRule(BigDecimal configValue, FeeRuleType ruleType, Integer order) {
        super(configValue, ruleType, order);
    }
}
