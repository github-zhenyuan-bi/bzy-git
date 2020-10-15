package com.supwisdom.framework.web.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.supwisdom.framework.config.aop.annotation.formvalidate.BaseValidation;
import com.supwisdom.framework.config.shiro.ShiroConfig;
import com.supwisdom.framework.web.controller.parent.MyAbstractController;
import com.supwisdom.framework.web.domain.bean.R;
import com.supwisdom.framework.web.domain.entity.User;

@Controller
public class LoginController extends MyAbstractController{
    
    
    @Resource
    private ShiroConfig shiroConfig;
    
    
    /**
     * 进入登录页
     */
    @GetMapping("login")
    public String login(HttpServletRequest request, Map<String, Object> model) {
        model.putAll(getParams(request));
        return goPage("login");
    }
    
    @PostMapping("login")
    public @ResponseBody R<String> loginAction(
            @Validated({BaseValidation.class}) User user, BindingResult bindingResult,
            HttpServletRequest request) {
        shiroConfig.shiroLogin(user); 
        return R.<String>builder().code(R.SUCCESS).msg("ok").data("/script/business/show").build();
    }
}
