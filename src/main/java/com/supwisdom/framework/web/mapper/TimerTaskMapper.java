package com.supwisdom.framework.web.mapper;

import com.supwisdom.framework.web.domain.entity.TimerTask;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;



/**
 * 定时器任务 Mapper 接口
 * 使用自定义逆向生成模板, 模板文件位置classpath：templates/mybatisCodeGen/mapper.java.ftl
 * @author zhenyuan.bi
 * @since 2020-10-01
 */
 
@Mapper
public interface TimerTaskMapper extends BaseMapper<TimerTask> {

}