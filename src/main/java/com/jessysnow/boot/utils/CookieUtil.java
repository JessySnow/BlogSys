package com.jessysnow.boot.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Cookie 相关的工具类
 */
public class CookieUtil {

    /**
     * 向 Cookie 中添加当前登录用户的 id
     * @param userId 用户 id
     */
    public static void addUserIdToCookie(long userId, HttpServletResponse httpServletResponse){
        Cookie cookie = new Cookie("userId", String.valueOf(userId));
        cookie.setPath("/");
        cookie.setMaxAge(60 * 30);
        httpServletResponse.addCookie(cookie);
    }

    /**
     * 检查当前用户 id 是否在 cookie 中
     * @return 存在 -> true
     *          不存在 -> false
     */
    public static boolean checkUserIdInCookie(HttpServletRequest httpServletRequest){
        if(httpServletRequest.getCookies() == null || httpServletRequest.getCookies().length == 0)
            return false;

        for(Cookie cookie : httpServletRequest.getCookies()){
            if("userId".equals(cookie.getName())){
                return true;
            }
        }
        return false;
    }

    /**
     * 将 用户 id 从 Cookie 中删除
     */
    public static void removeUserIdFromCookie(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        Cookie[] cookies = httpServletRequest.getCookies();
        for(Cookie cookie : cookies){
            if("userId".equals(cookie.getName())){
                cookie.setPath("/");
                cookie.setMaxAge(0);
                httpServletResponse.addCookie(cookie);
                return;
            }
        }
    }

    /**
     * 从 Cookie 中获取 用户 id
     * @return 用户 id
     */
    public static long getUserIdFromCookie(HttpServletRequest httpServletRequest){
        Cookie[] cookies = httpServletRequest.getCookies();
        for(Cookie cookie : cookies)
            if("userId".equals(cookie.getName()))
                return Long.parseLong(cookie.getValue());
        return -1L;
    }
}
