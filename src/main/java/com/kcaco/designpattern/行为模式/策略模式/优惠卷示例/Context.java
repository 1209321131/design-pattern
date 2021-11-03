package com.kcaco.designpattern.行为模式.策略模式.优惠卷示例;

import com.kcaco.designpattern.行为模式.策略模式.优惠卷示例.service.ICouponDiscount;
import com.kcaco.designpattern.行为模式.策略模式.优惠卷示例.service.impl.ZJCouponDiscount;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * Description: 策略控制类
 *
 * @author kcaco
 * @since 2021-11-04 00:51
 */
@Slf4j
public class Context<T> {

    private final ICouponDiscount<T> couponDiscount;

    public Context(ICouponDiscount<T> couponDiscount) {
        this.couponDiscount = couponDiscount;
    }

    /**
     * 计算优惠
     *
     * @param couponInfo 优惠类型
     * @param skuPrice   商品原金额
     * @return 优惠后的价格
     */
    public BigDecimal discountAmount(T couponInfo, BigDecimal skuPrice) {
        return couponDiscount.discountAmount(couponInfo, skuPrice);
    }

    public static void main(String[] args) {
        // 直减;100-10，商品100元
        Context<BigDecimal> context = new Context<>(new ZJCouponDiscount());
        BigDecimal discountAmount = context.discountAmount(new BigDecimal(100), new BigDecimal(100));
        log.info("测试结果:直减优惠后⾦金金额 {}", discountAmount);
    }

}
