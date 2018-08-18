package com.kai.demo;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

//使用Spring Boot的默认DataSource配置，此处仅配置myBatis的Resource路径
//@Configuration
@MapperScan(basePackages = "com.kai.demo.dao")
@Primary
public class DefaultDataSource {
	
	//mybatis 的mapper配置文件地址
	@Value("${mybatis.mapper-locations}")
	private String mybatisMapper;
	
	 @Bean
    public SqlSessionFactory setSqlSessionFactory(DataSource dataSource) throws IOException {
		 
    	SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
    	bean.setDataSource(dataSource);
    	bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mybatisMapper));
        try {
        	return bean.getObject();
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    
    }

}
