package com.zhxp.web.controller.api;

import com.zhxp.common.consts.Url;
import com.zhxp.web.dto.ResultDto;
import com.zhxp.web.entity.Teacher;
import com.zhxp.web.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zhu on 2017/3/30.
 */
@Api(value = "teacher", description = "教师信息API", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @ApiOperation(value="添加", notes="根据Teacher对象创建用户")
    @ApiImplicitParam(name = "teacher", value = "教师详细实体teacher", required = true, dataType = "Teacher")
    @RequestMapping(value= Url.TeacherAPI.ADD_TEACHER_URL, method= RequestMethod.POST)
    public ResultDto addStudent(@RequestBody Teacher teacher) {
        return teacherService.save(teacher);
    }

    @ApiOperation(value="删除", notes="根据id删除教师")
    @RequestMapping(value=Url.TeacherAPI.DEL_TEACHER_URL, method= RequestMethod.GET)
    public ResultDto deleteStudent(@ApiParam("唯一标识") @RequestParam Integer id) {
        return teacherService.delete(id);
    }

    @ApiOperation(value="更新", notes="根据Teacher对象更新学生信息")
    @ApiImplicitParam(name = "teacher", value = "教师详细实体Teacher", required = true, dataType = "Teacher")
    @RequestMapping(value=Url.TeacherAPI.UPDATE_TEACHER_URL, method= RequestMethod.POST)
    public ResultDto updateStudent(@RequestBody Teacher teacher) {
        return teacherService.update(teacher);
    }

    @ApiOperation(value="获取教师列表", notes="根据页号获取教师列表")
    @RequestMapping(value= Url.TeacherAPI.LIST_TEACHER_URL, method= RequestMethod.POST)
    public ResultDto getStudentList(@ApiParam("页码") @RequestParam(defaultValue = "1") Integer pageNo) {
        return teacherService.getList(pageNo);
    }

    @ApiOperation(value="获取教师编号和姓名", notes="获取教师编号和姓名")
    @RequestMapping(value= Url.TeacherAPI.MAP_TEACHER_URL, method= RequestMethod.GET)
    public ResultDto getNoAndName() {
        return teacherService.getNoAndName();
    }
}
