package com.zhxp.web.service;

import com.zhxp.common.consts.App;
import com.zhxp.web.dto.ResultDto;
import com.zhxp.web.mapper.ClassInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhh on 2017/4/17.
 */
@Service
public class ClassInfoService {

    @Autowired
    private ClassInfoMapper classInfoMapper;

    public ResultDto selectClassNameAndId(){
        return new ResultDto(App.ResponseCode.API_RESULT_CODE_FOR_SUCCEES, classInfoMapper.selectClassNameAndId());
    }
}
