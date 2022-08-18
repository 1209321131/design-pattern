package com.kcaco.designpattern.结构型.装饰器模式.费用计算.payitem;

import java.math.BigDecimal;

import com.kcaco.designpattern.结构型.装饰器模式.费用计算.pay.AbstractPayItem;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.pay.PayGroup;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.pay.PayType;
import lombok.Getter;
import lombok.Setter;


public class PlusPayItem extends AbstractPayItem {

    @Setter
    @Getter
    private String plusNo;

    @Setter
    @Getter
    private Long userId;

    public PlusPayItem(BigDecimal money, PayType payType, PayGroup payGroup) {
        super(money, payType, payGroup);
    }
}
