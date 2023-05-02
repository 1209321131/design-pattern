package com.kcaco.designpattern.行为型.责任链.common.base;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 返回结果
 **/
@Data
@NoArgsConstructor
public class ResultModel implements Serializable {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 数据
     */
    private Object data;

    public ResultModel(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResultModel(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 带消息成功返回
     */
    public static ResultModel successWithMsg(String msg) {
        return new ResultModel(200, msg, null);
    }

    /**
     * 带数据成功返回
     */
    public static ResultModel success(Object data) {
        return new ResultModel(200, "成功", data);
    }

    /**
     * 失败
     */
    public static ResultModel failed(String message) {
        return new ResultModel(500, message);
    }

}
