package com.kcaco.design.结构型.代理模式.动态代理.Cglib;

/**
 * Description:
 *
 * @author kcaco
 * @since 2022-05-30 01:03
 */
public class ProjectImpl implements Project {
    @Override
    public void test() {
        System.out.println("我是测试方法！");
    }
}
