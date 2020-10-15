package com.supwisdom.framework.web.service;

import com.supwisdom.framework.web.domain.entity.Role;
import com.supwisdom.framework.web.domain.entity.UserRole;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 用户角色关联关系 服务类
 * 使用自定义逆向生成模板, 模板文件位置classpath：templates/mybatisCodeGen/service.java.ftl
 * @author zhenyuan.bi
 * @since 2020-09-07
 */
public interface UserRoleService extends IService<UserRole> {
    
    /** 查询用户的全部角色 */
    List<Role> getRolesByUserId(String userId);
    
    /** 给用户绑定上公共角色 */
    void bindPublicRoleForUser(String userId);
    
    /** 修改用户角色 */
    void changeUserRoles(String userId, String[] roles);
}
