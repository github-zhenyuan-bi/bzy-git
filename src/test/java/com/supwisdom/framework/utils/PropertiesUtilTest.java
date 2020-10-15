package com.supwisdom.framework.utils;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.google.common.collect.ImmutableMap;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class PropertiesUtilTest {

    @Test
    public void test() {
        ImmutableMap<String, String> res = PropertiesUtil.loadApplicationWithActiveProfile();
        res.forEach((key, val) -> {
            log.debug(key, val);
        });
    }

}
