package com.kcaco.design.结构型.装饰器模式.费用计算.factory;


import com.kcaco.design.结构型.装饰器模式.费用计算.calculate.CalculatorType;
import com.kcaco.design.结构型.装饰器模式.费用计算.calculate.FeeCalculate;
import com.kcaco.design.结构型.装饰器模式.费用计算.calculate.impl.FreeTimeFeeCalculator;
import com.kcaco.design.结构型.装饰器模式.费用计算.calculate.impl.FreeTimesFeeCalculator;
import com.kcaco.design.结构型.装饰器模式.费用计算.calculate.impl.MaxLimitFeeCalculator;
import com.kcaco.design.结构型.装饰器模式.费用计算.calculate.impl.PlusRuleFeeCalculator;
import com.kcaco.design.结构型.装饰器模式.费用计算.rule.FeeRule;
import com.kcaco.design.结构型.装饰器模式.费用计算.rule.FeeRuleTypeEnum;
import com.kcaco.design.结构型.装饰器模式.费用计算.rule.impl.FreeTimeRule;
import com.kcaco.design.结构型.装饰器模式.费用计算.rule.impl.FreeTimesRule;

import java.util.Objects;


/**
 * Description: 计算器工厂
 *
 * @author kcaco
 * @since 2022/10/18 9:02 PM
 */
public class CalculatorFactory {

    /**
     * Description: 根据费用规则，获取对应的计算器
     *
     * @author kcaco
     * @since 2022/10/18 9:02 PM
     */
    public static FeeCalculate getFeeCalculateByRuleType(FeeCalculate calculate, FeeRule rule) {
        if (Objects.equals(FeeRuleTypeEnum.FREE_TIME, rule.getRuleType())) {
            FreeTimeRule time = (FreeTimeRule) rule;
            return new FreeTimeFeeCalculator(calculate, CalculatorType.FREE_TIME, time.getConfigValue().intValue());
        } else if (Objects.equals(FeeRuleTypeEnum.FREE_TIMES, rule.getRuleType())) {
            FreeTimesRule timesRule = (FreeTimesRule) rule;
            return new FreeTimesFeeCalculator(calculate, CalculatorType.FREE_TIMES, timesRule.getConfigValue().intValue());
        } else if (Objects.equals(FeeRuleTypeEnum.PLUS_RULE, rule.getRuleType())) {
            return new PlusRuleFeeCalculator(calculate, CalculatorType.PLUS_DISCOUNT, rule.getConfigValue());
        } else if (Objects.equals(FeeRuleTypeEnum.MAX_LIMIT, rule.getRuleType())) {
            return new MaxLimitFeeCalculator(calculate, CalculatorType.MAX_LIMIT, rule.getConfigValue());
        }
        return null;
    }


}
