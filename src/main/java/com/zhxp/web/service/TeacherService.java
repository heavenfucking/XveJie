package com.zhxp.web.service;

import com.zhxp.common.consts.App;
import com.zhxp.web.controller.dto.ResultDto;
import com.zhxp.web.entity.Page;
import com.zhxp.web.entity.Teacher;
import com.zhxp.web.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhu on 2017/3/30.
 */
@Service
public class TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    /**
     * 分页
     * @param pageNo
     * @return
     */
    public ResultDto getList(Integer pageNo){
        Page<Teacher> page = new Page<>();
        page.setPageNo(pageNo);
        List<Teacher> list = teacherMapper.selectByPage(page);
        page.setResults(list);
        return new ResultDto(App.ResponseCode.API_RESULT_CODE_FOR_SUCCEES,page);
    }

    /**
     * 保存
     * @param teacher
     * @return
     */
    public ResultDto save(Teacher teacher){
        teacherMapper.insert(teacher);
        return new ResultDto(App.ResponseCode.API_RESULT_CODE_FOR_SUCCEES,App.ResponseCode.API_RESULT_MSG_FOR_SUCCEES);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    public ResultDto delete(Integer id){
        teacherMapper.delete(id);
        return new ResultDto(App.ResponseCode.API_RESULT_CODE_FOR_SUCCEES, App.ResponseCode.API_RESULT_MSG_FOR_SUCCEES);
    }

    /**
     * 修改
     * @param teacher
     * @return
     */
    public ResultDto update(Teacher teacher){
        teacherMapper.update(teacher);
        return new ResultDto(App.ResponseCode.API_RESULT_CODE_FOR_SUCCEES, App.ResponseCode.API_RESULT_MSG_FOR_SUCCEES);
    }

}
