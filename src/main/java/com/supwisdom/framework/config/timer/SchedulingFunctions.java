package com.supwisdom.framework.config.timer;

import java.util.Date;

import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.supwisdom.framework.utils.CronUtil;
import com.supwisdom.framework.web.domain.entity.Log;
import com.supwisdom.framework.web.domain.entity.TimerTask;
import com.supwisdom.framework.web.service.LogService;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Component
public class SchedulingFunctions {

    
    private LogService logService;
    
    
    /**
     * 清除三天前的日志记录 且把该日志记录归档整理成excel
     */
    @Description("按固定周期归档并清理日志")
    @Transactional(rollbackFor= {Exception.class})
    public void handleLog(TimerTask task) {
        // 根据cron表达式得到上一个执行日期
        Date lastTaskExecDate = CronUtil.getLastTriggerTime(task.getCorn());
        
        // TODO 对将要删除的日志进行归档处理
        
        // 删除上一个周期前得全部日志
        logService.remove(Wrappers.<Log>lambdaUpdate().le(Log::getAccessTime, lastTaskExecDate));
    }
    
    
}
