package com.cssl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cssl.dao.UserDao;
import com.cssl.pojo.User;

@Service
@Transactional(readOnly = false, transactionManager = "txManager")//声明注释提交事务
public class UserService{
	
	@Autowired
	private UserDao udao;//持有用户接口的引用
	
	public int selectServicePd(User u) {//判断是否存在这个用户
		return udao.selectPd(u);
	}
	
	public int selectServiceGl(String name) {//判断是管理员还是普通用户
		return udao.selectGl(name);
	}
	
	public int insertUser(User u) {//用户注册(新增用户)
		return udao.insertUser(u);
	}
	
}
