package com.kcaco.designpattern.行为型.策略模式.优惠卷示例.service;

import java.math.BigDecimal;

/**
 * Description: 优惠卷策略接口
 *
 * @author kcaco
 * @since 2021-11-04 00:44
 */
public interface ICouponDiscount<T> {

    /**
     * 优惠券⾦额计算
     *
     * @param couponInfo 券折扣信息：直减、满减、折扣
     * @param skuPrice   商品原金额
     * @return 优惠后的金额
     */
    BigDecimal discountAmount(T couponInfo, BigDecimal skuPrice);
}