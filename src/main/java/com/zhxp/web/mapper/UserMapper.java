package com.zhxp.web.mapper;


import com.zhxp.web.entity.UserInfo;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

	@Select("select *from t_user where account=#{account}")
	UserInfo findByAccount(String account);
}
