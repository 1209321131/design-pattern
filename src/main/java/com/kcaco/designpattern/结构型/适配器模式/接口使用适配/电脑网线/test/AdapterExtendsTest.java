package com.kcaco.designpattern.结构型.适配器模式.接口使用适配.电脑网线.test;


import com.kcaco.designpattern.结构型.适配器模式.接口使用适配.电脑网线.Computer;
import com.kcaco.designpattern.结构型.适配器模式.接口使用适配.电脑网线.impl.AdapterExtends;

/**
 * ClassName:AdapterExtendsTest
 * Package:结构型.适配器模式.电脑网线
 * Description:
 *
 * @date:2021/3/24 16:58
 * @author:KCACO
 **/

public class AdapterExtendsTest {

    public static void main(String[] args) {
        // 电脑
        Computer computer = new Computer();

        // 转接器自带上网功能(通过继承得到网线的方法)
        AdapterExtends adapter = new AdapterExtends();
        computer.net(adapter);
    }

}
