package com.kai.demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DataSourceTests {
	@Autowired
    ApplicationContext applicationContext;
 
    @Autowired
    DataSourceProperties dataSourceProperties;
 
    @Test
    public void testDataSource() throws Exception {
        // 获取配置的数据源
        DataSource dataSource = applicationContext.getBean(DataSource.class);
        // 查看配置数据源信息
        System.out.println("dataSource: "+ dataSource);
        System.out.println("dataSource class: "+dataSource.getClass().getName());
        System.out.println("dataSourceProperties: "+dataSourceProperties);
        
        Connection connection = dataSource.getConnection();
        ResultSet rs = connection.createStatement()
                .executeQuery("SELECT  * from users");
        if (rs.first()) {

            System.out.println("Connection OK!");
        } else {
            System.out.println("Something is wrong");
        }
        // connection.close();
        // System.exit(0);
        
 /*     //执行SQL,输出查到的数据
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<?> resultList = jdbcTemplate.queryForList("select * from users");
        System.out.println("===>>>>>>>>>>>");*/
    }


}
