package com.kcaco.design.行为型.责任链.base;

public class FirstAbstractFilter extends AbstractFilter {   //用于一面的处理器
    @Override
    public boolean doHandle() {
        System.out.println("============= 白马程序员一面 ==========");
        System.out.println("一面通过！！！");
        return true;
    }
}
