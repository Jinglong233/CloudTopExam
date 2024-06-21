package com.jl.project.utils;

import cn.dev33.satoken.secure.SaSecureUtil;

import java.util.Random;

public class MD5Util {
    /**
     * 获取加密密码字符串
     *
     * @param password 密码
     * @param salt     盐值
     * @return
     */
    public static String getMD5Encode(String password, String salt) {
        return SaSecureUtil.md5(password + salt);
    }


    /**
     * 获取盐值
     *
     * @param password
     * @return
     */
    public static String getSalt(String password) {
        char[] chars = password.toCharArray();
        StringBuilder salt = new StringBuilder();
        for (int i = 0; i < password.length(); i++) {
            char aChar = chars[new Random().nextInt(chars.length)];
            salt.append(aChar);
        }
        return salt.toString();
    }

}
