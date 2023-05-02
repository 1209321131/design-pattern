package com.kcaco.designpattern.行为型.责任链.common.test;

import com.kcaco.designpattern.行为型.责任链.common.base.context.AbstractBaseContext;
import com.kcaco.designpattern.行为型.责任链.common.base.BizEnum;

/**
 * Description:
 *
 * @author kcaco
 * @since 2023-05-03 00:44
 */
public class TestCommon {

    public static void main(String[] args) {
        LeaveApprovalInfo leaveApprovalInfo = new LeaveApprovalInfo();
        leaveApprovalInfo.setApplyPerson("kcaco");
        leaveApprovalInfo.setReason("我要加薪");

        LeaveApprovalContext leaveApprovalContext = new LeaveApprovalContext(leaveApprovalInfo, BizEnum.LEAVE);

        LeaveApprovalProcessControl leaveApprovalProcessControl = new LeaveApprovalProcessControl();
        AbstractBaseContext<LeaveApprovalInfo> process = leaveApprovalProcessControl.process(leaveApprovalContext);

        System.out.println(process.getResponse());
    }
}
