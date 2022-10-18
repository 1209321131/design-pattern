package com.kcaco.designpattern.结构型.装饰器模式.费用计算.pay.impl;

import java.math.BigDecimal;

import com.kcaco.designpattern.结构型.装饰器模式.费用计算.pay.AbstractPayItem;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.pay.PayGroupEnum;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.pay.PayItemTypeEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * Description: 会员支付项
 *
 * @author kcaco
 * @since 2022/10/18 9:22 PM
 */
public class PlusPayItem extends AbstractPayItem {

    @Setter
    @Getter
    private String plusNo;

    @Setter
    @Getter
    private Long userId;

    public PlusPayItem(BigDecimal money, PayItemTypeEnum payItemTypeEnum, PayGroupEnum payGroupEnum) {
        super(money, payItemTypeEnum, payGroupEnum);
    }
}
