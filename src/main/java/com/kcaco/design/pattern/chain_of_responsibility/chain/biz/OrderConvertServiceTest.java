package com.kcaco.design.pattern.chain_of_responsibility.chain.biz;

import com.kcaco.design.pattern.chain_of_responsibility.chain.biz.support.BizRequest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class OrderConvertServiceTest {

    @Resource
    private OrderConvertService orderConvertService;

    @Test
    public void test() {
        BizRequest request = new BizRequest(9527L, "123456", 2);
        boolean convert = orderConvertService.convert(request);
        System.out.println(convert);
    }

}
