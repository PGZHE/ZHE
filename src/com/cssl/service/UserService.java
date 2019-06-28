package com.cssl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cssl.dao.UserDao;
import com.cssl.pojo.User;

@Service
@Transactional(readOnly = false, transactionManager = "txManager")//����ע���ύ����
public class UserService{
	
	@Autowired
	private UserDao udao;//�����û��ӿڵ�����
	
	public int selectServicePd(User u) {//�ж��Ƿ��������û�
		return udao.selectPd(u);
	}
	
	public int selectServiceGl(String name) {//�ж��ǹ���Ա������ͨ�û�
		return udao.selectGl(name);
	}
	
	public int insertUser(User u) {//�û�ע��(�����û�)
		return udao.insertUser(u);
	}
	
}
