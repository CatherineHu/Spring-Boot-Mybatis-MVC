package com.kai.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kai.demo.service.UserService;


@RestController
public class UserController {
	
	@Autowired
	private UserService userService;	

	@RequestMapping(value = "/show")  
    public String show(){
       return userService.show();
		}
	
	@RequestMapping("/getUser")
	public String getUser() {
		return userService.selectByPrimaryKey(1).toString();
    }
	

}
