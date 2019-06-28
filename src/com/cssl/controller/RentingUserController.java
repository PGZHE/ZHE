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
	private UserService usersic;//�����û�ҵ���߼��������
	
	
	@RequestMapping("denglu")
	public String denglu(UserVo uvo) {//�ж��û���½����
		//vo->pojo
		User user = new User();
		BeanUtils.copyProperties(uvo, user);
		//System.out.println(uvo.getUname()+":"+uvo.getUpwd());
		if(usersic.selectServicePd(user)>0) {
			//System.out.println("�û���:"+user.getUname());
			int i = usersic.selectServiceGl(user.getUname());
			if(i==0) {//����Ա
				return "forward:jiazai";
			}else {//��ͨ�û�
				return "forward:guanli";
			}
		}else {//��½ʧ��
			return "login";
		}
	}
	
	@RequestMapping("zhuce")
	public String zhuce(UserVo uvo) {
		//vo->pojo
		User user = new User();
		BeanUtils.copyProperties(uvo, user);
		System.out.println("�û���:"+uvo.getUname());
		if(usersic.insertUser(user)>0) {//ע��ɹ�
			return "login";
		}else {//ע��ʧ��
			return "regs";
		}
		
	}
}
