package com.zhxp.web.controller.api;

import com.zhxp.common.consts.App;
import com.zhxp.common.consts.Url;
import com.zhxp.web.dto.ResultDto;
import com.zhxp.web.dto.UserDto;
import com.zhxp.web.service.LoginService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


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
						   HttpServletRequest request,
						   HttpServletResponse response) {
		return loginService.login(Integer.valueOf(type), username, password, request);
	}

	/**
	 * 用户信息
	 * @param request
	 * @return
     */
	@ApiOperation(value="用户个人信息", notes="用户个人信息", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value= Url.UserLoginAPI.USER_INFO_URL, method= RequestMethod.POST)
	public ResultDto getUserInfo(HttpServletRequest request){
		HttpSession hs = request.getSession();
		Integer userType = (Integer) hs.getAttribute(App.Session.SESSION_USER_LOGIN_TYPE_KEY);
		Object  userObj  = hs.getAttribute(App.Session.SESSION_USER_LOGIN_OBJ_KEY);
		return new ResultDto(App.ResponseCode.API_RESULT_CODE_FOR_SUCCEES, new UserDto(userType, userObj));
	}

	@ApiOperation(value="修改登录密码", notes="修改登录密码", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value= Url.UserLoginAPI.USER_PWD_UPDATE_URL, method= RequestMethod.POST)
	public ResultDto updatePassword(@ApiParam("新密码") String password, HttpServletRequest request){
		return loginService.updatePassword(password, request);
	}

}