package com.kcaco.designpattern.创建型.单例模式;

/**
 * Description: 静态内部类
 *
 * @author kcaco
 * @since 2022-11-23 23:51
 */
public class StaticClassSingle {

    private StaticClassSingle() {
    }

    public static StaticClassSingle getInstance() {
        return Handle.STATIC_CLASSES;
    }

    public static class Handle {
        private static final StaticClassSingle STATIC_CLASSES = new StaticClassSingle();
    }


}
