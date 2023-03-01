package com.kcaco.designpattern.创建型.单例模式.Lazy;

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

    /**
     * 两次检验LAZY_SINGLE == null
     * 第一次（同步块外）：避免不必要的上锁（相对加锁的懒汉模式而言）
     * 第二次（同步块内）：可能多个线程一起进入同步块外的if，因此可能会生成多个实例（避免多个线程同时判断为`null`而进入等待锁的状态）
     */
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
