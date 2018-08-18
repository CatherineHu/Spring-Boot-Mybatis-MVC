package com.kai.demo.dao;

import com.kai.demo.model.User;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


public interface UserMapper  {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    
    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
    

    
    
}