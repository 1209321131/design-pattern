package com.kcaco.designpattern.结构型.装饰器模式.费用计算.test;


import com.google.common.collect.Lists;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.calculate.FeeCalculate;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.fee.FeeItem;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.fee.FeeItemTypeEnum;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.context.OrderInfo;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.factory.CalculatorFactory;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.fee.impl.ParkingFeeItem;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.pay.PayItem;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.rule.FeeRule;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.rule.FeeRuleTypeEnum;
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
        FreeTimesRule freeTimesRule = new FreeTimesRule(new BigDecimal(0), FeeRuleTypeEnum.FREE_TIMES, 3);
        FreeTimeRule freeTimeRule = new FreeTimeRule(new BigDecimal(1), FeeRuleTypeEnum.FREE_TIME, 1);
        PlusRule plusRule = new PlusRule(new BigDecimal("0.95"), FeeRuleTypeEnum.PLUS_RULE, 4);
        MaxLimitRule maxLimitRule = new MaxLimitRule(new BigDecimal("1.4"), FeeRuleTypeEnum.MAX_LIMIT, 5);

        List<FeeRule> ruleList = Lists.newArrayList();
        ruleList.add(freeTimesRule);
        ruleList.add(freeTimeRule);
        ruleList.add(plusRule);
        ruleList.add(maxLimitRule);

        // 费用项
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setCarNo("dddd");
        orderInfo.setParkTimes(3);
        orderInfo.setUserId(4L);
        orderInfo.setTotalMoney(new BigDecimal("30"));

        List<FeeItem<OrderInfo>> payItemList = Lists.newArrayList();
        ParkingFeeItem parkingFeeItem = new ParkingFeeItem(orderInfo);
        payItemList.add(parkingFeeItem);

        // 动态组装计算器
        List<FeeRule> sortRules = ruleList.stream()
                .sorted(Comparator.comparingInt(FeeRule::getOrder))
                .collect(Collectors.toList());
        FeeCalculate calculate = null;
        for (FeeRule feeRule : sortRules) {
            calculate = CalculatorFactory.getFeeCalculateByRuleType(calculate, feeRule);
        }

        Map<FeeItemTypeEnum, BigDecimal> waitPay = calculate.waitPayMoneyMap(payItemList);
        BigDecimal waitPayMoney = waitPay.get(FeeItemTypeEnum.SERVICE_FEE);
        System.out.println("费用总金额：" + orderInfo.getTotalMoney());
        System.out.println("待支付金额：" + waitPayMoney);

        Map<FeeItemTypeEnum, List<PayItem>> map = calculate.payItemMap(payItemList);
        System.out.println("-------费用项及其支付明细------");
        map.forEach((key, payItems) -> {
            System.out.println("费用项---------" + key.getName());
            System.out.println("费用项支付明细-------" + payItems.toString());
        });

        List<PayItem> payList = map.get(FeeItemTypeEnum.SERVICE_FEE);
        System.out.println("----------支付明细---------");
        payList.forEach(payItem -> {
            System.out.println("抵扣费用：" + payItem.getMoney());
            System.out.println("抵扣类型：" + payItem.getPayType());
            System.out.println("抵扣类型费种：" + payItem.getPayGroup());
            System.out.println("");
        });
    }

}
