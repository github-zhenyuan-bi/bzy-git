package com.supwisdom.framework.web.mapper;

import com.supwisdom.framework.web.domain.entity.Constant;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;

import com.supwisdom.framework.config.mybatis.MybatisCacheConfig;


/**
 * 系统常量表 Mapper 接口
 * 使用自定义逆向生成模板, 模板文件位置classpath：templates/mybatisCodeGen/mapper.java.ftl
 * @author zhenyuan.bi
 * @since 2020-10-01
 */
 
@Mapper
@CacheNamespace(implementation=MybatisCacheConfig.class, eviction=MybatisCacheConfig.class)
public interface ConstantMapper extends BaseMapper<Constant> {

}