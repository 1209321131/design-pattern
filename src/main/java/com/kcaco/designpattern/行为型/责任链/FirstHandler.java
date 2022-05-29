package com.kcaco.designpattern.行为型.责任链;

public class FirstHandler extends Handler {   //用于一面的处理器
    @Override
    public void doHandle() {
        System.out.println("============= 白马程序员一面 ==========");
        System.out.println("1. 谈谈你对static关键字的理解？");
        System.out.println("2. 内部类可以调用外部的数据吗？如果是静态的呢？");
        System.out.println("3. hashCode()方法是所有的类都有吗？默认返回的是什么呢？");
        System.out.println("以上问题会的，可以依次打在评论区");
    }
}