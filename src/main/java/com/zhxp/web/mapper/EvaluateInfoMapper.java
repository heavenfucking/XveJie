package com.zhxp.web.mapper;

import com.zhxp.web.entity.EvaluateInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by zhh on 2017/4/16.
 */
public interface EvaluateInfoMapper {

    List<EvaluateInfo>  selectByType(Integer type);

    List<Map<String, String>> selectByTypeAndRecordId(@Param(value = "type") Integer type,
                                                      @Param(value = "targetId") Integer targetId,
                                                      @Param(value = "recordId") Integer recordId);

    List<Integer> selectPrimaryIdByType(Integer type);

    Integer getCountByType(Integer type);

}
