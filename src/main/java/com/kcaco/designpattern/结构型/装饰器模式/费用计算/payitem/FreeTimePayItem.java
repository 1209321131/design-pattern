package com.kcaco.designpattern.结构型.装饰器模式.费用计算.payitem;

import com.kcaco.designpattern.结构型.装饰器模式.费用计算.pay.AbstractPayItem;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.pay.PayGroup;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.pay.PayType;

import java.math.BigDecimal;

public class FreeTimePayItem extends AbstractPayItem {
    
    public FreeTimePayItem(BigDecimal money, PayType payType, PayGroup payGroup) {
        super(money, payType, payGroup);
    }
}
