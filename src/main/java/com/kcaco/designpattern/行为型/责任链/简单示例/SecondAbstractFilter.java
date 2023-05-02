package com.kcaco.designpattern.行为型.责任链.简单示例;

public class SecondAbstractFilter extends AbstractFilter {  //二面
    @Override
    public boolean doHandle() {
        System.out.println("============= 白马程序员二面 ==========");
        System.out.println("1. 如果我们自己创建一个java.lang包并且编写一个String类，能否实现覆盖JDK默认的？");
        System.out.println("2. HashMap的负载因子有什么作用？变化规律是什么？");
        System.out.println("3. 线程池的运作机制是什么？");
        System.out.println("4. ReentrantLock公平锁和非公平锁的区别是什么？");
        System.out.println("以上问题会的，可以依次打在评论区");

        return false;
    }
}