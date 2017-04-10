package com.zhxp.web.dto;

/**
 * Created by zhu on 2017/3/28.
 * 数据传输基础对象，所有返回至前端的数据格式
 */
public class ResultDto {

    private Integer code;

    private Object msg;

    public ResultDto(){
        super();
    }

    public ResultDto(Integer code, Object msg) {
        super();
        this.code = code;
        this.msg = msg;
    }
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
    public Object getMsg() {
        return msg;
    }
    public void setMsg(Object msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "BaseDto [code=" + code + ", msg=" + msg + "]";
    }
}