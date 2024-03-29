package com.kcaco.design.结构型.适配器模式.接口使用适配.电脑网线.test;


import com.kcaco.design.结构型.适配器模式.接口使用适配.电脑网线.Adaptee;
import com.kcaco.design.结构型.适配器模式.接口使用适配.电脑网线.Computer;
import com.kcaco.design.结构型.适配器模式.接口使用适配.电脑网线.impl.AdapterImpl;

/**
 * ClassName:AdapterImplTest
 * Package:结构型.适配器模式.电脑网线.test
 * Description:
 *
 * @date:2021/3/24 17:02
 * @author:KCACO
 **/
public class AdapterImplTest {

    public static void main(String[] args) {
        // 电脑
        Computer computer = new Computer();

        // 网线
        Adaptee adaptee = new Adaptee();

        // 转接器  先把网线接入适配器
        AdapterImpl adapter = new AdapterImpl(adaptee);

        // 然后电脑连接适配器
        computer.net(adapter);
    }
}
