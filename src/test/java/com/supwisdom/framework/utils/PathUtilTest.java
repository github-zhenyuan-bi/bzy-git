package com.supwisdom.framework.utils;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class PathUtilTest {

    @Test
    public void test() throws IOException {
        log.debug("项目绝对路径# \n\t{}", PathUtil.getProjectPath());
        log.debug("类路径(classpath)下 application.yml路径# \n\t{}", PathUtil.getClasspath("application.yml"));
        log.debug(".java类所在开发环境包路径# \n\t{}", PathUtil.getJavaPath(PathUtil.class));
        log.debug("当前class的包路径# \n\t{}", PathUtil.getPackagePath(PathUtil.class));
        log.debug("当前WEB-INF路径# \n\t{}", PathUtil.getWEB_INFPath());
    }

}
