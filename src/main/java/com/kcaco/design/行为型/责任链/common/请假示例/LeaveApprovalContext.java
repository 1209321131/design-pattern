package com.kcaco.design.行为型.责任链.common.请假示例;

import com.kcaco.design.行为型.责任链.common.base.context.AbstractBaseContext;
import com.kcaco.design.行为型.责任链.common.base.BizEnum;

/**
 * Description: 请求审批上下文
 *
 * @author kcaco
 * @since 2023-05-03 01:39
 */
public class LeaveApprovalContext extends AbstractBaseContext<LeaveApprovalInfo> {

    public LeaveApprovalContext(LeaveApprovalInfo processModel, BizEnum bizEnum) {
        super(processModel, bizEnum);
    }

}
