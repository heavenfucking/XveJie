package com.zhxp.web.mapper;

import com.zhxp.web.entity.EvaluateInfo;

import java.util.List;

/**
 * Created by zhh on 2017/4/16.
 */
public interface EvaluateInfoMapper {

    List<EvaluateInfo>  selectByType(Integer type);

}
