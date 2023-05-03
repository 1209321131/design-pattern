package com.kcaco.designpattern.创建型.建造者模式.base;

import lombok.Data;

/**
 * Description: 产品，这里就是套餐
 *
 * @author kcaco
 * @since 2023/5/3 8:40 AM
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
