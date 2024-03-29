package com.kcaco.design.结构型.装饰器模式.费用计算.test;


import com.google.common.collect.Lists;
import com.kcaco.design.结构型.装饰器模式.费用计算.calculate.FeeCalculate;
import com.kcaco.design.结构型.装饰器模式.费用计算.fee.FeeItem;
import com.kcaco.design.结构型.装饰器模式.费用计算.fee.FeeItemTypeEnum;
import com.kcaco.design.结构型.装饰器模式.费用计算.context.OrderContext;
import com.kcaco.design.结构型.装饰器模式.费用计算.factory.CalculatorFactory;
import com.kcaco.design.结构型.装饰器模式.费用计算.fee.impl.ParkingFeeItem;
import com.kcaco.design.结构型.装饰器模式.费用计算.pay.PayItem;
import com.kcaco.design.结构型.装饰器模式.费用计算.rule.FeeRule;
import com.kcaco.design.结构型.装饰器模式.费用计算.rule.FeeRuleTypeEnum;
import com.kcaco.design.结构型.装饰器模式.费用计算.rule.impl.FreeTimeRule;
import com.kcaco.design.结构型.装饰器模式.费用计算.rule.impl.FreeTimesRule;
import com.kcaco.design.结构型.装饰器模式.费用计算.rule.impl.MaxLimitRule;
import com.kcaco.design.结构型.装饰器模式.费用计算.rule.impl.PlusRule;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class FeeCalculateTest {

    public void testFee() {

        // ---------------------------------------费用项---------------------------------------
        // 订单信息
        OrderContext orderContext = new OrderContext();
        orderContext.setCarNo("dddd");
        orderContext.setParkTimes(3);
        orderContext.setUserId(4L);
        orderContext.setTotalMoney(new BigDecimal("30"));

        // 停车费
        ParkingFeeItem parkingFeeItem = new ParkingFeeItem(orderContext);

        List<FeeItem<OrderContext>> feeItemList = Lists.newArrayList();
        feeItemList.add(parkingFeeItem);


        // ---------------------------------------计算规则---------------------------------------
        FreeTimesRule freeTimesRule = new FreeTimesRule(new BigDecimal(0), FeeRuleTypeEnum.FREE_TIMES, 3);
        FreeTimeRule freeTimeRule = new FreeTimeRule(new BigDecimal(1), FeeRuleTypeEnum.FREE_TIME, 1);
        PlusRule plusRule = new PlusRule(new BigDecimal("0.95"), FeeRuleTypeEnum.PLUS_RULE, 4);
        MaxLimitRule maxLimitRule = new MaxLimitRule(new BigDecimal("30"), FeeRuleTypeEnum.MAX_LIMIT, 5);

        List<FeeRule> ruleList = Lists.newArrayList();
        ruleList.add(freeTimesRule);
        ruleList.add(freeTimeRule);
        ruleList.add(plusRule);
        ruleList.add(maxLimitRule);

        // ---------------------------------------动态组装计算器---------------------------------------
        List<FeeRule> sortRules = ruleList.stream()
                .sorted(Comparator.comparingInt(FeeRule::getOrder))
                .collect(Collectors.toList());
        FeeCalculate calculate = null;
        for (FeeRule feeRule : sortRules) {
            calculate = CalculatorFactory.getFeeCalculateByRuleType(calculate, feeRule);
        }

        // ---------------------------------------计算费用---------------------------------------
        // 每个费用项对应的实际待支付费用
        Map<FeeItemTypeEnum, BigDecimal> waitPay = calculate.waitPayMoneyMap(feeItemList);
        BigDecimal waitPayMoney = waitPay.get(FeeItemTypeEnum.SERVICE_FEE);
        System.out.println("费用总金额：" + orderContext.getTotalMoney());
        System.out.println("待支付金额：" + waitPayMoney);

        // 每个费用项对应的抵扣明细
        Map<FeeItemTypeEnum, List<PayItem>> map = calculate.payItemMap(feeItemList);
        System.out.println("-------费用项及其支付明细------");
        map.forEach((key, payItems) -> {
            System.out.println("费用项---------" + key.getName());
            System.out.println("费用项支付明细-------" + payItems.toString());
        });

        // 支付明细
        List<PayItem> payList = map.get(FeeItemTypeEnum.SERVICE_FEE);
        System.out.println("----------支付明细---------");
        payList.forEach(payItem -> {
            System.out.println("抵扣费用：" + payItem.getMoney());
            System.out.println("抵扣类型：" + payItem.getPayType());
            System.out.println("抵扣类型分组：" + payItem.getPayGroup());
            System.out.println("");
        });
    }

}
