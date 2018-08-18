package com.kai.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.kai.demo.controller.UserController;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTests {

	@Autowired
	private WebApplicationContext context;

	private MockMvc mvc;

	@Before
	public void setUp() throws Exception {
		//mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
		mvc=MockMvcBuilders.webAppContextSetup(context).build();
	}
	
   // @Test
    public void show() throws Exception{
    	mvc.perform(MockMvcRequestBuilders.get("/show").accept(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andDo(MockMvcResultHandlers.print())
        .andReturn();
    }
	
	public void selectUser() throws Exception {
		// 编写简单的http请求来测试；使用mockmvc进行，利用MockMvcResultHandlers.print()打印出执行结果
		mvc.perform(MockMvcRequestBuilders.get("/selectUser"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andDo(MockMvcResultHandlers.print())
        .andReturn();
	}
	
	 @Test
	    public void getUser() throws Exception {
		 mvc.perform(MockMvcRequestBuilders.get("/getUser")
	                .accept(MediaType.APPLICATION_JSON_UTF8)).andDo(MockMvcResultHandlers.print());
	    }
	

	
}
