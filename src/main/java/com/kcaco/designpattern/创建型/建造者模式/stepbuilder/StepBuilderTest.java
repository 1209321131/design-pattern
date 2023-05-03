package com.kcaco.designpattern.创建型.建造者模式.stepbuilder;

/**
 * Description:
 *
 * @author kcaco
 * @since 2023-05-03 15:35
 */
public class StepBuilderTest {

    public static void main(String[] args) {
        Computer i7 = ComputerBuilder.getBuilder()
                .withCpu("i7")
                .withMemory("16G")
                .withScreen("15寸")
                .build();
        System.out.println(i7.toString());
    }

}
