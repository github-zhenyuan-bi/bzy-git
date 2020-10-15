package com.supwisdom.framework.utils;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class FileUtilTest {

    @Test
    public void test() {
        try {
            String ymlContent = FileUtil.readString(new File(PathUtil.getClasspath("application.yml")));
            log.debug("application.yml文件内容# {}", ymlContent);
        } catch (IOException e) {
            fail("读取文件失败");
        }
    }

}
