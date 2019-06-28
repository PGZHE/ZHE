package com.cssl.dao;

import org.apache.ibatis.annotations.Param;

import com.cssl.pojo.User;

//用户信息接口
public interface UserDao {
	
	//判断用户登陆
	public int selectPd(User u);
	
	//新增一个用户
	public int insertUser(User u);
	
	//判断登陆的用户是管理员还是普通用户
	public int selectGl(@Param("name")String name);
}
