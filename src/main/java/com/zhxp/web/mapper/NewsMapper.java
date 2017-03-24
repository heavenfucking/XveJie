package com.zhxp.web.mapper;



import com.zhxp.web.entity.NewsInfo;

import java.util.List;

public interface NewsMapper {

	/**
	 * findAll
	 * @param pageNo
	 */
	List<NewsInfo> findAll(int pageNo);
	
	/**
	 * 查询一条记录
	 * @param id
	 * @return
	 */
	NewsInfo findOne(int id);
	
	/**
	 * save
	 * @param info
	 */
	void save(NewsInfo info);
	
	/**
	 * findCount
	 */
	int findCount();
}
