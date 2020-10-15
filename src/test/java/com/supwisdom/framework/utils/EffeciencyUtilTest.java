package com.supwisdom.framework.utils;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EffeciencyUtilTest {

    @Test
    public void test() throws InterruptedException {
        EffeciencyUtil.run(() -> {
            @SuppressWarnings("unused")
            String a = "";
            for (int i = 0; i < 10000; i++) {
                a += "a";
            }
        }, 3000L);
        
        // 由于计时是开启新线程的 所以必须在主线程死亡前执行完毕
        Thread.sleep(4000);
    }

}
