package com.supwisdom.framework.utils;


import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CronUtilTest {

    @Test
    public void test() {
        CronUtil.getLastTriggerTime("0 0 0 1/3 * ? *");
    }

}
