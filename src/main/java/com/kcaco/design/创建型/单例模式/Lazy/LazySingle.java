package com.kcaco.design.创建型.单例模式.Lazy;

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

    /**
     * 普通懒汉式
     */
    public static LazySingle getInstance() {
        if (LAZY_SINGLE == null) {
            LAZY_SINGLE = new LazySingle();
        }
        return LAZY_SINGLE;
    }

    /**
     * 通过synchronized防止并发
     */
    //public static synchronized LazySingle getInstance() {
    //    if (LAZY_SINGLE == null) {
    //        LAZY_SINGLE = new LazySingle();
    //    }
    //    return LAZY_SINGLE;
    //}


}
