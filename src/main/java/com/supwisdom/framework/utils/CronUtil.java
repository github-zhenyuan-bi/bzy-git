package com.supwisdom.framework.utils;

import java.util.Date;

import org.quartz.CronExpression;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.TriggerBuilder;

import com.supwisdom.framework.utils.parent.MyUtil;

import lombok.NonNull;

/**
 * 
 * 定时任务 周期表达式工具类
 * 
 * @author user
 *
 */
public class CronUtil implements MyUtil {

    // 上次执行时间
    public static Date getLastTriggerTime(@NonNull String cron) {
        ExceptionCheckUtil.isTrue(CronExpression.isValidExpression(cron), "非标准CRON表达式：" + cron);
        
        CronTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("Caclulate Date")
                .withSchedule(CronScheduleBuilder.cronSchedule(cron)).build();
        Date time0 = trigger.getStartTime();
        Date time1 = trigger.getFireTimeAfter(time0);
        Date time2 = trigger.getFireTimeAfter(time1);
        Date time3 = trigger.getFireTimeAfter(time2);
        long l = time1.getTime() - (time3.getTime() - time2.getTime()) * 2;
        return new Date(l);
    }

    // 获取下次执行时间（getFireTimeAfter，也可以下下次...）
    public static long getNextTriggerTime(String cron) {
        if (!CronExpression.isValidExpression(cron)) {
            return 0;
        }
        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity("Caclulate Date")
                .withSchedule(CronScheduleBuilder.cronSchedule(cron)).build();
        Date time0 = trigger.getStartTime();
        Date time1 = trigger.getFireTimeAfter(time0);
        return time1.getTime();
    }
}
