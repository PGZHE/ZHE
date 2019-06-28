package com.cssl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cssl.pojo.District;
import com.cssl.pojo.House;
import com.cssl.pojo.Street;
import com.cssl.pojo.Type;

//房屋详细信息接口
public interface HouseDao {
	//新增房屋详细信息
	public int insertFaBu(House h);
	
	//查询房屋类型
	public List<Type> selectType();
	
	//查询区域
	public List<District> selectDistrict();
	
	//查询街道
	public List<Street> slectStreet();
	
	//根据区域查询街道
	public List<Street> selectQuJie(@Param("id")int id);
	
	
	//加载房屋信息
	public List<House> selectHouse(@Param("index") int index,@Param("size")int size);
	
	//查询房屋总记录
	public int countHouse();
	
	//加载指定的房屋详细信息
	public List<House> selectZDHouse(int id);
	
	//修改指定房屋详细信息
	public int updateHouse(House h);
	
	//删除指定房屋
	public int deleteHouse(int id);
	
	//带条件查询房屋详细信息
	public List<House> selectTJHouse(House h);
}
