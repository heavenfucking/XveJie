package com.zhxp.web.controller.api;


import com.zhxp.common.consts.App;
import com.zhxp.common.consts.Url;
import com.zhxp.web.controller.dto.ResultDto;
import com.zhxp.web.entity.Page;
import com.zhxp.web.entity.Student;
import com.zhxp.web.entity.User;
import com.zhxp.web.service.StudentService;
import io.swagger.annotations.*;
import org.apache.coyote.Request;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by zhu on 2017/3/28.
 */
@Api(value = "student", description = "学生信息API", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @ApiOperation(value="添加", notes="根据Student对象创建用户")
    @ApiImplicitParam(name = "student", value = "用户详细实体Student", required = true, dataType = "Student")
    @RequestMapping(value=Url.StudentAPI.ADD_STUDENT_URL, method= RequestMethod.POST)
    public ResultDto addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return new ResultDto(App.ResponseCode.API_RESULT_CODE_FOR_SUCCEES, App.ResponseCode.API_RESULT_MSG_FOR_SUCCEES);
    }

    @ApiOperation(value="删除", notes="根据id删除学生")
    @RequestMapping(value=Url.StudentAPI.DEL_STUDENT_URL, method= RequestMethod.GET)
    public ResultDto deleteStudent(@ApiParam("唯一标识") @RequestParam Integer id) {
        studentService.deleteStudent(id);
        return new ResultDto(App.ResponseCode.API_RESULT_CODE_FOR_SUCCEES, id);
    }

    @ApiOperation(value="更新", notes="根据Student对象更新学生信息")
    @ApiImplicitParam(name = "student", value = "学生详细实体Student", required = true, dataType = "Student")
    @RequestMapping(value=Url.StudentAPI.UPDATE_STUDENT_URL, method= RequestMethod.POST)
    public ResultDto updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
        return new ResultDto(App.ResponseCode.API_RESULT_CODE_FOR_SUCCEES, student);
    }

    @ApiOperation(value="获取学生列表", notes="根据页号获取学生列表")
    @RequestMapping(value= Url.StudentAPI.LIST_STUDENT_URL, method= RequestMethod.GET)
    public ResultDto getStudentList(@ApiParam("页码") @RequestParam(defaultValue = "1") Integer pageNo) {
        Page<Student> page = new Page<>();
        page.setPageNo(pageNo);
        List<Student> list = studentService.getStuddentList(page);
        page.setResults(list);
        return new ResultDto(App.ResponseCode.API_RESULT_CODE_FOR_SUCCEES, page);
    }
}
