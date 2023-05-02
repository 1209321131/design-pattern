package com.kcaco.designpattern.行为型.责任链.common.base.context;

import com.kcaco.designpattern.行为型.责任链.common.base.BizEnum;
import com.kcaco.designpattern.行为型.责任链.common.base.ProcessModel;
import com.kcaco.designpattern.行为型.责任链.common.base.ResultModel;
import com.kcaco.designpattern.行为型.责任链.common.base.context.BaseContext;
import lombok.Data;

/**
 * Description:
 *
 * @author kcaco
 * @since 2023-05-03 01:32
 */
@Data
public abstract class AbstractBaseContext<T extends ProcessModel> implements BaseContext {

    /**
     * 流程处理的结果
     */
    private ResultModel response;

    /**
     * 存储责任链上下文数据的模型
     */
    private T processModel;

    /**
     * 业务编码
     */
    private BizEnum bizEnum;

    /**
     * 是否中断
     */
    private boolean needBreak = false;

    public AbstractBaseContext(T processModel, BizEnum bizEnum) {
        this.processModel = processModel;
        this.bizEnum = bizEnum;
    }

    @Override
    public BizEnum bizCode() {
        return bizEnum;
    }

    @Override
    public boolean needBreak() {
        return needBreak;
    }
}
