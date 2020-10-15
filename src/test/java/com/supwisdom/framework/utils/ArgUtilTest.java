package com.supwisdom.framework.utils;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class ArgUtilTest {

    @Test
    public void test() {
        Object arg1 = "arg1", arg2 = "arg2";
        assertEquals(arg1, ArgUtil.defaultValueIfNull(arg1, arg2));
        assertEquals(arg2, ArgUtil.defaultValueIfNull(null, arg2));
    }

}
