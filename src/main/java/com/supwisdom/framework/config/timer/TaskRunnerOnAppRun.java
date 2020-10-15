package com.supwisdom.framework.config.timer;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.supwisdom.framework.utils.CollectionUtil;
import com.supwisdom.framework.utils.SystemConstant;
import com.supwisdom.framework.web.domain.entity.TimerTask;
import com.supwisdom.framework.web.service.TimerTaskService;


@Configuration
public class TaskRunnerOnAppRun implements ApplicationRunner{

    @Resource
    private TimerTaskService timerTaskService;
    @Resource
    private CronTaskRegistrar cronTaskRegistrar;
    @Resource
    private SchedulingFunctions schedulingFunctions;
    
    
    @Override
    public void run(ApplicationArguments args) throws Exception {
        runDBSchedule();
    }

    
    private void runDBSchedule() {
        // 查询全部可用得定时任务
        List<TimerTask> tasks = timerTaskService.list(
                Wrappers.<TimerTask>lambdaQuery().eq(TimerTask::getEnable, SystemConstant.ENABLE));
        
        // 逐个添加定时任务
        if (!CollectionUtil.isEmpty(tasks)) {
            tasks.forEach(task -> {
                cronTaskRegistrar.addCronTask(task);
            });
        }
    }
}
