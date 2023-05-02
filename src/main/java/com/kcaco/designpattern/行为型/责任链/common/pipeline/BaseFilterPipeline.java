package com.kcaco.designpattern.行为型.责任链.common.pipeline;


import com.kcaco.designpattern.行为型.责任链.common.base.BaseFilter;
import com.kcaco.designpattern.行为型.责任链.common.base.BizEnum;
import com.kcaco.designpattern.行为型.责任链.common.base.ProcessModel;

import java.util.List;

/**
 * Description:
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
