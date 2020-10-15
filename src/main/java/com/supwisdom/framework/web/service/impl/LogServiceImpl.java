package com.supwisdom.framework.web.service.impl;

import com.supwisdom.framework.web.domain.entity.Log;
import com.supwisdom.framework.web.mapper.LogMapper;
import com.supwisdom.framework.web.service.LogService;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 日志记录 服务实现类
 * 使用自定义逆向生成模板, 模板文件位置classpath：templates/mybatisCodeGen/serviceImpl.java.ftl
 * @author zhenyuan.bi
 * @since 2020-10-01
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements LogService {

    @Resource
    private LogMapper logMapper;

}