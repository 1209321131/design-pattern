package com.kcaco.designpattern.行为型.策略模式.优惠卷示例;

import java.math.BigDecimal;

/**
 * Description: if-else实现计算优惠金额
 *
 * @author kcaco
 * @since 2021-11-04 01:01
 */
public class CouponDiscountService {

    /**
     * 计算优惠后的金额
     *
     * @param type        优惠类型
     * @param typeContent 优惠金额
     * @param skuPrice    商品金额
     * @param typeExt     满减金额
     * @return
     */
    public BigDecimal discountAmount(Integer type, BigDecimal typeContent, BigDecimal skuPrice, BigDecimal typeExt) {
        // 1. 直减券
        if (1 == type) {
            return skuPrice.subtract(typeContent);
        }

        // 2. 满减券
        if (2 == type) {
            if (skuPrice.compareTo(typeExt) < 0) {
                return skuPrice;
            }
            return skuPrice.subtract(typeContent);
        }

        // 3. 折扣券
        if (3 == type) {
            return skuPrice.multiply(typeContent);
        }
        return BigDecimal.ZERO;
    }

}
