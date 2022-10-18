package com.kcaco.designpattern.结构型.装饰器模式.费用计算.rule.impl;

import java.math.BigDecimal;

import com.kcaco.designpattern.结构型.装饰器模式.费用计算.rule.AbstractFeeRule;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.rule.FeeRuleTypeEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * Description: 会员规则
 *
 * @author kcaco
 * @since 2022/10/18 8:43 PM
 */
public class PlusRule extends AbstractFeeRule {

    @Setter
    @Getter
    private String cardNo;

    public PlusRule(BigDecimal configValue, FeeRuleTypeEnum ruleType, Integer order) {
        super(configValue, ruleType, order);
    }
}
