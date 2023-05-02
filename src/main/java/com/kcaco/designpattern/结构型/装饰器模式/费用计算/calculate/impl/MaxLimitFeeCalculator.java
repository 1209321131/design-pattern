package com.kcaco.designpattern.结构型.装饰器模式.费用计算.calculate.impl;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.ObjectUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.calculate.AbstractFeeCalculator;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.calculate.FeeCalculate;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.fee.FeeItemTypeEnum;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.calculate.Unique;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.context.OrderContext;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.pay.PayGroupEnum;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.pay.PayItem;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.pay.PayItemTypeEnum;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.pay.impl.MaxLimitPayItem;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class MaxLimitFeeCalculator extends AbstractFeeCalculator<OrderContext> {

    private final BigDecimal maxAmount;

    private BigDecimal limitDeductAmount;

    public MaxLimitFeeCalculator(FeeCalculate<OrderContext> feeCalculate, Unique unique, BigDecimal maxAmount) {
        super(feeCalculate, unique);
        this.maxAmount = maxAmount;
    }

    @Override
    protected Map<FeeItemTypeEnum, BigDecimal> currentDeductMap(Map<FeeItemTypeEnum, BigDecimal> currentWaitPayMoney, OrderContext orderContext) {
        // 如果剩余的钱比限额大，那么大于限额的钱就是抵扣的钱
        Map<FeeItemTypeEnum, BigDecimal> maps = Maps.newHashMap();
        if (NumberUtil.isGreater(currentWaitPayMoney.get(FeeItemTypeEnum.SERVICE_FEE), maxAmount)) {
            BigDecimal deductAmount = NumberUtil.sub(currentWaitPayMoney.get(FeeItemTypeEnum.SERVICE_FEE), maxAmount);
            maps.put(FeeItemTypeEnum.SERVICE_FEE, deductAmount);
            this.limitDeductAmount = deductAmount;
        }
        return maps;
    }

    @Override
    protected Map<FeeItemTypeEnum, List<PayItem>> currentPayItemMap() {
        Map<FeeItemTypeEnum, List<PayItem>> map = Maps.newHashMap();
        if (ObjectUtil.isNotNull(limitDeductAmount)) {
            List<PayItem> list = Lists.newArrayList();
            MaxLimitPayItem maxLimitPayItem = new MaxLimitPayItem(limitDeductAmount, PayItemTypeEnum.LIMIT, PayGroupEnum.VIRTUAL_PROPERTY);
            list.add(maxLimitPayItem);
            map.put(FeeItemTypeEnum.SERVICE_FEE, list);
        }
        return map;
    }
}
