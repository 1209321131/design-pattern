package com.kcaco.designpattern.行为型.责任链.common.test;

import com.kcaco.designpattern.行为型.责任链.common.base.context.AbstractBaseContext;
import com.kcaco.designpattern.行为型.责任链.common.base.AbstractProcessControl;

/**
 * Description: 流程控制
 *
 * @author kcaco
 * @since 2023-05-03 01:55
 */
public class LeaveApprovalProcessControl extends AbstractProcessControl<LeaveApprovalInfo> {

    @Override
    protected AbstractBaseContext<LeaveApprovalInfo> process(AbstractBaseContext<LeaveApprovalInfo> context) {
        LeaveApprovalPipeline leaveApprovalPipeline = new LeaveApprovalPipeline();
        return defaultProcess(leaveApprovalPipeline, context);
    }
}
