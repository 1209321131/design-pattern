package com.kcaco.design.行为型.责任链.common.base;


import java.util.List;

/**
 * Description: 基础责任链接口
 *
 * @author kcaco
 * @since 2023-05-02 23:28
 */
public interface BaseFilterPipeline<T extends ProcessModel> {

    /**
     * 业务代码
     */
    BizEnum getBizCode();

    /**
     * 业务链
     */
    List<BaseFilter<T>> getFilterList();

}
