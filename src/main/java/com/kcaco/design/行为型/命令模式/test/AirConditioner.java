package com.kcaco.design.行为型.命令模式.test;

import com.kcaco.design.行为型.命令模式.Receiver;

public class AirConditioner implements Receiver {

    @Override
    public void action() {
        System.out.println("空调已开启，呼呼呼");
    }
}
