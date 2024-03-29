package com.kcaco.design.结构型.装饰器模式.费用计算.rule;

import java.math.BigDecimal;

/**
 * 规则接口
 */
public interface FeeRule {

    /**
     * 获取配置的数值
     */
    BigDecimal getConfigValue();

    /**
     * 获取规则类型
     */
    FeeRuleTypeEnum getRuleType();

    /**
     * 规则的顺序
     */
    Integer getOrder();

}
