package com.kcaco.designpattern.行为型.责任链.common.base.context;


import com.kcaco.designpattern.行为型.责任链.common.base.BizEnum;

/**
 * Description: 基础上下文
 *
 * @author kcaco
 * @since 2023-05-02 19:06
 */

public interface BaseContext {

    /**
     * 标识责任链的code
     */
    BizEnum bizCode();

    /**
     * 是否中断责任链
     */
    boolean needBreak();

}
