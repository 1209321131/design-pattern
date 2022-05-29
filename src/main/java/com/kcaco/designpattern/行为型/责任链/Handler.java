package com.kcaco.designpattern.行为型.责任链;

import java.util.Optional;

public abstract class Handler {

    protected Handler successor;    //这里我们就设计责任链以单链表形式存在，这里存放后继节点

    public Handler connect(Handler successor) {     //拼接后续节点
        this.successor = successor;
        return successor;  //这里返回后继节点，方便我们一会链式调用
    }

    public void handle() {
        this.doHandle();   //由不同的子类实现具体处理过程
        Optional
                .ofNullable(successor)
                .ifPresent(Handler::handle);    //责任链上如果还有后继节点，就继续向下传递
    }

    public abstract void doHandle();   //结合上节课学习的模板方法，交给子类实现




    public static void main(String[] args) {
        Handler handler = new FirstHandler();  //一面首当其冲
        handler
                .connect(new SecondHandler())   //继续连接二面和三面
                .connect(new ThirdHandler());
        handler.handle();   //开始面试
    }
}