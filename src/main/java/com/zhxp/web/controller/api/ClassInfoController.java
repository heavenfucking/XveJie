package com.zhxp.web.controller.api;

import com.zhxp.common.consts.Url;
import com.zhxp.web.dto.ResultDto;
import com.zhxp.web.service.ClassInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhh on 2017/4/17.
 */
@Api(value = "classInfo", description = "班级API", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class ClassInfoController {

    @Autowired
    private ClassInfoService classInfoService;


    @ApiOperation(value = "班级id 班级名", notes = "班级id 班级名")
    @RequestMapping(value = Url.ClassInfoAPI.LIST_COURSE_URL, method = RequestMethod.GET)
    public ResultDto getClassNameAndId(){
        return classInfoService.selectClassNameAndId();
    }
}
