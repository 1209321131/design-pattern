package com.kcaco.designpattern.结构型.装饰器模式.费用计算.context;

import java.math.BigDecimal;

import lombok.Data;


/**
 * Description: 订单信息上下文
 *
 * @author kcaco
 * @since 2022/10/18 8:56 PM
 */
@Data
public class OrderInfo {

    /**
     * 车牌号
     */
    private String carNo;

    /**
     * 停车时长
     */
    private Integer parkTimes;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 总金额
     */
    private BigDecimal totalMoney;

    //其他  购买 sku 信息


}
