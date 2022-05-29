package com.kcaco.designpattern.行为型.命令模式;

// 遥控器只需要把我们的指令发出去就行了
public class Controller {

    public static void call(Command command) {
        command.execute();
    }
}