package com.kcaco.design.行为型.命令模式;

public abstract class Command {   // 指令抽象，不同的电器有指令

    private final Receiver receiver;

    protected Command(Receiver receiver) {   //指定此命令对应的电器（接受者）
        this.receiver = receiver;
    }

    public void execute() {
        receiver.action();   //执行命令，实际上就是让接收者开始干活
    }
}
