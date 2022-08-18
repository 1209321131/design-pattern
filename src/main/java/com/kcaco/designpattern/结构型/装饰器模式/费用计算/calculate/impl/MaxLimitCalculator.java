package com.kcaco.designpattern.结构型.装饰器模式.费用计算.calculate.impl;

import cn.hutool.core.util.NumberUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.calculate.AbstractCalculator;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.calculate.FeeCalculate;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.fee.FeeItemType;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.calculate.Unique;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.context.OrderInfo;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.pay.PayGroup;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.pay.PayItem;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.pay.PayType;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.payitem.MaxLimitPayItem;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MaxLimitCalculator extends AbstractCalculator<OrderInfo> {

    private final BigDecimal maxAmount;

    private Optional<BigDecimal> limitDeductAmount = Optional.empty();

    public MaxLimitCalculator(FeeCalculate<OrderInfo> feeCalculate, Unique unique, BigDecimal maxAmount) {
        super(feeCalculate, unique);
        this.maxAmount = maxAmount;
    }

    @Override
    protected Map<FeeItemType, BigDecimal> currentDeductMap(Map<FeeItemType, BigDecimal> left, OrderInfo orderInfo) {
        // 如果剩余的钱比限额大，那么大于限额的钱就是抵扣的钱
        Map<FeeItemType, BigDecimal> maps = Maps.newHashMap();
        if (NumberUtil.isGreater(left.get(FeeItemType.SERVICE_FEE), maxAmount)) {
            maps.put(FeeItemType.SERVICE_FEE, NumberUtil.sub(left.get(FeeItemType.SERVICE_FEE), maxAmount));
            this.limitDeductAmount = Optional.of(NumberUtil.sub(left.get(FeeItemType.SERVICE_FEE), maxAmount));
        }
        return maps;
    }

    @Override
    protected Map<FeeItemType, List<PayItem>> currentPayItemMap() {
        Map<FeeItemType, List<PayItem>> map = Maps.newHashMap();
        if (limitDeductAmount.isPresent()) {
            List<PayItem> list = Lists.newArrayList();
            MaxLimitPayItem maxLimitPayItem = new MaxLimitPayItem(limitDeductAmount.get(), PayType.LIMIT, PayGroup.VIRTUAL_PROPERTY);
            list.add(maxLimitPayItem);
            map.put(FeeItemType.SERVICE_FEE, list);
        }
        return map;
    }
}
