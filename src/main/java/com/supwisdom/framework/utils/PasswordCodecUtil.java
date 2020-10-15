package com.supwisdom.framework.utils;

import org.apache.commons.codec.digest.DigestUtils;

import com.supwisdom.framework.utils.parent.MyUtil;
import com.supwisdom.framework.web.domain.entity.User;

/**
 * 
 * 密码加密工具
 * @author user
 *
 */
public class PasswordCodecUtil implements MyUtil {

    private static final String CODE_BASE = "pwd";
    
    /**
     * 对密码进行二次加密
     * @param user
     * @return
     */
    public static String sha1(User user) {
        return DigestUtils.sha1Hex(user.getUsername() + user.getPassword() + CODE_BASE);
    }
}
