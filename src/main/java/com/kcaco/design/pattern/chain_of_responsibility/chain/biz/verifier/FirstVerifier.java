package com.kcaco.design.pattern.chain_of_responsibility.chain.biz.verifier;

import com.kcaco.design.pattern.chain_of_responsibility.chain.biz.support.BizRequest;
import com.kcaco.design.pattern.chain_of_responsibility.chain.jar.Result;
import com.kcaco.design.pattern.chain_of_responsibility.chain.jar.Verifier;
import org.springframework.stereotype.Component;

@Component
public class FirstVerifier implements Verifier<BizRequest, Result> {

    @Override
    public Result verify(BizRequest request) {
        System.out.println("FirstVerifier");
        return Result.pass();
    }

}
