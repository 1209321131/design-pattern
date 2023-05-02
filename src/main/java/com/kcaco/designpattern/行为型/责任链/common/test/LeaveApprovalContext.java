package com.kcaco.designpattern.行为型.责任链.common.test;

import com.kcaco.designpattern.行为型.责任链.common.base.context.AbstractBaseContext;
import com.kcaco.designpattern.行为型.责任链.common.base.BizEnum;

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
