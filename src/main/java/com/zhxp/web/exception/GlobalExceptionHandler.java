package com.zhxp.web.exception;

import com.zhxp.common.consts.App;
import com.zhxp.web.dto.ResultDto;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;

/**
 * Web统一异常处理
 * Created by zhu on 2017/3/31.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = Logger.getLogger(getClass());
    /**
     * 捕获用户未登录则抛出该异常
     * @param req
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = SessionException.class)
    @ResponseBody
    public ResultDto jsonErrorHandler(HttpServletRequest req, SessionException e) throws Exception {
        logger.error(e.getMessage());
        return new ResultDto(App.SessionExceptionCode.IS_NOT_LOGON_CODE, App.SessionExceptionCode.IS_NOT_LOGON_MSG);
    }

    /**
     * 监测系统异常
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultDto runErrorHangde(HttpServletRequest request, Exception e){
        e.printStackTrace();
        logger.error(e.getMessage());
        return new ResultDto(App.ResponseCode.API_RESULT_CODE_FOR_FAIL ,e.getMessage());
    }
}
