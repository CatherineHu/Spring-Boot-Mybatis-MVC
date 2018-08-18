package com.kai.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kai.demo.service.UserService;

@Controller
public class TemplatesController {
	
	@Autowired
	private UserService userService;	

	@RequestMapping("/index")
	String test(ModelMap map) {
		map.addAttribute("key", "thymeleaf");
		return "index";
	}  
	
	@RequestMapping("/test")
	public String testThymeleaf(ModelMap map) {
		map.addAttribute("user", userService.selectByPrimaryKey(1));
		return "test";
    }
}
