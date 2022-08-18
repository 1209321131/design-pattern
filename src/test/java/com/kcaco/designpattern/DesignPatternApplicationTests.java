package com.kcaco.designpattern;

import com.kcaco.designpattern.结构型.装饰器模式.费用计算.test.FeeCalculateTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DesignPatternApplicationTests {

    @Test
    void contextLoads() {
        FeeCalculateTest feeCalculateTest = new FeeCalculateTest();
        feeCalculateTest.testFee();
    }

}
