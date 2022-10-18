package com.kcaco.designpattern.结构型.装饰器模式.费用计算.calculate.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.calculate.AbstractCalculator;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.calculate.FeeCalculate;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.fee.FeeItemTypeEnum;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.calculate.Unique;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.context.OrderInfo;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.mockbean.UserService;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.pay.PayGroupEnum;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.pay.PayItem;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.pay.PayItemTypeEnum;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.pay.impl.FreeTimesPayItem;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 免费次数计算器
 */
public class FreeTimesCalculator extends AbstractCalculator<OrderInfo> {

    /**
     * 免费次数
     */
    private final Integer freeTimes;

    private BigDecimal payItem;

    public FreeTimesCalculator(FeeCalculate<OrderInfo> feeCalculate, Unique unique, Integer freeTimes) {
        super(feeCalculate, unique);
        this.freeTimes = freeTimes;
    }

    @Override
    protected Map<FeeItemTypeEnum, BigDecimal> currentDeductMap(Map<FeeItemTypeEnum, BigDecimal> left, OrderInfo orderInfo) {
        BigDecimal serviceFee = left.get(FeeItemTypeEnum.SERVICE_FEE);

        // 已使用的免费次数
        UserService userService = SpringUtil.getBean(UserService.class);
        Integer hasFreeTimes = userService.hasEnjoyFreeTimes(orderInfo.getUserId());

        Map<FeeItemTypeEnum, BigDecimal> currentPay = Maps.newHashMap();

        // 如果免费次数大于用户已使用的免费次数
        if (freeTimes > hasFreeTimes) {
            currentPay.put(FeeItemTypeEnum.SERVICE_FEE, serviceFee);
            this.payItem = serviceFee;
        }
        return currentPay;
    }

    @Override
    protected Map<FeeItemTypeEnum, List<PayItem>> currentPayItemMap() {
        Map<FeeItemTypeEnum, List<PayItem>> payItemMap = Maps.newHashMap();
        if (ObjectUtil.isNotNull(payItem)) {
            List<PayItem> list = Lists.newArrayList();
            FreeTimesPayItem freeTimesPayItem = new FreeTimesPayItem(payItem, PayItemTypeEnum.WECHAT, PayGroupEnum.VIRTUAL_PROPERTY);
            list.add(freeTimesPayItem);
            payItemMap.put(FeeItemTypeEnum.SERVICE_FEE, list);
        }
        return payItemMap;
    }
}
