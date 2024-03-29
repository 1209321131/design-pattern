package com.kcaco.design.pattern.chain_of_responsibility.chain.jar;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result {

    /**
     * 是否通过
     */
    private boolean isPass;

    /**
     * 错误信息
     */
    private String errMsg;

    private final static Result PASS = new Result(true, null);

    public static Result pass() {
        return PASS;
    }

    public static Result fail(String errMsg) {
        return new Result(false, errMsg);
    }
}
