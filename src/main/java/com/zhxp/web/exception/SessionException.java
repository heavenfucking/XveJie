package com.zhxp.web.exception;

/**
 * Created by zhu on 2017/3/31.
 */
public class SessionException extends Exception{

    private Integer code;

    private String  msg;

    public SessionException(String message) {
        super(message);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
