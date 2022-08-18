package com.kcaco.designpattern.结构型.装饰器模式.base;

/**
 * Description:
 *
 * @author kcaco
 * @since 2022-05-29 23:27
 */
public class TestDecorator {

    public static void main(String[] args) {
        Base base = new BaseImpl();
        Decorator decorator = new DecoratorImpl(base);  //将Base实现装饰一下
        Decorator outer = new DecoratorImpl(decorator);  //装饰者还可以嵌套

        decorator.test();

        outer.test();
    }


}
