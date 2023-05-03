package com.kcaco.designpattern.创建型.建造者模式.stepbuilder;

import lombok.Data;

/**
 * Description: 电脑
 *
 * @author kcaco
 * @since 2023-05-03 15:29
 */
@Data
public class Computer {
    /**
     * cpu
     */
    private String cpu;

    /**
     * 内存
     */
    private String memory;

    /**
     * 屏幕
     */
    private String screen;

}
