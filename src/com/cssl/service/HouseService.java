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
@Transactional(readOnly = false, transactionManager = "txManager")//声明注释提交事务
public class HouseService {
	
	@Autowired
	private HouseDao hdao;//持有房屋信息的引用
	
	public List<House> selectHouse(int index,int size){//查询所有房屋信息
		return hdao.selectHouse(index, size);
	}
	
	public List<District> selectDistrict(){//查询所有区域
		return hdao.selectDistrict();
	}
	
	public List<Street> slectStreet(){//查询街道
		return hdao.slectStreet();
	}
	
	public List<Type> selectType(){//查询所有房屋类型
		return hdao.selectType();
	}
	
	public int countHouse() {//查询总记录数
		return hdao.countHouse();
	}
	
	public List<Street> selectQuJie(int id){//根据区域查询对应的街道
		return hdao.selectQuJie(id);
	}
	
	public List<House> selectTJHouse(House h){//带条件查询房屋详细信息
		return hdao.selectTJHouse(h);
	}
	
	public int deleteHouse(int id) {//删除指定房屋
		return hdao.deleteHouse(id);
	}
	
	public List<House> selectZDHouse(int id){//加载指定的房屋详细信息
		return hdao.selectZDHouse(id);
	}
	
	public int updateHouse(House h) {//修改指定房屋详细信息
		return hdao.updateHouse(h);
	}
	
	public int insertFaBu(House h) {//新增房屋详细信息
		return hdao.insertFaBu(h);
	}
}
