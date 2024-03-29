package com.kcaco.design.行为型.责任链.common.请假示例;

import com.kcaco.design.行为型.责任链.common.base.ProcessModel;
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
