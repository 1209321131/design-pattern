package com.kcaco.design.结构型.适配器模式.接口使用适配.电脑网线.impl;


import com.kcaco.design.结构型.适配器模式.接口使用适配.电脑网线.Adaptee;
import com.kcaco.design.结构型.适配器模式.接口使用适配.电脑网线.NetToUsb;

/**
 * 真正的适配器~需要连接USB，连接网线       继承实现
 *
 * @author Charon
 */
public class AdapterExtends extends Adaptee implements NetToUsb {

    @Override
    public void handleRequest() {
        super.request();
    }
}
