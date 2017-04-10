package com.zhxp.web.service;


import com.zhxp.web.entity.Page;
import com.zhxp.web.entity.Student;
import com.zhxp.web.entity.User;
import com.zhxp.web.mapper.StudentMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Created by zhu on 2017/3/28.
 */
@Service
public class StudentService {


    @Autowired
    private StudentMapper studentMapper;

    public List<Student> getStuddentList(Page page){
        return studentMapper.getStudentList(page);
    }

    public Integer addStudent(Student student){
        return studentMapper.insert(student);
    }

    public Integer deleteStudent(Integer id){
        return studentMapper.delete(id);
    }

    public Integer updateStudent(Student student){
        return studentMapper.update(student);
    }


}
