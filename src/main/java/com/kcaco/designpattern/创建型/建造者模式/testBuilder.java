package com.kcaco.designpattern.创建型.建造者模式;

public class testBuilder {


    public static void main(String[] args) {
        Waiter waiter = new Waiter();

        Product product = waiter.drink("可乐")
                .eat("汉堡"
                ).play("星球大战")
                .getProduct();

        System.out.println(product.toString());

    }
}
