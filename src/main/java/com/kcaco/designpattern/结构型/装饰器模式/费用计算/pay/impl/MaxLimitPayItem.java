package com.kcaco.designpattern.结构型.装饰器模式.费用计算.pay.impl;

import com.kcaco.designpattern.结构型.装饰器模式.费用计算.pay.AbstractPayItem;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.pay.PayGroupEnum;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.pay.PayItemTypeEnum;

import java.math.BigDecimal;

/**
 * Description: 限额支付项
 *
 * @author kcaco
 * @since 2022/10/18 9:22 PM
 */
public class MaxLimitPayItem extends AbstractPayItem {

  public MaxLimitPayItem(BigDecimal money, PayItemTypeEnum payItemTypeEnum,
      PayGroupEnum payGroupEnum) {
    super(money, payItemTypeEnum, payGroupEnum);
  }
}
