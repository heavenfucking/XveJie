package com.zhxp.web.controller.api;

import com.zhxp.common.consts.App;
import com.zhxp.common.consts.Url;
import com.zhxp.web.dto.ResultDto;
import com.zhxp.web.entity.Course;
import com.zhxp.web.service.CourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zhu on 2017/4/5.
 */
@Api(value = "course", description = "课程API", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @ApiOperation(value="添加", notes="根据Course对象创建课程")
    @ApiImplicitParam(name = "course", value = "用户详细实体Course", required = true, dataType = "Course")
    @RequestMapping(value= Url.CourseAPI.ADD_COURSE_URL, method= RequestMethod.POST)
    public ResultDto addStudent(@RequestBody Course course) {
        return courseService.add(course);
    }

    @ApiOperation(value = "删除", notes = "根据id删除")
    @RequestMapping(value = Url.CourseAPI.DEL_COURSE_URL, method = RequestMethod.GET)
    public ResultDto delete(Integer id){
        return courseService.delete(id);
    }


    @ApiOperation(value = "更新", notes = "根据Course对象更新信息")
    @ApiImplicitParam(name = "course", value = "课程详细实体Course", required = true, dataType = "Course")
    @RequestMapping(value = Url.CourseAPI.UPDATE_COURSE_URL, method = RequestMethod.POST)
    public ResultDto update(@RequestBody Course course){
        return courseService.update(course);
    }

    @ApiOperation(value = "列表", notes = "根据页号获取课程列表")
    @RequestMapping(value = Url.CourseAPI.LIST_COURSE_URL, method = RequestMethod.POST)
    public ResultDto list(Integer pageNo){
        return courseService.list(pageNo);
    }

    @ApiOperation(value = "根据id查询", notes = "根据id查询课程信息")
    @ApiImplicitParam(name = "id",value = "课程唯一标识",  dataType = "int",paramType = "path")
    @RequestMapping(value = Url.CourseAPI.LIST_COURSE_INFO_URL, method = RequestMethod.GET)
    public ResultDto getCourseInfoById(@PathVariable Integer id){
        return courseService.getCourseInfoById(id);
    }
}
