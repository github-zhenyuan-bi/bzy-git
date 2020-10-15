package com.supwisdom.framework.web.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.supwisdom.framework.web.domain.entity.Role;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RoleServiceTest {

    @Resource
    private RoleService roleService;
    
    @Test
    public void test() {
        int publicRoleExisted = roleService.count(Wrappers.<Role>lambdaQuery().eq(Role::getName, "PUBLIC"));
        if (publicRoleExisted == 0) {
            Role publicRole = Role.builder().name("PUBLIC").sort(10).descrip("公共角色").build();
            roleService.save(publicRole);
        }
    }

}
