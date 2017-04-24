package com.zhxp.web.controller.api;

import com.zhxp.common.consts.App;
import com.zhxp.common.consts.Url;
import com.zhxp.web.controller.BaseController;
import com.zhxp.web.dto.ResultDto;
import com.zhxp.web.entity.*;
import com.zhxp.web.service.EvaluateService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhh on 2017/4/16.
 */
@Api(value = "evaluate", description = "评价API", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class EvaluateController extends BaseController{

    @Autowired
    private EvaluateService evaluateService;

    @ApiOperation(value = "列表", notes = "列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页号", required = true, dataType = "int", paramType = "query"),
    })
    @RequestMapping(value = Url.EvaluateAPI.LIST_EVALUATE_OF_HOME, method = RequestMethod.POST)
    public ResultDto homelist(Integer pageNo, @RequestBody SearchParam searchParam, HttpServletRequest request){
        return evaluateService.selectStudentEvalluateRecord(pageNo, searchParam.getIsComplete(), getUserId(request), getUserType(request));
    }


    @ApiOperation(value = "评价指标", notes = "根据类型和（evaluate_record主键标识）获取评价指标")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页号", required = true, dataType = "int", paramType = "path"),
    })
    @RequestMapping(value = Url.EvaluateAPI.LIST_EVALUATE_QUOTA, method = RequestMethod.GET)
    public ResultDto evaluateList(@PathVariable Integer recordId, HttpServletRequest request){
        return evaluateService.getEvaluateByType(getUserType(request), getUserId(request), recordId);
    }

    @ApiOperation(value = "开启(关闭)评价", notes = "开启(关闭)评价")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "courseId", value = "课程唯一标识", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "type", value = "类型: 1 学生, 2 教师, 3 领导", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "status", value = "状态: 1 开启, 2 关闭", required = true, dataType = "int", paramType = "query")
    })
    @RequestMapping(value = Url.EvaluateAPI.ON_OR_OFF_EVALUATE, method = RequestMethod.GET)
    public ResultDto operate(Integer courseId, Integer type, Integer status){
        return evaluateService.operate(courseId, type, status);
    }



    @ApiOperation(value = "更新EvaluateResult", notes = "更新EvaluateResult")
    @ApiImplicitParam(name = "evaluateResult", value = "EvaluateResult对象", required = true, dataType = "EvaluateResult")
    @RequestMapping(value = Url.EvaluateAPI.UPDATE_EVALUATE_RESULT, method = RequestMethod.POST)
    public ResultDto updateEvaluateResult(@RequestBody EvaluateResult evaluateResult,
                                          HttpServletRequest request){
        return evaluateService.updateEvaluateResult(evaluateResult, getUserType(request));
    }
}
