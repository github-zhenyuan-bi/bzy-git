package com.supwisdom.framework.web.controller.parent;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;

import com.supwisdom.framework.utils.SystemConstant;
import com.supwisdom.framework.web.domain.entity.Menu;
import com.supwisdom.framework.web.service.MenuService;


/**
 * 
 * 我的控制层抽象父类
 * @author user
 *
 */
public abstract class MyAbstractController {

    
    /**
     * 跳转页面
     * @param pagePath
     * @return
     */
    protected String goPage(String pagePath) {
        return pagePath;
    }
    
    
    /**
     * 跳转到管理页面
     */
    protected final String MANAGER_DIC = "bgManage/";
    protected String goManagementPage(String pagePath) {
        return goPage(MANAGER_DIC + pagePath);
    }
    
    
    
    protected String redirectPage(String pagePath) {
        return "redirect:" + pagePath;
    }
    
    
    
    /** 收集 HttpServletRequest 的全部参数为map */
    protected Map<String, Object> getParams(HttpServletRequest request) {
        // 收集全部参数
        Map<String, Object> res = new HashMap<>(request.getParameterMap().size());
        Enumeration<String> pNames = request.getParameterNames();
        while (pNames != null && pNames.hasMoreElements()) {
            String pName = pNames.nextElement();
            String pValue = request.getParameter(pName);
            res.put(pName, pValue);
        }
        return res;
    }
    
    

    /**
     * 从session中拿东西
     * @param request
     * @param key
     * @return
     */
    protected Object getObjFromSession(HttpServletRequest request, String key) {
        return request.getSession().getAttribute(key);
    }
    
    /**
     * session里放东西
     * @param request
     * @param key
     * @param value
     */
    protected void setValueToSession(HttpServletRequest request, String key, Object value) {
        request.getSession().setAttribute(key, value);
    }
    
    
    protected void prepareMenuData(HttpServletRequest request, Map<String, Object> model
            , MenuService menuService) {
        List<Menu> menuList = menuService.getByTypeThenOrder(SystemConstant.BACKGROUND_MANAGER_MENU_KEY);
        model.put("bgManageMenus", menuList);
        Object id = request.getParameter("id");
        if (!StringUtils.isEmpty(id)) {
            model.put("curMenu", menuService.getById(id.toString()));
        }
    }
    
    
}
