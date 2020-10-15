package com.supwisdom.framework.utils;

import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class HttpUtilTest {

    @Test
    public void test() {
        try {
            HttpUtil.httpGet("https://www.baidu.com/");
        } catch (Exception e) {
            fail("Http请求失败，原因：" + e.getMessage());
        }
    }

}
