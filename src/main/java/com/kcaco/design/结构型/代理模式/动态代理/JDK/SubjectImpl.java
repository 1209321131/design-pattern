package com.kcaco.design.结构型.代理模式.动态代理.JDK;

public class SubjectImpl implements Subject {

    @Override
    public void test() {
        System.out.println("我是测试方法！");
    }
}
