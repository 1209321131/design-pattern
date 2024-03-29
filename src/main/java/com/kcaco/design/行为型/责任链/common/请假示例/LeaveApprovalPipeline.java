package com.kcaco.design.行为型.责任链.common.请假示例;

import com.kcaco.design.行为型.责任链.common.base.BaseFilter;
import com.kcaco.design.行为型.责任链.common.base.BizEnum;
import com.kcaco.design.行为型.责任链.common.base.BaseFilterPipeline;
import com.kcaco.design.行为型.责任链.common.请假示例.filter.DirectorApprovalFilter;
import com.kcaco.design.行为型.责任链.common.请假示例.filter.ManagerApprovalFilter;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 请假审批流程
 *
 * @author kcaco
 * @since 2023-05-03 00:49
 */
public class LeaveApprovalPipeline implements BaseFilterPipeline<LeaveApprovalInfo> {
    @Override
    public BizEnum getBizCode() {
        return BizEnum.LEAVE;
    }

    @Override
    public List<BaseFilter<LeaveApprovalInfo>> getFilterList() {
        List<BaseFilter<LeaveApprovalInfo>> filterList = new ArrayList<>();
        // 主管
        filterList.add(new DirectorApprovalFilter());
        // 老板
        filterList.add(new ManagerApprovalFilter());
        return filterList;
    }
}
