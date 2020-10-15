package com.supwisdom.framework.web.service.impl;

import com.supwisdom.framework.utils.PasswordCodecUtil;
import com.supwisdom.framework.web.domain.entity.User;
import com.supwisdom.framework.web.domain.entity.UserInfo;
import com.supwisdom.framework.web.mapper.UserMapper;
import com.supwisdom.framework.web.service.UserInfoService;
import com.supwisdom.framework.web.service.UserRoleService;
import com.supwisdom.framework.web.service.UserService;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * 用户 服务实现类
 * 使用自定义逆向生成模板, 模板文件位置classpath：templates/mybatisCodeGen/serviceImpl.java.ftl
 * @author zhenyuan.bi
 * @since 2020-09-07
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserInfoService userInfoService;
    
    @Resource
    private UserRoleService userRoleService;
    
    
    
    @Override
    @Transactional(rollbackFor= {Exception.class})
    public void addUserThenHandlerSomething(User user) {
        // 1. 校验数据
        checkUserData(user);
        
        // 2. 数据处理
        handleUserData(user);
        
        // 3. 保存用户信息
        if ( StringUtils.isEmpty(user.getId()) ) user.setId(null);
        boolean addUserSuccess = save(user);
        
        if (addUserSuccess) {
            // 4. 新增用户基本信息表(UserInfo)中的一条关联数据
            userInfoService.save(UserInfo.builder().id(user.getId()).build());
            
            // 5. 给用户挂上基本角色
            userRoleService.bindPublicRoleForUser(user.getId());
        }  
    }

    
    
    /**
     * 新增用户前的数据校验
     * @param user
     */
    private void checkUserData(User user) {
        // TODO 校验数据正确
    }
    
    
    
    /** 
     * 新增用户前的数据处理
     * @param user
     */
    private void handleUserData(User user) {
        // 密码加密算法
        user.setPassword(PasswordCodecUtil.sha1(user));
    }



    @Override
    public boolean removeUserByIdThenHandlerSomething(final String id) {
        // 1. 删除ID对应用户 （当前为逻辑删除）
        return removeById(id);
    }


}