package com.zhxp.common.aspect;






import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;



/**
 * Web层日志切面
 *
 * @author 程序猿DD
 * @version 1.0.0
 * @date 16/5/17 上午10:42.
 * @blog http://blog.didispace.com
 */
//@Aspect
//@Order(5)
//@Component
public class WebLogAspect {

    private Logger logger = Logger.getLogger(getClass());

    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("execution(public * com.zhxp.web.controller..*.*(..))")
    public void webLog(){}

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        startTime.set(System.currentTimeMillis());

        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        JSONObject json = new JSONObject();
        // 记录下请求内容
        json.put("Url", request.getRequestURL().toString());
        json.put("Param",  Arrays.toString(joinPoint.getArgs()));
        json.put("Method", request.getMethod());
        json.put("ip" , request.getRemoteAddr());
        json.put("Class_Method", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info(json.toString());
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        JSONObject json = new JSONObject();
        json.put("Response", ret);
        json.put("Spend Time", (System.currentTimeMillis() - startTime.get()));
        logger.info(json.toString());
    }


}

