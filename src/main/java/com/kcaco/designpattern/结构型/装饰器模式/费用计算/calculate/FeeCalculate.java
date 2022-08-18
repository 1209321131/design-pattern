package com.kcaco.designpattern.结构型.装饰器模式.费用计算.calculate;

import com.kcaco.designpattern.结构型.装饰器模式.费用计算.fee.FeeItem;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.fee.FeeItemType;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.pay.PayItem;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 费用计算器
 */
public interface FeeCalculate<T> {

    /**
     * 每个费用项对应的抵扣明细
     *
     * @param feeItemList 费用项集合
     * @return map<费用项, 抵扣项明细>
     */
    Map<FeeItemType, List<PayItem>> payItemMap(List<FeeItem<T>> feeItemList);

    /**
     * 待支付费用项map
     *
     * @param feeItemList 费用项集合
     * @return map<费用项, 金额>
     */
    Map<FeeItemType, BigDecimal> waitPayMoneyMap(List<FeeItem<T>> feeItemList);

    /**
     * 获取计算器的唯一编码
     *
     * @return 唯一编码
     */
    Unique getUnique();

}
