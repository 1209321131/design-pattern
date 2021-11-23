package com.kcaco.designpattern.创建型.建造者模式;

import lombok.Data;

/**
 * 套餐
 */
@Data
public class Product {

    /**
     * 吃的
     */
    private String eat;

    /**
     * 喝的
     */
    private String drink;

    /**
     * 玩的
     */
    private String play;

}
