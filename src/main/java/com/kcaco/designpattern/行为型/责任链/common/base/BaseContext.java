package com.kcaco.designpattern.行为型.责任链.common.base;


import lombok.*;
import lombok.experimental.Accessors;

/**
 * Description:
 *
 * @author kcaco
 * @since 2023-05-02 19:06
 */
@Data
@Builder
@ToString
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class BaseContext<T extends ProcessModel> {

    /**
     * 标识责任链的code
     */
    private BizEnum bizCode;

    /**
     * 存储责任链上下文数据的模型
     */
    private T processModel;

    /**
     * 是否继续执行责任链
     */
    private boolean needBreak;

    /**
     * 流程处理的结果
     */
    private ResultModel response;

}
