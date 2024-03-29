package com.kcaco.design.pattern.chain_of_responsibility.chain.biz;


import com.kcaco.design.pattern.chain_of_responsibility.chain.biz.support.BizRequest;
import com.kcaco.design.pattern.chain_of_responsibility.chain.biz.verifier.FirstVerifier;
import com.kcaco.design.pattern.chain_of_responsibility.chain.biz.verifier.SecondVerifier;
import com.kcaco.design.pattern.chain_of_responsibility.chain.jar.Result;
import com.kcaco.design.pattern.chain_of_responsibility.chain.jar.VerifyChainExecutor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
public class BizVerifyExecutor {

    @Resource
    private BeanFactory beanFactory;

    @Bean
    public VerifyChainExecutor<BizRequest, Result> bizVerifyChainExecutor() {
        return VerifyChainExecutor.<BizRequest, Result>builder()
                .add(beanFactory.getBean(FirstVerifier.class))
                .add(beanFactory.getBean(SecondVerifier.class))
                .build();
    }

}
