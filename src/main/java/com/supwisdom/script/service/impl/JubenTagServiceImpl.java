package com.supwisdom.script.service.impl;

import com.supwisdom.script.domain.entity.JubenTag;
import com.supwisdom.script.mapper.JubenTagMapper;
import com.supwisdom.script.service.JubenTagService;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 剧本-标签关系表 服务实现类
 * 使用自定义逆向生成模板, 模板文件位置classpath：templates/mybatisCodeGen/serviceImpl.java.ftl
 * @author zhenyuan.bi
 * @since 2020-10-08
 */
@Service
public class JubenTagServiceImpl extends ServiceImpl<JubenTagMapper, JubenTag> implements JubenTagService {

    @Resource
    private JubenTagMapper jubenTagMapper;

}