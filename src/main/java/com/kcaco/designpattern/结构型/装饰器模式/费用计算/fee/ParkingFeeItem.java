package com.kcaco.designpattern.结构型.装饰器模式.费用计算.fee;

import com.kcaco.designpattern.结构型.装饰器模式.费用计算.context.OrderInfo;

/**
 * Description:
 *
 * @author kcaco
 * @since 2022-08-18 17:14
 */
public class ParkingFeeItem extends AbstractFeeItem<OrderInfo> {

    public ParkingFeeItem(OrderInfo orderInfo) {
        super(orderInfo, FeeItemType.SERVICE_FEE, orderInfo.getTotalMoney());
    }

}
