package com.supwisdom.framework.config.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import com.supwisdom.framework.config.interceptor.parent.MyAbstractInterceptor;
import com.supwisdom.framework.utils.DateUtil;
import com.supwisdom.framework.web.domain.entity.Log;
import com.supwisdom.framework.web.domain.entity.User;
import com.supwisdom.framework.web.mapper.LogMapper;

import lombok.NoArgsConstructor;


@NoArgsConstructor
public class FrameworkInterceptor extends MyAbstractInterceptor implements HandlerInterceptor {

    
    
    public FrameworkInterceptor(LogMapper logMapper) {
        super(logMapper);
    }
    
    

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        String accessor = user == null? null : user.getId();
        logMapper.insert(Log.builder()
                .id(null)
                .accessor(accessor)
                .accessTime(DateUtil.getNow())
                .accessModule(request.getRequestURI())
                .accessorIp(request.getRemoteAddr())
                .field1("框架数据")
                .field2(ex == null? null : ex.getMessage())
                .build());
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    
}
