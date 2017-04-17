package com.zhxp.web.mapper;

import com.zhxp.web.entity.ClassInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by zhh on 2017/4/17.
 */
public interface ClassInfoMapper {

    Integer insert(ClassInfo classInfo);

    Integer delete(Integer id);

    Integer update(ClassInfo info);

    List<Map<String, String>> selectClassNameAndId();
}
