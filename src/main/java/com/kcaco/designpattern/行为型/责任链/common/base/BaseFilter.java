package com.kcaco.designpattern.行为型.责任链.common.base;

import com.kcaco.designpattern.行为型.责任链.common.base.context.AbstractBaseContext;

/**
 * Description: 业务处理
 *
 * @author kcaco
 * @since 2023-05-02 19:09
 */
public interface BaseFilter<T extends ProcessModel> {

    /**
     * 执行业务逻辑
     *
     * @param context 上下文
     */
    void doFilter(AbstractBaseContext<T> context);

}
