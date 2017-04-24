package com.zhxp.web.mapper;

import com.zhxp.web.entity.EvaluateRecord;
import com.zhxp.web.entity.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by zhh on 2017/4/20.
 */
public interface EvaluateRecordMapper {

    Integer insert(EvaluateRecord evaluateRecord);

    EvaluateRecord selectByTypeTargetIdAndCourseId(@Param(value = "type")Integer type,
                                                   @Param(value = "targetId")Integer targetId,
                                                   @Param(value = "courseId")Integer courseId);

    List<Map<String, String>> selectStudentEvalluateRecord(Page page);

    Integer setComplete(@Param(value = "status") Integer status,
                        @Param(value = "id") Integer id);

}
