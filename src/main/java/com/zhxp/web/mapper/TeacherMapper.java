package com.zhxp.web.mapper;

import com.zhxp.web.entity.Page;
import com.zhxp.web.entity.Teacher;

import java.util.List;
import java.util.Map;

/**
 * Created by zhu on 2017/3/30.
 */

public interface TeacherMapper {

    List<Teacher> selectByPage(Page page);

    Integer insert(Teacher teacher);

    Integer update(Teacher teacher);

    Integer delete(Integer id);

    Teacher selectByNo(String no);

    List<Map<String, String>> getNoAndName();

}
