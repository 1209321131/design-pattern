package com.kcaco.design.创建型.建造者模式.base;


/**
 * Description: 具体建造者，这里就是服务员
 *
 * @author kcaco
 * @since 2023/5/3 8:40 AM
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
