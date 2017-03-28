package com.zhxp.common.config;

import com.zhxp.web.Interceptor.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhu on 2017/3/24.
 */
@Configuration
@MapperScan(basePackages={"com.zhxp.web.mapper"})
public class MybaitsConfiguration {
    @Autowired
    private DataSource dataSource;
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean sqlSessionFactory() {
        SqlSessionFactoryBean session = new SqlSessionFactoryBean();
        try {
            session.setDataSource(dataSource);

            Interceptor[] arr = new PageInterceptor[1];
            arr[0] = new PageInterceptor();
            session.setPlugins(arr);
            PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            //session.setTypeAliasesPackage("com.zhxp.web.sqlMap");
            session.setMapperLocations(resolver.getResources("classpath:sqlMap/*.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return session;
    }
}
