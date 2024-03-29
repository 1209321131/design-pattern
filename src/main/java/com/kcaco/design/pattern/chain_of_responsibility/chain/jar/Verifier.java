package com.kcaco.design.pattern.chain_of_responsibility.chain.jar;

public interface Verifier<I, O> {

    O verify(I request);

}
