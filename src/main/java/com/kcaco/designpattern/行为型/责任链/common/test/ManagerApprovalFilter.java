package com.kcaco.designpattern.行为型.责任链.common.test;

import com.kcaco.designpattern.行为型.责任链.common.base.BaseContext;
import com.kcaco.designpattern.行为型.责任链.common.base.BaseFilter;
import com.kcaco.designpattern.行为型.责任链.common.base.ResultModel;

/**
 * Description:
 *
 * @author kcaco
 * @since 2023-05-03 00:46
 */
public class ManagerApprovalFilter implements BaseFilter<ApprovalInfo> {

    @Override
    public void doFilter(BaseContext<ApprovalInfo> context) {
        ApprovalInfo processModel = context.getProcessModel();

        if (processModel.getReason().length() > 20) {
            System.out.println("老板审批通过");
            context.setNeedBreak(false);
            context.setResponse(ResultModel.success("老板审批通过"));
        } else {
            System.out.println("老板审批不通过");
            context.setNeedBreak(true);
            context.setResponse(ResultModel.failed("老板审批不通过"));
        }
    }
}


