package com.kcaco.design.行为型.策略模式.优惠卷示例.service.impl;

import com.kcaco.design.行为型.策略模式.优惠卷示例.service.ICouponDiscount;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Description: 满减
 *
 * @author kcaco
 * @since 2021-11-04 00:44
 */
public class MJCouponDiscount implements ICouponDiscount<Map<String, String>> {


    /**
     * 满减计算
     * 1. 判断满⾜x元后-n元，否则不减
     * 2. 最低⽀付金额1元
     */
    @Override
    public BigDecimal discountAmount(Map<String, String> couponInfo, BigDecimal skuPrice) {
        String x = couponInfo.get("x");
        String o = couponInfo.get("n");

        // ⼩小于商品⾦金金额条件的，直接返回商品原价
        if (skuPrice.compareTo(new BigDecimal(x)) < 0) {
            return skuPrice;
        }

        // 减去优惠⾦金金额判断
        BigDecimal discountAmount = skuPrice.subtract(new BigDecimal(o));
        if (discountAmount.compareTo(BigDecimal.ZERO) < 1) {
            return BigDecimal.ONE;
        }
        return discountAmount;

    }
}
