package com.kcaco.design.行为型.责任链.common.请假示例;

import com.kcaco.design.行为型.责任链.common.base.context.AbstractBaseContext;
import com.kcaco.design.行为型.责任链.common.base.BizEnum;

/**
 * Description: 请假测试
 *
 * @author kcaco
 * @since 2023-05-03 00:44
 */
public class LeaveApprovalTest {

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
