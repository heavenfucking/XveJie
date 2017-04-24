package com.zhxp.web.controller;

import com.zhxp.common.consts.App;
import com.zhxp.web.entity.Student;
import com.zhxp.web.entity.Teacher;
import com.zhxp.web.exception.SessionException;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhh on 2017/4/23.
 */
public class BaseController {

    /**
     * 从session中获取UserId
     * @param request
     * @return
     */
    public Integer getUserId(HttpServletRequest request){
        Integer userType = (Integer) request.getSession().getAttribute(App.Session.SESSION_USER_LOGIN_TYPE_KEY);
        try {
            if(userType==null)
                throw new SessionException("");
        } catch (SessionException e) {
            e.printStackTrace();
        }
        Integer targetId = null;
        if(userType==1)
        {
            Student student= (Student)request.getSession().getAttribute(App.Session.SESSION_USER_LOGIN_OBJ_KEY);
            targetId = student.getId();
        }
        if(userType==2)
        {
            Teacher teacher= (Teacher) request.getSession().getAttribute(App.Session.SESSION_USER_LOGIN_OBJ_KEY);
            targetId = teacher.getId();
        }
        return targetId;
    }

    /**
     * 从session中获取UserType 1 学生 2 教师
     * @param request
     * @return
     */
    public Integer getUserType(HttpServletRequest request){
        Integer userType = (Integer) request.getSession().getAttribute(App.Session.SESSION_USER_LOGIN_TYPE_KEY);
        try {
            if(userType==null)
                throw new SessionException("");
        } catch (SessionException e) {
            e.printStackTrace();
        }

        return userType;
    }
}
