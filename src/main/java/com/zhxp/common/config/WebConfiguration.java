package com.zhxp.common.config;

import com.zhxp.web.Interceptor.SessionLoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * SpringMVC 配置
 * Created by zhh on 2017/3/3.
 */
@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(new SessionLoginInterceptor())
                .excludePathPatterns("/swagger-ui.html")
                .excludePathPatterns("/swagger-resources")
                .excludePathPatterns("/swagger-resources/**")
                .excludePathPatterns("/v2/*")
                .excludePathPatterns("/v2/**")
                .excludePathPatterns("/resources/**")
                .excludePathPatterns("/face/**")
                .excludePathPatterns("/user/login")
        ;
        super.addInterceptors(registry);
    }

}