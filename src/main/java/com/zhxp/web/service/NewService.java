package com.zhxp.web.service;


import com.zhxp.web.entity.NewsInfo;
import com.zhxp.web.mapper.NewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NewService {
	@Autowired
	private NewsMapper newsMapper;


	public List<NewsInfo> findAll(int pageNo) {
		return newsMapper.findAll(pageNo);
	}

	public NewsInfo findOne(int id) {
		return newsMapper.findOne(id);
	}

	@Transactional
	public void save(NewsInfo info) {
		newsMapper.save(info);
	}

	public int findCount() {
		return newsMapper.findCount();
	}
}
