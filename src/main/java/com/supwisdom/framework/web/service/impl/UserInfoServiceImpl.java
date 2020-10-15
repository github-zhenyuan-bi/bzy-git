package com.supwisdom.framework.web.service.impl;

import com.supwisdom.framework.web.domain.entity.UserInfo;
import com.supwisdom.framework.web.mapper.UserInfoMapper;
import com.supwisdom.framework.web.service.UserInfoService;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户基本信息表 服务实现类
 * 使用自定义逆向生成模板, 模板文件位置classpath：templates/mybatisCodeGen/serviceImpl.java.ftl
 * @author zhenyuan.bi
 * @since 2020-09-07
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;

}