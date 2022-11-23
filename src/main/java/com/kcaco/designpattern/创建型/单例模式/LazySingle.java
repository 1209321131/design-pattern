package com.kcaco.designpattern.创建型.单例模式;

/**
 * Description: 懒汉式
 *
 * @author kcaco
 * @since 2022-11-23 23:47
 */
public class LazySingle {
    private LazySingle() {
    }

    private static LazySingle LAZY_SINGLE = null;

    public static synchronized LazySingle getInstance() {
        if (LAZY_SINGLE == null) {
            LAZY_SINGLE = new LazySingle();
        }
        return LAZY_SINGLE;
    }

}
