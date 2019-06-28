package com.cssl.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cssl.pojo.User;
import com.cssl.service.UserService;
import com.cssl.vo.UserVo;

@Controller
public class RentingUserController {
	
	@Autowired
	private UserService usersic;//持有用户业务逻辑层的引用
	
	
	@RequestMapping("denglu")
	public String denglu(UserVo uvo) {//判断用户登陆方法
		//vo->pojo
		User user = new User();
		BeanUtils.copyProperties(uvo, user);
		//System.out.println(uvo.getUname()+":"+uvo.getUpwd());
		if(usersic.selectServicePd(user)>0) {
			//System.out.println("用户名:"+user.getUname());
			int i = usersic.selectServiceGl(user.getUname());
			if(i==0) {//管理员
				return "forward:jiazai";
			}else {//普通用户
				return "forward:guanli";
			}
		}else {//登陆失败
			return "login";
		}
	}
	
	@RequestMapping("zhuce")
	public String zhuce(UserVo uvo) {
		//vo->pojo
		User user = new User();
		BeanUtils.copyProperties(uvo, user);
		System.out.println("用户名:"+uvo.getUname());
		if(usersic.insertUser(user)>0) {//注册成功
			return "login";
		}else {//注册失败
			return "regs";
		}
		
	}
}
