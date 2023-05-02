package com.kcaco.designpattern.行为型.责任链.common.test;

import com.kcaco.designpattern.行为型.责任链.common.base.BaseContext;
import com.kcaco.designpattern.行为型.责任链.common.base.BizEnum;
import com.kcaco.designpattern.行为型.责任链.common.base.ProcessControl;

/**
 * Description:
 *
 * @author kcaco
 * @since 2023-05-03 00:44
 */
public class TestCommon {

    public static void main(String[] args) {
        ApprovalInfo approvalInfo = new ApprovalInfo();
        approvalInfo.setApplyPerson("kcaco");
        approvalInfo.setReason("我要加薪");


        BaseContext<ApprovalInfo> approvalInfoBaseContext = new BaseContext<>();
        approvalInfoBaseContext.setProcessModel(approvalInfo);
        approvalInfoBaseContext.setBizCode(BizEnum.LEAVE);
        approvalInfoBaseContext.setNeedBreak(false);

        LeaveApprovalPipeline leaveApprovalPipeline = new LeaveApprovalPipeline();
        ProcessControl<ApprovalInfo> processControl = new ProcessControl<>(leaveApprovalPipeline);
        BaseContext<ApprovalInfo> process = processControl.process(approvalInfoBaseContext);
        System.out.println(process.getResponse());
    }
}
