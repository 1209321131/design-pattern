package com.kcaco.designpattern.结构型.装饰器模式.费用计算.fee.impl;

import com.kcaco.designpattern.结构型.装饰器模式.费用计算.context.OrderInfo;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.fee.AbstractFeeItem;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.fee.FeeItemTypeEnum;

/**
 * Description: 停车费
 *
 * @author kcaco
 * @since 2022-08-18 17:14
 */
public class ParkingFeeItem extends AbstractFeeItem<OrderInfo> {

    public ParkingFeeItem(OrderInfo orderInfo) {
        super(orderInfo, FeeItemTypeEnum.SERVICE_FEE, orderInfo.getTotalMoney());
    }

}
