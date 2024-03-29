package com.kcaco.design.行为型.责任链.common.请假示例.filter;

import com.kcaco.design.行为型.责任链.common.base.context.AbstractBaseContext;
import com.kcaco.design.行为型.责任链.common.base.BaseFilter;
import com.kcaco.design.行为型.责任链.common.base.ResultModel;
import com.kcaco.design.行为型.责任链.common.请假示例.LeaveApprovalInfo;

/**
 * Description: 老板审批
 *
 * @author kcaco
 * @since 2023-05-03 00:46
 */
public class ManagerApprovalFilter implements BaseFilter<LeaveApprovalInfo> {

    @Override
    public void doFilter(AbstractBaseContext<LeaveApprovalInfo> context) {
        LeaveApprovalInfo processModel = context.getProcessModel();

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


