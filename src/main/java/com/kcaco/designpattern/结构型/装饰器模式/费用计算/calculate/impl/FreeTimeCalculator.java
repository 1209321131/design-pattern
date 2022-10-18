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
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.pay.impl.FreeTimePayItem;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


/**
 * Description: 免费时长计算器
 *
 * @author kcaco
 * @since 2022/10/18 9:12 PM
 */
public class FreeTimeCalculator extends AbstractCalculator<OrderInfo> {

    /**
     * 免费时长
     */
    private final Integer freeTime;

    /**
     * 支付费用
     */
    private BigDecimal payItem;

    public FreeTimeCalculator(FeeCalculate<OrderInfo> feeCalculate, Unique unique, Integer freeTime) {
        super(feeCalculate, unique);
        this.freeTime = freeTime;
    }

    @Override
    protected Map<FeeItemTypeEnum, BigDecimal> currentDeductMap(Map<FeeItemTypeEnum, BigDecimal> left, OrderInfo orderInfo) {
        BigDecimal serviceFee = left.get(FeeItemTypeEnum.SERVICE_FEE);

        // 已使用的免费时长
        UserService userService = SpringUtil.getBean(UserService.class);
        Integer hasFreeTime = userService.hasEnjoyFreeTime(orderInfo.getUserId());

        // 当前费用项及其抵扣金额
        Map<FeeItemTypeEnum, BigDecimal> currentPay = Maps.newHashMap();

        // 如果免费时长未超
        if (freeTime > hasFreeTime) {
            currentPay.put(FeeItemTypeEnum.SERVICE_FEE, serviceFee);
            this.payItem = serviceFee;
        }
        return currentPay;
    }

    @Override
    protected Map<FeeItemTypeEnum, List<PayItem>> currentPayItemMap() {
        Map<FeeItemTypeEnum, List<PayItem>> payItemMap = Maps.newHashMap();
        if (ObjectUtil.isNotNull(payItem)) {
            List<PayItem> payItemList = Lists.newArrayList();

            FreeTimePayItem freeTimePayItem = new FreeTimePayItem(payItem, PayItemTypeEnum.ACTIVITY, PayGroupEnum.VIRTUAL_PROPERTY);
            payItemList.add(freeTimePayItem);
            payItemMap.put(FeeItemTypeEnum.SERVICE_FEE, payItemList);
        }

        return payItemMap;
    }
}
