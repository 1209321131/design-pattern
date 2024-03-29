package com.kcaco.design.结构型.适配器模式.接口使用适配.电脑网线.impl;

import com.kcaco.design.结构型.适配器模式.接口使用适配.电脑网线.Adaptee;
import com.kcaco.design.结构型.适配器模式.接口使用适配.电脑网线.NetToUsb;

/**
 * ClassName:AdapterImpl
 * Package:结构型.适配器模式.电脑网线.impl
 * Description:
 *
 * @date:2021/3/24 17:01
 * @author:KCACO
 **/
public class AdapterImpl implements NetToUsb {
    private Adaptee adaptee;

    public AdapterImpl(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void handleRequest() {
        adaptee.request();
    }

}
