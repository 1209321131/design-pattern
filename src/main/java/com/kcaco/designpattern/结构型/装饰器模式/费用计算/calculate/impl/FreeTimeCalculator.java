package com.kcaco.designpattern.结构型.装饰器模式.费用计算.calculate.impl;

import cn.hutool.extra.spring.SpringUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.calculate.AbstractCalculator;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.calculate.FeeCalculate;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.fee.FeeItemType;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.calculate.Unique;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.context.OrderInfo;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.mockbean.UserService;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.pay.PayGroup;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.pay.PayItem;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.pay.PayType;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.payitem.FreeTimePayItem;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;


/**
 * 免费时长计算器
 */
public class FreeTimeCalculator extends AbstractCalculator<OrderInfo> {

    /**
     * 免费时长
     */
    private final Integer freeTime;

    private Optional<BigDecimal> payItem = Optional.empty();

    public FreeTimeCalculator(FeeCalculate<OrderInfo> feeCalculate, Unique unique, Integer freeTime) {
        super(feeCalculate, unique);
        this.freeTime = freeTime;
    }

    @Override
    protected Map<FeeItemType, BigDecimal> currentDeductMap(Map<FeeItemType, BigDecimal> left, OrderInfo orderInfo) {
        BigDecimal serviceFee = left.get(FeeItemType.SERVICE_FEE);

        // 已使用的免费时长
        UserService userService = SpringUtil.getBean(UserService.class);
        Integer hasFreeTime = userService.hasEnjoyFreeTime(orderInfo.getUserId());

        Map<FeeItemType, BigDecimal> currentPay = Maps.newHashMap();

        // 如果免费时长未超
        if (freeTime > hasFreeTime) {
            currentPay.put(FeeItemType.SERVICE_FEE, serviceFee);
            this.payItem = Optional.of(serviceFee);
        }
        return currentPay;
    }

    @Override
    protected Map<FeeItemType, List<PayItem>> currentPayItemMap() {
        Map<FeeItemType, List<PayItem>> payItemMap = Maps.newHashMap();
        if (payItem.isPresent()) {
            List<PayItem> payItemList = Lists.newArrayList();

            FreeTimePayItem freeTimePayItem = new FreeTimePayItem(payItem.get(), PayType.ACTIVITY, PayGroup.VIRTUAL_PROPERTY);
            payItemList.add(freeTimePayItem);
            payItemMap.put(FeeItemType.SERVICE_FEE, payItemList);
        }

        return payItemMap;
    }
}
