package com.zhxp.web.Interceptor;


import com.zhxp.common.consts.App;
import com.zhxp.web.exception.SessionException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 监测是否处于登录状态
 * Created by zhu on 2017/3/31.
 */
public class SessionLoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        Object obj = request.getSession().getAttribute(App.Session.SESSION_USER_LOGIN_OBJ_KEY);
//        if(obj==null)
//           throw new SessionException("未登录");
        return true;
    }
}
