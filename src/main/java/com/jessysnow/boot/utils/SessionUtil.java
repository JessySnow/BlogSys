package com.jessysnow.boot.utils;

import com.jessysnow.boot.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Session 相关的工具类
 */
public class SessionUtil {
    /**
     * 向 Session 中添加一个用户对象
     * @param user User 对象
     */
    public static void addUserToSession(User user, HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        session.setMaxInactiveInterval(30 * 60);
    }

    /**
     * 检查 Session 是否含有一个 user 对象
     * @return 存在 -> true
     *         不存在 -> false
     */
    public static boolean checkUserInSession(HttpServletRequest request){
        if(request.getSession(false) == null) return false;
        return request.getSession(false).getAttribute("user") != null;
    }

    /**
     * 从 Session 中删除 User 对象
     */
    public static void removeUserFromSession(HttpServletRequest request){
        request.getSession().removeAttribute("user");
    }

    /**
     * 从 Session 中获取一个用户对象
     * @return User 对象
     */
    public static User getUserFromSession(HttpServletRequest request){
        return (User) request.getSession().getAttribute("user");
    }
}
