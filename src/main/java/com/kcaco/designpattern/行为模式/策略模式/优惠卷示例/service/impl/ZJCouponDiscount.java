package com.kcaco.designpattern.行为模式.策略模式.优惠卷示例.service.impl;

import com.kcaco.designpattern.行为模式.策略模式.优惠卷示例.service.ICouponDiscount;

import java.math.BigDecimal;

/**
 * Description: 直减
 *
 * @author kcaco
 * @since 2021-11-04 00:48
 */
public class ZJCouponDiscount implements ICouponDiscount<BigDecimal> {

    /**
     * 直减计算
     * 1. 使用商品价格减去优惠价格
     * 2. 最低支付金额1元
     */
    @Override
    public BigDecimal discountAmount(BigDecimal couponInfo, BigDecimal skuPrice) {

        BigDecimal discountAmount = skuPrice.subtract(couponInfo);
        if (discountAmount.compareTo(BigDecimal.ZERO) < 1) {
            return BigDecimal.ONE;
        }
        return discountAmount;
    }
}
