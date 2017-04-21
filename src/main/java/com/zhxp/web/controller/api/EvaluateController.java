package com.zhxp.web.controller.api;

import com.zhxp.common.consts.App;
import com.zhxp.common.consts.Url;
import com.zhxp.web.dto.ResultDto;
import com.zhxp.web.entity.Course;
import com.zhxp.web.entity.SearchParam;
import com.zhxp.web.entity.Student;
import com.zhxp.web.entity.Teacher;
import com.zhxp.web.service.EvaluateService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by zhh on 2017/4/16.
 */
@Api(value = "evaluate", description = "评价API", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class EvaluateController {

    @Autowired
    private EvaluateService evaluateService;

    @ApiOperation(value = "列表", notes = "列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页号", required = true, dataType = "int", paramType = "query"),
    })
    @RequestMapping(value = Url.EvaluateAPI.LIST_EVALUATE_OF_HOME, method = RequestMethod.POST)
    public ResultDto homelist(Integer pageNo, @RequestBody SearchParam searchParam, HttpServletRequest request){
        Integer userType = (Integer) request.getSession().getAttribute(App.Session.SESSION_USER_LOGIN_TYPE_KEY);
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
        return evaluateService.selectStudentEvalluateRecord(pageNo, searchParam.getIsComplete(), targetId, userType);
    }


    @ApiOperation(value = "评价指标", notes = "根据类型获取评价指标")
    @RequestMapping(value = Url.EvaluateAPI.LIST_EVALUATE_QUOTA, method = RequestMethod.GET)
    public ResultDto evalaueteList(HttpServletRequest request){
        Integer userType = (Integer) request.getSession().getAttribute(App.Session.SESSION_USER_LOGIN_TYPE_KEY);
        return evaluateService.getEvaluateByType(userType);
    }

    @ApiOperation(value = "开启(关闭)评价", notes = "开启(关闭)评价")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "courseId", value = "课程唯一标识", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "type", value = "类型: 1 学生, 2 教师, 3 领导", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "status", value = "状态: 1 开启, 2 关闭", required = true, dataType = "int", paramType = "query")
    })
    @RequestMapping(value = Url.EvaluateAPI.ON_OR_OFF_EVALUATE, method = RequestMethod.GET)
    public ResultDto operate(Integer courseId, Integer type, Integer status){
        return evaluateService.operate(courseId, type, status);
    }


}
