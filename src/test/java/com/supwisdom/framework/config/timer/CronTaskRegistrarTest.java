package com.supwisdom.framework.config.timer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CronTaskRegistrarTest {

    @Autowired
    CronTaskRegistrar cronTaskRegistrar;
    
    @Test
    public void test() throws InterruptedException {
        SchedulingRunnable task = new SchedulingRunnable("task1", () -> {
            log.info("current exec task1");
        });
        SchedulingRunnable task2 = new SchedulingRunnable("task2", () -> {
            log.info("current exec task2");
        });
        
        // 先逐步添加两个定时任务 
        cronTaskRegistrar.addCronTask(task, "0/4 * * * * ?");
        cronTaskRegistrar.addCronTask(task2, "0/2 * * * * ?");
        cronTaskRegistrar.addCronTask(task, "0/4 * * * * ?");
        // 4s后关闭任务2
        Thread.sleep(4000);
        //cronTaskRegistrar.removeCronTask(task2);
        
        // 便于观察 总共执行30s
        Thread.sleep(8000);
    }

}
