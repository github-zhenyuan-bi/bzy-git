package com.supwisdom.framework.utils;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DateUtilTest {

    @Test
    public void test() {
        final String dateStr = "2020-06-23 12:34:56";
        
        // 字符串转化为时间 
        Date date = DateUtil.parse(dateStr, DateUtil.STANDARD_DATE_PATTERN);
        
        // 时间 格式化为 字符串  #### 自选转化格式
        assertEquals("2020-06-23 12:34:56", DateUtil.formatDate(date, DateUtil.STANDARD_DATE_PATTERN));
        assertEquals("2020-06-23", DateUtil.formatDate(date, DateUtil.STANDARD_DATE_PATTERN_YMD));
        assertEquals("2020-06", DateUtil.formatDate(date, DateUtil.STANDARD_DATE_PATTERN_YM));
        assertEquals("2020", DateUtil.formatDate(date, DateUtil.STANDARD_DATE_PATTERN_Y));
        
        // 时间 格式化为 字符串 #### 简化操作
        assertEquals("2020-06-23 12:34:56", DateUtil.YYYYMMDD_SS(date));
        assertEquals("2020-06-23", DateUtil.YYYYMMDD(date));
        assertEquals("2020-06", DateUtil.YYYYMM(date));
        assertEquals("2020", DateUtil.YYYY(date));
        
        System.err.println(DateUtil.formatDate(DateUtil.getNow(), DateUtil.STANDARD_DATE_PATTERN2));
    }

}
