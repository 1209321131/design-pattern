package com.kcaco.designpattern.创建型.建造者模式.staticinnerclass;

/**
 * Description:
 *
 * @author kcaco
 * @since 2023-05-03 08:43
 */
public class StaticInnerClassTest {


    public static void main(String[] args) {
        StaticInnerClassProduct build = StaticInnerClassProduct.builder()
                .drink("可乐")
                .eat("汉堡")
                .play("星球大战")
                .build();
        System.out.println(build.toString());
    }
}
