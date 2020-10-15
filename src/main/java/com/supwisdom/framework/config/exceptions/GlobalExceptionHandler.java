package com.supwisdom.framework.config.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.supwisdom.framework.web.domain.bean.R;


@ControllerAdvice
public class GlobalExceptionHandler {
    
    /**
     * 请求参数校验异常捕捉
     */
    @ExceptionHandler({FormValidatedException.class})
    public @ResponseBody R<Object> formValidatedException( 
            HttpServletRequest request, FormValidatedException fve) {
        return R.builder().code(R.FORM_VALIDATE_ERROR).msg(fve.getMessage()).data(fve.getErrDatas()).build();
    }
    
    
    
    /**
     * shiro认证异常
     * @return
     */
    @ExceptionHandler({AuthenticationException.class})
    public @ResponseBody R<Object> shiroAuthenticationException (
            HttpServletRequest request, AuthenticationException ae) {
        return R.builder().code(R.SHIRO_AUTHENTICATION_ERROR).msg("error").data("登陆失败，原因：" + ae.getMessage()).build();
    }
    
    
    
    
    /**
     * 全局未知异常捕捉
     */
    @ExceptionHandler(value = Exception.class)
    public @ResponseBody R<Object> unknownExceptionHandler(
            HttpServletRequest req, Exception e) {
        return R.ofError(e);
    }
}