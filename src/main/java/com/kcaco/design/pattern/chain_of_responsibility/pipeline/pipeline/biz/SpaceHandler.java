package com.kcaco.design.pattern.chain_of_responsibility.pipeline.pipeline.biz;


import com.kcaco.design.pattern.chain_of_responsibility.pipeline.pipeline.jar.Handler;

// 去除首尾空格
public class SpaceHandler implements Handler<String, String> {
    @Override
    public String process(String input) {
        return input.trim();
    }
}
