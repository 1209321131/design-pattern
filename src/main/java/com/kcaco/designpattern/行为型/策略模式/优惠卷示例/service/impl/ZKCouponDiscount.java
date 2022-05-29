package com.kcaco.designpattern.行为型.策略模式.优惠卷示例.service.impl;

import com.kcaco.designpattern.行为型.策略模式.优惠卷示例.service.ICouponDiscount;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Description: 折扣
 *
 * @author kcaco
 * @since 2021-11-04 00:49
 */
public class ZKCouponDiscount implements ICouponDiscount<BigDecimal> {

    /**
     * 折扣计算
     * 1. 使⽤用商品价格乘以折扣⽐例，为最后支付金额
     * 2. 保留两位⼩小数
     * 3. 最低⽀付金额1元
     */
    @Override
    public BigDecimal discountAmount(BigDecimal couponInfo, BigDecimal skuPrice) {
        BigDecimal discountAmount = skuPrice.multiply(couponInfo).setScale(2, RoundingMode.HALF_UP);

        if (discountAmount.compareTo(BigDecimal.ZERO) < 1) {
            return BigDecimal.ONE;
        }
        return discountAmount;
    }
}
