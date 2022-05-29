package com.kcaco.designpattern.结构型.代理模式.动态代理.Cglib;

import com.kcaco.designpattern.结构型.代理模式.动态代理.JDK.SubjectImpl;
import org.springframework.cglib.proxy.Enhancer;

/**
 * Description:
 *
 * @author kcaco
 * @since 2022-05-30 01:08
 */
public class TestProxy {

    public static void main(String[] args) {
        ProjectImpl subject = new ProjectImpl();

        // 增强器，为我们生成动态代理对象
        Enhancer enhancer = new Enhancer();
        // 直接选择我们需要代理的类型，不需要接口或是抽象类，SuperClass作为代理类的父类存在，这样我们就可以按照指定类型的方式去操作代理类了
        enhancer.setSuperclass(ProjectImpl.class);
        // 代理逻辑
        enhancer.setCallback(new ProjectProxy(subject));

        // 直接创建代理类
        ProjectImpl proxy = (ProjectImpl) enhancer.create();

        // 调用代理类的test方法
        proxy.test();
    }
}
