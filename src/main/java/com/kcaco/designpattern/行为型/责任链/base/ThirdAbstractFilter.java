package com.kcaco.designpattern.行为型.责任链.base;

public class ThirdAbstractFilter extends AbstractFilter {
    @Override
    public boolean doHandle() {
        System.out.println("============= 白马程序员三面 ==========");
        System.out.println("1. synchronized关键字了解吗？如何使用？底层是如何实现的？");
        System.out.println("2. IO和NIO的区别在哪里？NIO三大核心组件？");
        System.out.println("3. TCP握手和挥手流程？少一次握手可以吗？为什么？");
        System.out.println("4. 操作系统中PCB是做什么的？运行机制是什么？");
        System.out.println("以上问题会的，可以依次打在评论区");

        return true;
    }
}