package com.zhxp.web.service;

import com.zhxp.common.consts.App;
import com.zhxp.web.dto.ResultDto;
import com.zhxp.web.dto.UserDto;
import com.zhxp.web.entity.Student;
import com.zhxp.web.entity.Teacher;
import com.zhxp.web.mapper.StudentMapper;
import com.zhxp.web.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 用户登录服务类
 * Created by zhu on 2017/4/1.
 */
@Service
public class LoginService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    /**
     * 用户登陆验证
     * @param type
     * @param username
     * @param password
     * @param request
     * @return
     */
    public ResultDto login(Integer type, String username, String password, HttpServletRequest request){
        request.getSession().setAttribute(App.Session.SESSION_USER_LOGIN_TYPE_KEY, type);
        if(type==1){
            Student student = studentMapper.selectByNo(username);
            if(student==null)
            {
                return new ResultDto(App.ResponseCode.API_RESULT_CODE_FOR_FAIL, "账号错误");
            }
            if(student.getPassword().equals(password)== false)
            {
                return new ResultDto(App.ResponseCode.API_RESULT_CODE_FOR_FAIL, "密码错误");
            }
            request.getSession().setAttribute(App.Session.SESSION_USER_LOGIN_OBJ_KEY, student);
            return new ResultDto(App.ResponseCode.API_RESULT_CODE_FOR_SUCCEES, new UserDto(1, student));
        }

        if(type==2){
            Teacher teacher = teacherMapper.selectByNo(username);
            if(teacher==null)
            {
                return new ResultDto(App.ResponseCode.API_RESULT_CODE_FOR_FAIL, "账号错误");
            }
            if(teacher.getPassword().equals(password)== false)
            {
                return new ResultDto(App.ResponseCode.API_RESULT_CODE_FOR_FAIL, "密码错误");
            }
            request.getSession().setAttribute(App.Session.SESSION_USER_LOGIN_OBJ_KEY, teacher);
            return new ResultDto(App.ResponseCode.API_RESULT_CODE_FOR_SUCCEES, new UserDto(2, teacher));
        }
        if(type==3){
            Teacher teacher = new Teacher();
            teacher.setName("管理员");
            request.getSession().setAttribute(App.Session.SESSION_USER_LOGIN_OBJ_KEY, teacher);
            return new ResultDto(App.ResponseCode.API_RESULT_CODE_FOR_SUCCEES, new UserDto(3, teacher));
        }
        return new ResultDto(App.ResponseCode.API_RESULT_CODE_FOR_FAIL, "错误");
    }

    /**
     * 修改登录密码
     * @param password
     * @param request
     * @return
     */
    public ResultDto updatePassword(String password, HttpServletRequest request) {
        HttpSession hs = request.getSession();
        Integer type = (Integer) hs.getAttribute(App.Session.SESSION_USER_LOGIN_TYPE_KEY);
        if(type==1){
            Student  userObj  = (Student) hs.getAttribute(App.Session.SESSION_USER_LOGIN_OBJ_KEY);
            userObj.setPassword(password);
            studentMapper.update(userObj);
            hs.setAttribute(App.Session.SESSION_USER_LOGIN_OBJ_KEY, userObj);
            return new ResultDto(App.ResponseCode.API_RESULT_CODE_FOR_SUCCEES, App.ResponseCode.API_RESULT_MSG_FOR_SUCCEES);
        }
        if(type==2){
            Teacher  userObj  = (Teacher) hs.getAttribute(App.Session.SESSION_USER_LOGIN_OBJ_KEY);
            userObj.setPassword(password);
            teacherMapper.update(userObj);
            hs.setAttribute(App.Session.SESSION_USER_LOGIN_OBJ_KEY, userObj);
            return new ResultDto(App.ResponseCode.API_RESULT_CODE_FOR_FAIL, App.ResponseCode.API_RESULT_MSG_FOR_FAIL);
        }
        return new ResultDto(App.ResponseCode.API_RESULT_CODE_FOR_FAIL, App.ResponseCode.API_RESULT_MSG_FOR_FAIL);
    }
}
