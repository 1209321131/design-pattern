package com.kcaco.designpattern.创建型.建造者模式;


/**
 * 创建者
 */
public interface Builder {

    /**
     * 吃的
     */
    Builder eat(String name);

    /**
     * 喝的
     */
    Builder drink(String name);

    /**
     * 玩的
     */
    Builder play(String name);

    /**
     * 套餐
     */
    Product getProduct();

}
