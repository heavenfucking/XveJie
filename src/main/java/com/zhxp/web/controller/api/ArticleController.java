package com.zhxp.web.controller.api;


import com.zhxp.web.entity.NewsInfo;
import com.zhxp.web.entity.PageInfo;
import com.zhxp.web.service.NewService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
@Api(value = "article", description = "文章API", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@RequestMapping(value="/article")
public class ArticleController {
	@Autowired
	private NewService newService;

	/**
	 * Index
	 * @param model
	 * @param request
	 */
	@ApiOperation(value="获取用户列表", notes="获取用户列表")
	@RequestMapping(value={"list"}, method= RequestMethod.GET)
	public Object index(@ApiParam("页码") @RequestParam(defaultValue = "1") Integer pageNo) {
		int pageNumber = Integer.valueOf(pageNo);
		int total = newService.findCount();
		PageInfo<NewsInfo> pageInfo = new PageInfo<>(total, pageNumber);
		pageInfo.setList(newService.findAll(pageInfo.getPageStart()));
		return pageInfo;
	}
	
	/**
	 * Detail
	 * @param model
	 * @param id
	 */
	@ApiOperation(value = "文章详情", notes = "文章详情")
	@RequestMapping(value = "detail/{id}", method= RequestMethod.GET)
	public Object detail(@ApiParam("序号") @PathVariable int id) {
		return newService.findOne(id);
	}
}