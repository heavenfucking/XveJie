package com.zhxp.web.controller.api;

import com.zhxp.common.consts.Url;
import com.zhxp.web.dto.ResultDto;
import com.zhxp.web.service.LoginService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;


@Api(value = "login", description = "用户登录API", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;

	/**
	 * 用户登陆
	 * @param type
	 * @param username
	 * @param password
	 * @param request
     * @return
     */
	@ApiOperation(value="用户登陆", notes="用户登陆", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value= Url.UserLoginAPI.USER_LOGIN_URL, method= RequestMethod.POST)
	public ResultDto login(@ApiParam("登录类型 1 学生登录, 2 教师登录, 3 管理员登录") @RequestParam String type,
						   @ApiParam("用户名") @RequestParam String username,
						   @ApiParam("密码") @RequestParam String password,
						   HttpServletRequest request) {
		return loginService.login(Integer.valueOf(type), username, password, request);
	}

}