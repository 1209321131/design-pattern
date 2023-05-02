package com.kcaco.designpattern.结构型.装饰器模式.费用计算.calculate.impl;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.calculate.AbstractFeeCalculator;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.calculate.FeeCalculate;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.fee.FeeItemTypeEnum;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.calculate.Unique;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.context.OrderContext;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.mockbean.UserService;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.pay.PayGroupEnum;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.pay.PayItem;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.pay.PayItemTypeEnum;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.pay.impl.PlusPayItem;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * plus 会员
 */
public class PlusRuleFeeCalculator extends AbstractFeeCalculator<OrderContext> {

    /**
     * 抵扣（打折）
     */
    private final BigDecimal discount;

    /**
     * 用户信息
     */
    private UserService.UserInfo userInfo;

    private BigDecimal payMoney;

    public PlusRuleFeeCalculator(FeeCalculate<OrderContext> feeCalculate, Unique unique, BigDecimal discount) {
        super(feeCalculate, unique);
        this.discount = discount;
    }

    @Override
    protected Map<FeeItemTypeEnum, BigDecimal> currentDeductMap(Map<FeeItemTypeEnum, BigDecimal> left, OrderContext orderContext) {
        BigDecimal serviceFee = left.get(FeeItemTypeEnum.SERVICE_FEE);

        Map<FeeItemTypeEnum, BigDecimal> map = Maps.newHashMap();

        // 查询用户信息
        UserService userService = SpringUtil.getBean(UserService.class);
        userInfo = userService.getUserInfo(orderContext.getUserId());

        if (userInfo.isPlus()) {
            if (NumberUtil.isGreater(serviceFee, BigDecimal.ZERO)) {
                BigDecimal ductAmount = NumberUtil.sub(serviceFee, NumberUtil.mul(discount, serviceFee));
                map.put(FeeItemTypeEnum.SERVICE_FEE, ductAmount);
                this.payMoney = ductAmount;
            }
        }
        return map;
    }

    @Override
    protected Map<FeeItemTypeEnum, List<PayItem>> currentPayItemMap() {
        Map<FeeItemTypeEnum, List<PayItem>> maps = Maps.newHashMap();
        if (ObjectUtil.isNotNull(payMoney)) {
            List<PayItem> list = Lists.newArrayList();
            PlusPayItem plusPayItem = new PlusPayItem(payMoney, PayItemTypeEnum.PLUS, PayGroupEnum.VIRTUAL_PROPERTY);
            plusPayItem.setPlusNo(userInfo.getPlusNo());
            list.add(plusPayItem);
            maps.put(FeeItemTypeEnum.SERVICE_FEE, list);
        }
        return maps;
    }

}
