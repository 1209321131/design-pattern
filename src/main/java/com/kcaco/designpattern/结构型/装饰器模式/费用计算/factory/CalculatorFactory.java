package com.kcaco.designpattern.结构型.装饰器模式.费用计算.factory;


import com.kcaco.designpattern.结构型.装饰器模式.费用计算.calculate.FeeCalculate;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.calculate.impl.FreeTimeCalculator;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.calculate.impl.FreeTimesCalculator;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.calculate.impl.MaxLimitCalculator;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.calculate.impl.PlusRuleCalculator;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.rule.FeeRule;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.rule.FeeRuleType;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.rule.impl.FreeTimeRule;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.rule.impl.FreeTimesRule;

import java.util.Objects;


public class CalculatorFactory {

    public static FeeCalculate getFeeCalculateByRuleType(FeeCalculate calculate, FeeRule rule) {
        if (Objects.equals(FeeRuleType.FREE_TIME, rule.getRuleType())) {
            FreeTimeRule time = (FreeTimeRule) rule;
            return new FreeTimeCalculator(calculate, CalculatorType.FREE_TIME, time.getConfigValue().intValue());
        } else if (Objects.equals(FeeRuleType.FREE_TIMES, rule.getRuleType())) {
            FreeTimesRule timesRule = (FreeTimesRule) rule;
            return new FreeTimesCalculator(calculate, CalculatorType.FREE_TIMES, timesRule.getConfigValue().intValue());
        } else if (Objects.equals(FeeRuleType.PLUS_RULE, rule.getRuleType())) {
            return new PlusRuleCalculator(calculate, CalculatorType.PLUS_DISCOUNT, rule.getConfigValue());
        } else if (Objects.equals(FeeRuleType.MAX_LIMIT, rule.getRuleType())) {
            return new MaxLimitCalculator(calculate, CalculatorType.MAX_LIMIT, rule.getConfigValue());
        }
        return null;
    }


}
