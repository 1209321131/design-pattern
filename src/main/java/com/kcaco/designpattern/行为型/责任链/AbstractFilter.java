package com.kcaco.designpattern.行为型.责任链;

import java.util.Optional;

/**
 * 责任链
 * 作用：1、处理当前业务逻辑
 * 2、传递给下一个
 */
public abstract class AbstractFilter {

    private AbstractFilter successor;

    /**
     * 拼接后续节点
     *
     * @param successor
     * @return
     */
    public AbstractFilter add(AbstractFilter successor) {
        this.successor = successor;
        return successor;
    }

    public void handle() {
        // 业务逻辑
        boolean flag = this.doHandle();

        // 可以继续执行
        if (flag) {
            // 责任链上如果还有后继节点，就继续向下传递
            Optional
                    .ofNullable(successor)
                    .ifPresent(AbstractFilter::handle);
        }
    }

    /**
     * 具体业务实现
     */
    public abstract boolean doHandle();


    public static void main(String[] args) {
        AbstractFilter abstractFilter = new FirstAbstractFilter();
        abstractFilter.add(new SecondAbstractFilter())
                .add(new ThirdAbstractFilter());
        abstractFilter.handle();   //开始面试
    }
}