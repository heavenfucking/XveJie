package com.zhxp.web.mapper;

import com.zhxp.web.entity.Page;
import com.zhxp.web.entity.Student;

import java.util.List;

/**
 * Created by zhu on 2017/3/28.
 */
public interface StudentMapper {

   List<Student> getStudentList(Page page);

   Integer insert(Student student);

   Integer update(Student student);

   Integer delete(Integer id);

}
