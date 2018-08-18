package com.kai.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kai.demo.dao.UserMapper;
import com.kai.demo.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
	
	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void testQuery() throws Exception {		
		User user = userMapper.selectByPrimaryKey(1);
		System.out.println(user.toString());
	}

}
