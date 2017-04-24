package com.zhxp.web.mapper;

import com.zhxp.web.entity.EvaluateResult;

/**
 * Created by zhh on 2017/4/23.
 */
public interface EvaluateResultMapper {

    Integer insert(EvaluateResult evaluateResult);

    Integer update(EvaluateResult evaluateResult);

    Integer getCountByRecordId(Integer recordId);

}
