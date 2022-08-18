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
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.payitem.FreeTimesPayItem;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * 免费次数计算器
 */
public class FreeTimesCalculator extends AbstractCalculator<OrderInfo> {

    /**
     * 免费次数
     */
    private final Integer freeTimes;

    private Optional<BigDecimal> payItem = Optional.empty();

    public FreeTimesCalculator(FeeCalculate<OrderInfo> feeCalculate, Unique unique, Integer freeTimes) {
        super(feeCalculate, unique);
        this.freeTimes = freeTimes;
    }

    @Override
    protected Map<FeeItemType, BigDecimal> currentDeductMap(Map<FeeItemType, BigDecimal> left, OrderInfo orderInfo) {
        BigDecimal serviceFee = left.get(FeeItemType.SERVICE_FEE);

        // 已使用的免费次数
        UserService userService = SpringUtil.getBean(UserService.class);
        Integer hasFreeTimes = userService.hasEnjoyFreeTimes(orderInfo.getUserId());

        Map<FeeItemType, BigDecimal> currentPay = Maps.newHashMap();

        // 如果免费次数大于用户已使用的免费次数
        if (freeTimes > hasFreeTimes) {
            currentPay.put(FeeItemType.SERVICE_FEE, serviceFee);
            this.payItem = Optional.of(serviceFee);
        }
        return currentPay;
    }

    @Override
    protected Map<FeeItemType, List<PayItem>> currentPayItemMap() {
        Map<FeeItemType, List<PayItem>> payItemMap = Maps.newHashMap();
        if (payItem.isPresent()) {
            List<PayItem> list = Lists.newArrayList();
            FreeTimesPayItem freeTimesPayItem = new FreeTimesPayItem(payItem.get(), PayType.WECHAT, PayGroup.VIRTUAL_PROPERTY);
            list.add(freeTimesPayItem);
            payItemMap.put(FeeItemType.SERVICE_FEE, list);
        }
        return payItemMap;
    }
}
