package com.kcaco.designpattern.结构型.装饰器模式.费用计算.test;


import com.google.common.collect.Lists;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.calculate.FeeCalculate;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.fee.FeeItem;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.fee.FeeItemType;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.context.OrderInfo;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.factory.CalculatorFactory;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.fee.ParkingFeeItem;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.pay.PayItem;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.rule.FeeRule;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.rule.FeeRuleType;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.rule.impl.FreeTimeRule;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.rule.impl.FreeTimesRule;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.rule.impl.MaxLimitRule;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.rule.impl.PlusRule;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class FeeCalculateTest {

    public void testFee() {

        // 计算规则
        List<FeeRule> ruleList = Lists.newArrayList();
        FreeTimesRule freeTimesRule = new FreeTimesRule(new BigDecimal(0), FeeRuleType.FREE_TIMES, 3);
        FreeTimeRule freeTimeRule = new FreeTimeRule(new BigDecimal(1), FeeRuleType.FREE_TIME, 1);
        PlusRule plusRule = new PlusRule(new BigDecimal("0.95"), FeeRuleType.PLUS_RULE, 4);
        MaxLimitRule maxLimitRule = new MaxLimitRule(new BigDecimal("1.4"), FeeRuleType.MAX_LIMIT, 5);

        ruleList.add(freeTimesRule);
        ruleList.add(freeTimeRule);
        ruleList.add(plusRule);
        ruleList.add(maxLimitRule);


        // 费用项
        List<FeeItem> payItemList = Lists.newArrayList();
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setCarNo("dddd");
        orderInfo.setParkTimes(3);
        orderInfo.setUserId(4L);
        orderInfo.setTotalMoney(new BigDecimal("30"));
        ParkingFeeItem parkingFeeItem = new ParkingFeeItem(orderInfo);
        payItemList.add(parkingFeeItem);

        // 动态组装计算器
        List<FeeRule> sortRules = ruleList.stream().sorted(Comparator.comparingInt(FeeRule::getOrder)).collect(Collectors.toList());
        FeeCalculate calculate = null;
        for (FeeRule feeRule : sortRules) {
            calculate = CalculatorFactory.getFeeCalculateByRuleType(calculate, feeRule);
        }

        Map<FeeItemType, BigDecimal> waitPay = calculate.waitPayMoneyMap(payItemList);

        BigDecimal waitPayMoney = waitPay.get(FeeItemType.SERVICE_FEE);
        System.out.println("待支付金额" + waitPayMoney);

        Map<FeeItemType, List<PayItem>> map = calculate.payItemMap(payItemList);
        map.forEach((key, value) -> {
            System.out.println("FeeItemType---------" + key.getName());
            System.out.println("List<PayItem>-------" + value.toString());
        });

        List<PayItem> payList = map.get(FeeItemType.SERVICE_FEE);
        payList.forEach(payItem -> {
            System.out.println(payItem.getMoney());
            System.out.println(payItem.getPayType());
            System.out.println(payItem.getPayGroup());
        });
    }

}
