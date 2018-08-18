package com.kai.demo;



import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;


//自定义DataSource，Application中需加(exclude= {DataSourceAutoConfiguration.class})
@Configuration
//@MapperScan(basePackages = "com.kai.demo.dao",sqlSessionTemplateRef  = "testSqlSessionTemplate")
@MapperScan(basePackages = "com.kai.demo.dao")
@Primary
@PropertySource("classpath:application.properties")
public class DataSourceConfig {
	
	//mybatis 的mapper配置文件地址
	@Value("${mybatis.mapper-locations}")
	private String mybatisMapper;
	

	@Primary
    @Bean(name = "testDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.test")
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "testSqlSessionFactory")    
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("testDataSource") DataSource dataSource) throws Exception {
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
    @Primary
    @Bean(name = "testTransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("testDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Primary
    @Bean(name = "testSqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("testSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    

}
