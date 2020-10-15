package com.supwisdom.framework.utils;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.stream.Stream;

import org.springframework.context.annotation.Description;
import org.springframework.util.ClassUtils;

import com.google.common.collect.Maps;
import com.supwisdom.framework.config.timer.SchedulingFunctions;
import com.supwisdom.framework.utils.parent.MyUtil;


/**
 * 
 * 类反射处理工具
 * @author user
 *
 */
public class ClassUtil extends ClassUtils implements MyUtil {

    
    /**
     * 反射方法拿到定时器任务得可执行方法和对应说明
     * @return
     */
    public static Map<String, String>getSchedulingTaskExcutiveMethodInfo() {
        Class<SchedulingFunctions> clazz = SchedulingFunctions.class;
        Method[] methods = clazz.getDeclaredMethods();
        Map<String, String> res = Maps.newHashMap();
        if (methods != null && methods.length > 0) {
            Stream.<Method>of(methods).forEach(m -> {
                String methodName = m.getName();
                Description desc = m.getAnnotation(Description.class);
                if (desc != null) {
                    String methodDesc = desc.value();
                    res.put(methodName, methodDesc);
                }
            });
        }
        return res;
    }
}
