package com.kcaco.designpattern.结构型.装饰器模式.费用计算.calculate;

import com.kcaco.designpattern.结构型.装饰器模式.费用计算.fee.FeeItem;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.fee.FeeItemTypeEnum;
import com.kcaco.designpattern.结构型.装饰器模式.费用计算.pay.PayItem;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Description: 费用计算器
 *
 * @author kcaco
 * @since 2022/10/18 9:05 PM
 */
public interface FeeCalculate<T> {

    /**
     * 每个费用项对应的抵扣明细
     *
     * @param feeItemList 费用项集合
     * @return map<费用项, 抵扣项明细>
     */
    Map<FeeItemTypeEnum, List<PayItem>> payItemMap(List<FeeItem<T>> feeItemList);

    /**
     * <待支付费用项,费用>map
     *
     * @param feeItemList 费用项集合
     * @return map<费用项, 金额>
     */
    Map<FeeItemTypeEnum, BigDecimal> waitPayMoneyMap(List<FeeItem<T>> feeItemList);

    /**
     * 获取计算器的唯一编码
     *
     * @return 唯一编码
     */
    Unique getUnique();

}
