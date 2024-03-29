package com.kcaco.design.创建型.单例模式;

/**
 * Description: 饿汉式
 *
 * @author kcaco
 * @since 2022-11-23 23:45
 */
public class HungrySingle {
    private HungrySingle() {
    }
    private static final HungrySingle HUNGRY_SINGLE = new HungrySingle();

    public static HungrySingle getInstance() {
        return HUNGRY_SINGLE;
    }

}
