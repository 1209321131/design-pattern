package com.kcaco.designpattern.创建型.建造者模式.base;


/**
 * Description: 抽象建造者类
 *
 * @author kcaco
 * @since 2023/5/3 8:40 AM
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
