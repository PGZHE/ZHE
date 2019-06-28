package com.cssl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cssl.dao.HouseDao;
import com.cssl.pojo.District;
import com.cssl.pojo.House;
import com.cssl.pojo.Street;
import com.cssl.pojo.Type;

@Service
@Transactional(readOnly = false, transactionManager = "txManager")//����ע���ύ����
public class HouseService {
	
	@Autowired
	private HouseDao hdao;//���з�����Ϣ������
	
	public List<House> selectHouse(int index,int size){//��ѯ���з�����Ϣ
		return hdao.selectHouse(index, size);
	}
	
	public List<District> selectDistrict(){//��ѯ��������
		return hdao.selectDistrict();
	}
	
	public List<Street> slectStreet(){//��ѯ�ֵ�
		return hdao.slectStreet();
	}
	
	public List<Type> selectType(){//��ѯ���з�������
		return hdao.selectType();
	}
	
	public int countHouse() {//��ѯ�ܼ�¼��
		return hdao.countHouse();
	}
	
	public List<Street> selectQuJie(int id){//���������ѯ��Ӧ�Ľֵ�
		return hdao.selectQuJie(id);
	}
	
	public List<House> selectTJHouse(House h){//��������ѯ������ϸ��Ϣ
		return hdao.selectTJHouse(h);
	}
	
	public int deleteHouse(int id) {//ɾ��ָ������
		return hdao.deleteHouse(id);
	}
	
	public List<House> selectZDHouse(int id){//����ָ���ķ�����ϸ��Ϣ
		return hdao.selectZDHouse(id);
	}
	
	public int updateHouse(House h) {//�޸�ָ��������ϸ��Ϣ
		return hdao.updateHouse(h);
	}
	
	public int insertFaBu(House h) {//����������ϸ��Ϣ
		return hdao.insertFaBu(h);
	}
}
