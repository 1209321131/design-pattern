package com.kcaco.designpattern.行为型.命令模式.test;

import com.kcaco.designpattern.行为型.命令模式.Controller;

/**
 * Description:
 *
 * @author kcaco
 * @since 2022-05-29 14:37
 */
public class TestOrder {

    public static void main(String[] args) {

        // 先创建一个空调
        AirConditioner airConditioner = new AirConditioner();

        // 直接通过遥控器来发送空调开启命令
        Controller.call(new OpenCommand(airConditioner));

    }
}
