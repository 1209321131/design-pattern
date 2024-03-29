package com.kcaco.design.pattern.chain_of_responsibility.pipeline.pipeline.biz;


import com.kcaco.design.pattern.chain_of_responsibility.pipeline.pipeline.jar.Handler;

// 敏感词过滤
public class BadLanguageHandler implements Handler<String, String> {
    @Override
    public String process(String input) {
        return input.replace("我日", "**");
    }
}
