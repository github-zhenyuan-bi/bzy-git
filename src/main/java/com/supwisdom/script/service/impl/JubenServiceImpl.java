package com.supwisdom.script.service.impl;

import com.supwisdom.script.domain.entity.Juben;
import com.supwisdom.script.mapper.JubenMapper;
import com.supwisdom.script.service.JubenService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * 剧本 服务实现类
 * 使用自定义逆向生成模板, 模板文件位置classpath：templates/mybatisCodeGen/serviceImpl.java.ftl
 * @author zhenyuan.bi
 * @since 2020-10-08
 */
@Service
public class JubenServiceImpl extends ServiceImpl<JubenMapper, Juben> implements JubenService {

    @Resource
    private JubenMapper jubenMapper;

    
    
    @Override
    public void addJuben(Juben juben) {
        // 1. 剧本数据进行验证
        checkJuben(juben);
        
        // 2. 入库
        save(juben);
    }

    
    
    /**
     * 校验剧本数据
     * @param juben
     */
    private void checkJuben(Juben juben) {
        if (StringUtils.isEmpty(juben.getName()))
            throw new IllegalArgumentException("剧本名称不能为空");
        
        // 名称唯一性检验
        int count = this.count(Wrappers.<Juben>lambdaQuery()
                .eq(Juben::getName, juben.getName())
                .ne(!StringUtils.isEmpty(juben.getId()), Juben::getId, juben.getId()));
        if (count > 0)
            throw new IllegalArgumentException("剧本名称已被使用：" + juben.getName());
    }
}