package com.kcaco.designpattern.创建型.建造者模式;


/**
 * 服务员
 */
public class Waiter implements Builder {

    private final Product product;

    public Waiter() {
        product = new Product();
    }

    @Override
    public Builder eat(String name) {
        product.setEat(name);
        return this;
    }

    @Override
    public Builder drink(String name) {
        product.setDrink(name);
        return this;
    }

    @Override
    public Builder play(String name) {
        product.setPlay(name);
        return this;
    }

    @Override
    public Product getProduct() {
        return product;
    }
}
