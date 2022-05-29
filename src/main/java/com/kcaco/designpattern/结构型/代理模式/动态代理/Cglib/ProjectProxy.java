package com.kcaco.designpattern.结构型.代理模式.动态代理.Cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProjectProxy implements MethodInterceptor {

    private final Object target;   // 这些和之前JDK动态代理写法是一样的

    public ProjectProxy(Object target) {
        this.target = target;
    }

    /**
     * 在这里去编写我们的代理逻辑
     *
     * @param proxy       调用该方法的代理对象实例
     * @param method      调用被代理对象的哪个方法
     * @param args        实参
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("现在是由CGLib进行代理操作！" + proxy.getClass());
        return method.invoke(target, args);
    }

}