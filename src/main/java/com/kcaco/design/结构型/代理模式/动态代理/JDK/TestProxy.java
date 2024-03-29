package com.kcaco.design.结构型.代理模式.动态代理.JDK;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Description:
 *
 * @author kcaco
 * @since 2022-05-30 00:52
 */
public class TestProxy {

    public static void main(String[] args) {
        // 被代理的大冤种
        SubjectImpl subject = new SubjectImpl();
        InvocationHandler handler = new SubjectProxy(subject);
        Subject proxy = (Subject) Proxy.newProxyInstance(
                subject.getClass().getClassLoader(),    // 被代理类的类加载器
                subject.getClass().getInterfaces(),     // 被代理类的接口列表
                handler);    // 实现的代理处理逻辑实现类
        // 比如现在我们调用代理类的test方法，那么就会进入到我们上面SubjectProxy中invoke方法，走我们的代理逻辑
        proxy.test();
    }

}
