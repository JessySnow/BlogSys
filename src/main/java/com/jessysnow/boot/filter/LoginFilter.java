package com.jessysnow.boot.filter;

import com.jessysnow.boot.utils.CookieUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 权限校验过滤器
 * 如果发现 Cookie 中不存在 userId 的记录
 * 则限制访问的路径：
 *              /user/login
 *              /user/test
 *              /blog/
 */
@Component
public class LoginFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        // 不需要登录即可访问的 URL
        if("/user/login".equals(httpServletRequest.getRequestURI())
                || "/blog/test".equals(httpServletRequest.getRequestURI())
                || "/blog/".equals(httpServletRequest.getRequestURI())
                || httpServletRequest.getRequestURI().startsWith("/photo")){
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return ;
        }

        // 进行请求校验，如果 cookie 存在 userid 则将其放行
        if(CookieUtil.checkUserIdInCookie(httpServletRequest)) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return ;
        }

        // 未登录的情况下返回 json 数据，提示错误
        httpServletResponse.setContentType("application/json;character=utf8");
        PrintWriter out = httpServletResponse.getWriter();
        out.write("No Right To invoke the api!");
        out.flush();
        out.close();
    }
}