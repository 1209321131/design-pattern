package com.kcaco.designpattern.结构型.装饰器模式.费用计算.rule;

import lombok.ToString;

import java.math.BigDecimal;

/**
 * 抽象规则接口
 */
@ToString
public class AbstractFeeRule implements FeeRule {

    private final BigDecimal configValue;
    private final FeeRuleType ruleType;
    private final Integer order;

    public AbstractFeeRule(BigDecimal configValue, FeeRuleType ruleType, Integer order) {
        this.configValue = configValue;
        this.ruleType = ruleType;
        this.order = order;
    }

    @Override
    public BigDecimal getConfigValue() {
        return configValue;
    }

    @Override
    public FeeRuleType getRuleType() {
        return ruleType;
    }

    @Override
    public Integer getOrder() {
        return order;
    }
}
