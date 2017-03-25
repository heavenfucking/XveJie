package com.zhxp.web.controller.web;


import com.zhxp.web.entity.NewsInfo;
import com.zhxp.web.entity.PageInfo;
import com.zhxp.web.service.NewService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {
	@Autowired
	private NewService newService;


	
	/**
	 * Detail
	 * @param model
	 * @param id
	 */
	@RequestMapping("detail/{id}")
	public String detail(Model model, @PathVariable int id) {		
		model.addAttribute("info", newService.findOne(id));
		return "detail";
	}
}