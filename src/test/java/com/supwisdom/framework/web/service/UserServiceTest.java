package com.supwisdom.framework.web.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.supwisdom.framework.web.domain.entity.User;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Resource
    private UserService userService;
    
    @Test
    public void test() {
        for (int i = 0; i < 20; i++) {
            User user = User.builder().username("testUser-" + i).password("111111").build();
            userService.addUserThenHandlerSomething(user);
        }
    }

}
