package com.kcaco.design.行为型.备忘录模式;

public class State {

    final String currentWork;
    final int percentage;

    State(String currentWork, int percentage) {   // 仅开放给同一个包下的Student类使用
        this.currentWork = currentWork;
        this.percentage = percentage;
    }
}
