package com.kcaco.designpattern.行为型.责任链.common.base;

import cn.hutool.core.util.StrUtil;
import lombok.Getter;
import lombok.AllArgsConstructor;

/**
 * Description: 业务类型
 *
 * @author kcaco
 * @since 2023-05-02 22:23
 */
@Getter
@AllArgsConstructor
public enum BizEnum {

    /**
     * 请假
     */
    LEAVE("1", "请假");

    private final String code;
    private final String message;


    /**
     * 根据代码获取枚举
     *
     * @param code 代码
     * @return 枚举
     */
    public static BizEnum getByCode(String code) {
        if (StrUtil.isBlank(code)) {
            throw new RuntimeException("代码为空，请检查");
        }
        for (BizEnum value : BizEnum.values()) {
            if (StrUtil.equals(code, value.getCode())) {
                return value;
            }
        }
        throw new RuntimeException("无效的代码" + code);
    }
}