package com.supwisdom.framework.utils;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.google.common.collect.Lists;

@SpringBootTest
public class ExceptionCheckUtilTest {

    @Test
    public void test() {
        
        // 校验表达式假 则抛异常
        String errMsg = "由于表达式为假，所以会抛出该异常信息";
        String excpMsg = "";
        try {
            ExceptionCheckUtil.isTrue(1==2, errMsg);
        } catch (Exception e) {
            excpMsg = e.getMessage();
        }
        assertEquals(errMsg, excpMsg);
        
        
        
        // 校验字符串必须有内容（空格不算内容） 否则抛异常 
        String errMsg2 = "由于字符串无实际文本，所以会抛出该异常信息";
        String excpMsg2 = "";
        try {
            ExceptionCheckUtil.hasText(" ", errMsg2);
        } catch (Exception e) {
            excpMsg2 = e.getMessage();
        }
        assertEquals(errMsg2, excpMsg2);
        
        
        
        // 检验空对象 空则抛异常
        String errMsg3 = "由于对象为空，所以会抛出该异常信息";
        String excpMsg3 = "";
        try {
            ExceptionCheckUtil.notNull(null, errMsg3);
        } catch (Exception e) {
            excpMsg3 = e.getMessage();
        }
        assertEquals(errMsg3, excpMsg3);
        
        
        
        // 检验空对象 空则抛异常
        String errMsg4 = "由于集合为空，所以会抛出该异常信息";
        String excpMsg4 = "";
        try {
            Collection<?> coll = Lists.newArrayList();
            ExceptionCheckUtil.notEmpty(coll, errMsg4);
        } catch (Exception e) {
            excpMsg4 = e.getMessage();
        }
        assertEquals(errMsg4, excpMsg4);
    }

}
