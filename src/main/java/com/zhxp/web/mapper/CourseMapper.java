package com.zhxp.web.mapper;

import com.zhxp.web.dto.CourseDto;
import com.zhxp.web.entity.Course;
import com.zhxp.web.entity.Page;

import java.util.List;

/**
 * Created by zhh on 2017/4/7.
 */
public interface CourseMapper {

    Integer insert(Course course);

    Integer delete(Integer id);

    Integer update(Course course);

    List<CourseDto> getCourseList(Page page);

    Course selectCourseInfoById(Integer id);

}
