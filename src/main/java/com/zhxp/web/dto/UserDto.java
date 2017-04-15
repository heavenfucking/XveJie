package com.zhxp.web.dto;

/**
 * Created by zhh on 2017/4/14.
 */
public class UserDto {

    private Integer type;

    private Object userInfo;

    public UserDto() {
    }

    public UserDto(Integer type, Object userInfo) {
        this.type = type;
        this.userInfo = userInfo;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Object getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(Object userInfo) {
        this.userInfo = userInfo;
    }
}
