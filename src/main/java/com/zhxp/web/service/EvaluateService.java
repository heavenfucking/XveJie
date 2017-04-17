package com.zhxp.web.service;

import com.zhxp.common.consts.App;
import com.zhxp.web.dto.ResultDto;
import com.zhxp.web.entity.EvaluateInfo;
import com.zhxp.web.mapper.EvaluateInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhh on 2017/4/16.
 */
@Service
public class EvaluateService {

    @Autowired
    private EvaluateInfoMapper evaluateInfoMapper;

    /**
     * 跟据类型获取评价指标
     * @param type
     * @return
     */
    public ResultDto getEvaluateByType(Integer type){
        return new ResultDto(App.ResponseCode.API_RESULT_CODE_FOR_SUCCEES, evaluateInfoMapper.selectByType(type));
    }
}
