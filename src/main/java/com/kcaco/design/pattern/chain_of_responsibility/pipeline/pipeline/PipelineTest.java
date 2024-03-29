package com.kcaco.design.pattern.chain_of_responsibility.pipeline.pipeline;


import com.kcaco.design.pattern.chain_of_responsibility.pipeline.pipeline.biz.BadLanguageHandler;
import com.kcaco.design.pattern.chain_of_responsibility.pipeline.pipeline.biz.MessageHandler;
import com.kcaco.design.pattern.chain_of_responsibility.pipeline.pipeline.biz.SpaceHandler;
import com.kcaco.design.pattern.chain_of_responsibility.pipeline.pipeline.biz.UserMessage;
import com.kcaco.design.pattern.chain_of_responsibility.pipeline.pipeline.jar.Pipeline;

public class PipelineTest {
    public static void main(String[] args) {
        Pipeline<String, UserMessage> steps = new Pipeline<>(new SpaceHandler())
                .addHandler(new BadLanguageHandler()) // 接管子，一节连着一节
                .addHandler(new MessageHandler());
        UserMessage userMessage = steps.execute("你是我日日夜夜思念的人");
        System.out.println(userMessage);
    }
}
