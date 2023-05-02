package com.kcaco.designpattern.行为型.责任链.common.test;

import com.kcaco.designpattern.行为型.责任链.common.base.BaseFilter;
import com.kcaco.designpattern.行为型.责任链.common.base.BizEnum;
import com.kcaco.designpattern.行为型.责任链.common.pipeline.BaseFilterPipeline;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 请假审批流程
 *
 * @author kcaco
 * @since 2023-05-03 00:49
 */
public class LeaveApprovalPipeline implements BaseFilterPipeline<ApprovalInfo> {
    @Override
    public BizEnum getBizCode() {
        return BizEnum.LEAVE;
    }

    @Override
    public List<BaseFilter<ApprovalInfo>> getFilterList() {
        List<BaseFilter<ApprovalInfo>> filterList = new ArrayList<>();
        // 主管
        filterList.add(new DirectorApprovalFilter());
        // 老板
        filterList.add(new ManagerApprovalFilter());
        return filterList;
    }
}
