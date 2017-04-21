package com.zhxp.web.service;

import com.zhxp.common.consts.App;
import com.zhxp.web.dto.ResultDto;
import com.zhxp.web.entity.*;
import com.zhxp.web.mapper.*;
import com.zhxp.web.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhh on 2017/4/16.
 */
@Service
public class EvaluateService {

    @Autowired
    private EvaluateInfoMapper evaluateInfoMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private EvaluateRecordMapper evaluateRecordMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    /**
     * 跟据类型获取评价指标
     * @param type
     * @return
     */
    public ResultDto getEvaluateByType(Integer type){
        return new ResultDto(App.ResponseCode.API_RESULT_CODE_FOR_SUCCEES, evaluateInfoMapper.selectByType(type));
    }

    /**
     * 开启(关闭)评价
     * @param id
     * @param type
     * @param status
     * @return
     */
    @Transactional
    public ResultDto operate(Integer id, Integer type, Integer status){
        Course course = courseMapper.selectCourseInfoById(id);
        if(course==null)
            return new ResultDto(App.ResponseCode.API_RESULT_CODE_FOR_FAIL, "未找到该课程信息");
        courseMapper.setEvaluate(id, type, status);
        if(status==1) //关闭
            return new ResultDto(App.ResponseCode.API_RESULT_CODE_FOR_SUCCEES, App.ResponseCode.API_RESULT_MSG_FOR_SUCCEES);
        List<Integer> list = null;
        if(type==1)
            list = studentMapper.getIdByClassId(course.getClassId());
        else if(type==2)
            list = studentMapper.getIdByClassId(course.getClassId());
        list.stream().forEach((targetId)->{
            EvaluateRecord evaluateRecord = evaluateRecordMapper.selectByTypeTargetIdAndCourseId(type, targetId,  id);
            if(evaluateRecord==null)
            {
                evaluateRecord = new EvaluateRecord(type, targetId, id, 0, DateUtils.getCurTime());
                evaluateRecordMapper.insert(evaluateRecord);
            }

        });
        return new ResultDto(App.ResponseCode.API_RESULT_CODE_FOR_SUCCEES, App.ResponseCode.API_RESULT_MSG_FOR_SUCCEES);
    }

    public ResultDto selectStudentEvalluateRecord(Integer pageNo, Integer isComplete, Integer targetId, Integer type){
        Page<Map<String, String>> page = new Page<>();
        page.setPageSize(10);
        page.setPageNo(pageNo);
        Map<String,Object> map = new HashMap<>();
        map.put("isComplete", isComplete);
        map.put("targetId", targetId);
        map.put("type", type);
        page.setParams(map);
        page.setResults(evaluateRecordMapper.selectStudentEvalluateRecord(page));
        return new ResultDto(App.ResponseCode.API_RESULT_CODE_FOR_SUCCEES, page);
    }
}
