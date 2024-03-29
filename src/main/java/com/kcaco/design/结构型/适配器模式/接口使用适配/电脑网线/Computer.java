package com.kcaco.design.结构型.适配器模式.接口使用适配.电脑网线;

/**
 * 客户端  想上网，但只有usb接口
 */
public class Computer {

    //电脑的sub接口连接到转接器即可上网
    public void net(NetToUsb adapter) {
        //转接头！
        adapter.handleRequest();
    }
}
