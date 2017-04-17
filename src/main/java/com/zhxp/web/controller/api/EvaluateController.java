package com.zhxp.web.controller.api;

import com.zhxp.common.consts.Url;
import com.zhxp.web.dto.ResultDto;
import com.zhxp.web.service.EvaluateService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhh on 2017/4/16.
 */
@Api(value = "evaluate", description = "评价API", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class EvaluateController {

    @Autowired
    private EvaluateService evaluateService;

    @ApiOperation(value = "评价指标", notes = "根据类型获取评价指标")
    @ApiImplicitParam(name = "type",value = "评价指标 1 学生， 2 教师 ，3 领导",  dataType = "int",paramType = "query")
    @RequestMapping(value = Url.EvaluateAPI.LIST_EVALUATE_BY_TYPE, method = RequestMethod.GET)
    public ResultDto list(Integer type){
        return evaluateService.getEvaluateByType(type);
    }


}
