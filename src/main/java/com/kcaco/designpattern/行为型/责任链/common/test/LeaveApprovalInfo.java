package com.kcaco.designpattern.行为型.责任链.common.test;

import com.kcaco.designpattern.行为型.责任链.common.base.ProcessModel;
import lombok.Data;

/**
 * Description: 请假审批信息
 *
 * @author kcaco
 * @since 2023-05-03 00:47
 */
@Data
public class LeaveApprovalInfo implements ProcessModel {

    /**
     * 申请人
     */
    private String applyPerson;


    /**
     * 申请原因
     */
    private String reason;
}
