package com.kcaco.design.创建型.建造者模式.stepbuilder;

import lombok.Data;

import java.util.List;

/**
 * Description: 英雄
 *
 * @author kcaco
 * @since 2023-05-03 15:29
 */
@Data
public class Hero {
    /**
     * 姓名
     */
    private String name;

    /**
     * 战士
     */
    private String fighterClass;

    /**
     * 法师
     */
    private String wizardClass;

    /**
     * 兵器
     */
    private String weapon;

    /**
     * 咒语
     */
    private String spell;

    /**
     * 能力
     */
    private List<String> abilities;

}
