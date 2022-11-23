package com.kcaco.designpattern.创建型.单例模式;

/**
 * Description: DCL懒汉式
 *
 * @author kcaco
 * @since 2022-11-23 23:49
 */
public class LazyDCLSingle {
    private LazyDCLSingle() {

    }

    private static LazyDCLSingle LAZY_SINGLE = null;

    public static LazyDCLSingle getInstance() {
        if (LAZY_SINGLE == null) {
            synchronized (LazyDCLSingle.class) {
                if (LAZY_SINGLE == null) {
                    LAZY_SINGLE = new LazyDCLSingle();
                }
            }
        }
        return LAZY_SINGLE;
    }

}
