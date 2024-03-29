package com.kcaco.design.创建型.建造者模式.staticinnerclass;

import lombok.Data;

/**
 * Description: 静态内部类实现建造者模式
 *
 * @author kcaco
 * @since 2023/5/3 8:42 AM
 */
@Data
public class StaticInnerClassProduct {

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


    private StaticInnerClassProduct(String eat, String drink, String play) {
        this.eat = eat;
        this.drink = drink;
        this.play = play;
    }

    public static StaticInnerClassProduct.ProductBuilder builder() {
        return new StaticInnerClassProduct.ProductBuilder();
    }

    public static class ProductBuilder {
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

        public ProductBuilder() {
        }

        public StaticInnerClassProduct.ProductBuilder eat(String eat) {
            this.eat = eat;
            return this;
        }

        public StaticInnerClassProduct.ProductBuilder drink(String drink) {
            this.drink = drink;
            return this;
        }

        public StaticInnerClassProduct.ProductBuilder play(String play) {
            this.play = play;
            return this;
        }

        public StaticInnerClassProduct build() {
            return new StaticInnerClassProduct(this.eat, this.drink, this.play);
        }

    }
}
