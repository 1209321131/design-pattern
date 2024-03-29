package com.kcaco.design.pattern.chain_of_responsibility.pipeline.pipeline.biz;


import cn.hutool.core.date.DateUtil;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class UserMessage {
    /**
     * 用户
     */
    private String user;

    /**
     * 用户输入内容
     */
    private String inputContent;

    /**
     * 日期
     */
    private Date date;

    @Override
    public String toString() {
        return DateUtil.formatDateTime(date) + " " + user + "说: " + inputContent;
    }
}
