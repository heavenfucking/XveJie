package com.zhxp.web.service;

import com.zhxp.common.consts.App;
import com.zhxp.web.dto.CourseDto;
import com.zhxp.web.dto.ResultDto;
import com.zhxp.web.entity.Course;
import com.zhxp.web.entity.Page;
import com.zhxp.web.entity.Teacher;
import com.zhxp.web.mapper.CourseMapper;
import com.zhxp.web.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhh on 2017/4/7.
 */
@Service
public class CourseService {

    @Autowired
    private CourseMapper courseMapper;

    public ResultDto add(Course course){
        courseMapper.insert(course);
        return new ResultDto(App.ResponseCode.API_RESULT_CODE_FOR_SUCCEES, App.ResponseCode.API_RESULT_MSG_FOR_SUCCEES);
    }

    public ResultDto update(Course course){
        courseMapper.update(course);
        return new ResultDto(App.ResponseCode.API_RESULT_CODE_FOR_SUCCEES, App.ResponseCode.API_RESULT_MSG_FOR_SUCCEES);
    }

    public ResultDto delete(Integer id){
        courseMapper.delete(id);
        return new ResultDto(App.ResponseCode.API_RESULT_CODE_FOR_SUCCEES, App.ResponseCode.API_RESULT_MSG_FOR_SUCCEES);
    }

    public ResultDto list(Integer pageNo) {
        Page<CourseDto> page = new Page<>();
        page.setPageNo(pageNo);
        List<CourseDto> list = courseMapper.getCourseList(page);
        page.setResults(list);
        return new ResultDto(App.ResponseCode.API_RESULT_CODE_FOR_SUCCEES, page);
    }

    public ResultDto getCourseInfoById(Integer id){
        return new ResultDto(App.ResponseCode.API_RESULT_CODE_FOR_SUCCEES, courseMapper.selectCourseInfoById(id));
    }
}
