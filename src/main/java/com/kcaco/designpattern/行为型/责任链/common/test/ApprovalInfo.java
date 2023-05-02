package com.kcaco.designpattern.行为型.责任链.common.test;

import com.kcaco.designpattern.行为型.责任链.common.base.ProcessModel;
import lombok.Data;

/**
 * Description:
 *
 * @author kcaco
 * @since 2023-05-03 00:47
 */
@Data
public class ApprovalInfo implements ProcessModel {

    /**
     * 申请人
     */
    private String applyPerson;


    /**
     * 申请原因
     */
    private String reason;
}
