package com.kcaco.design.结构型.装饰器模式.费用计算.fee.impl;

import com.kcaco.design.结构型.装饰器模式.费用计算.context.OrderContext;
import com.kcaco.design.结构型.装饰器模式.费用计算.fee.AbstractFeeItem;
import com.kcaco.design.结构型.装饰器模式.费用计算.fee.FeeItemTypeEnum;

/**
 * Description: 停车费
 *
 * @author kcaco
 * @since 2022-08-18 17:14
 */
public class ParkingFeeItem extends AbstractFeeItem<OrderContext> {

    public ParkingFeeItem(OrderContext orderContext) {
        super(orderContext, FeeItemTypeEnum.SERVICE_FEE, orderContext.getTotalMoney());
    }

}
