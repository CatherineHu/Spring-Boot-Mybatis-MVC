package com.kai.demo.service;


import com.kai.demo.model.User;

public interface UserService {

	public String show();
	User selectByPrimaryKey(Integer id);
}
