package com.supwisdom.framework.web.service.impl;

import com.supwisdom.framework.web.domain.entity.Constant;
import com.supwisdom.framework.web.mapper.ConstantMapper;
import com.supwisdom.framework.web.service.ConstantService;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 系统常量表 服务实现类
 * 使用自定义逆向生成模板, 模板文件位置classpath：templates/mybatisCodeGen/serviceImpl.java.ftl
 * @author zhenyuan.bi
 * @since 2020-10-01
 */
@Service
public class ConstantServiceImpl extends ServiceImpl<ConstantMapper, Constant> implements ConstantService {

    @Resource
    private ConstantMapper constantMapper;

}