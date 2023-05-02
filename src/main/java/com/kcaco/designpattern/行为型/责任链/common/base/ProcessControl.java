package com.kcaco.designpattern.行为型.责任链.common.base;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import com.kcaco.designpattern.行为型.责任链.common.pipeline.BaseFilterPipeline;

import java.util.List;

/**
 * Description:
 *
 * @author kcaco
 * @since 2023-05-02 23:57
 */
public class ProcessControl<T extends ProcessModel> {

    /**
     * 执行流程
     */
    private final BaseFilterPipeline<T> baseFilterPipeline;

    public ProcessControl(BaseFilterPipeline<T> baseFilterPipeline) {
        this.baseFilterPipeline = baseFilterPipeline;
    }

    /**
     * 执行责任链
     *
     * @param context 上下文
     * @return 返回上下文内容
     */
    public BaseContext<T> process(BaseContext<T> context) {
        // 前置检查
        preCheck(context);

        // 遍历流程节点
        List<BaseFilter<T>> processList = baseFilterPipeline.getFilterList();
        for (BaseFilter<T> businessProcess : processList) {
            // todo 跳链

            // 执行业务逻辑
            businessProcess.doFilter(context);

            // 是否终止责任链
            if (context.isNeedBreak()) {
                break;
            }
        }

        // 返回结果
        return context;
    }


    /**
     * 执行前检查，出错则抛出异常
     *
     * @param context 执行上下文
     */
    private void preCheck(BaseContext<T> context) {
        // 上下文
        if (ObjectUtil.isNull(context)) {
            context = new BaseContext<>();
            context.setResponse(ResultModel.failed("上下文为空"));
            throw new RuntimeException(context.toString());
        }

        // 模板标识
        BizEnum bizCode = context.getBizCode();
        if (ObjectUtil.isNull(bizCode)) {
            context.setResponse(ResultModel.failed("模板标识为空"));
            throw new RuntimeException(context.toString());
        }

        // 执行模板
        if (ObjectUtil.isNull(baseFilterPipeline)) {
            context.setResponse(ResultModel.failed("执行模板为空"));
            throw new RuntimeException(context.toString());
        }

        // 模板标识是否匹配
        if (ObjectUtil.notEqual(bizCode, baseFilterPipeline.getBizCode())) {
            context.setResponse(ResultModel.failed("模板标识不匹配"));
            throw new RuntimeException(context.toString());
        }

        // 执行模板列表
        List<BaseFilter<T>> processList = baseFilterPipeline.getFilterList();
        if (CollUtil.isEmpty(processList)) {
            context.setResponse(ResultModel.failed("执行模板列表为空"));
            throw new RuntimeException(context.toString());
        }
    }


}
