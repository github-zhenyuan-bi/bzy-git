package com.supwisdom.framework.utils;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class SpringContextUtilTest {

    @Test
    public void test() {
        Set<String> urls = SpringContextUtil.getRequestMappingUris();
        urls.forEach(url -> log.debug("RequestMapping# {}", url));
    }

}
