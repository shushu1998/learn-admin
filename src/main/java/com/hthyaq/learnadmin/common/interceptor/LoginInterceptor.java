package com.hthyaq.learnadmin.common.interceptor;

import com.hthyaq.learnadmin.common.constants.GlobalConstants;
import com.hthyaq.learnadmin.model.entity.SysUser;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        //获取session域中的user_id
        SysUser sysUser = (SysUser) request.getSession().getAttribute(GlobalConstants.LOGIN_NAME);
        if (sysUser == null) {
            throw new RuntimeException(GlobalConstants.USER_NO_LOGIN);
        }
        return true;
    }
}
