package com.kcaco.designpattern.结构型.代理模式.动态代理.JDK;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 代理类，需要实现InvocationHandler接口
 */
public class SubjectProxy implements InvocationHandler {

    private final Object object;   // 这里需要保存一下被代理的对象，下面需要用到

    public SubjectProxy(Object object) {
        this.object = object;
    }

    /**
     * /此方法就是调用代理对象的对应方法时会进入，这里我们就需要编写如何进行代理了
     *
     * @param proxy  代理对象
     * @param method 调用的代理对象的哪一个方法
     * @param args   实参数组
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理的对象：" + proxy.getClass());
        // 在代理中调用被代理对象原本的方法，因为你是代理，还是得执行一下别人的业务，当然也可以不执行，但是这样就失去代理的意义了，注意要用上面的object
        Object res = method.invoke(object, args);
        System.out.println("方法调用完成，返回值为：" + res);
        return res;
    }
}