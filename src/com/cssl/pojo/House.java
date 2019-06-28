package com.cssl.pojo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class House { 
	private int hid;
	private String hname;
	private String hmianji;
	private String hqian;
	private int did;//区域
	private int sid;//街
	private int uid;//用户
	private String tid;//类型
	private Date shijian;
	private String dianhua;
	private String xiangxi;
	private int i;//分页起始角标
	private int s;//每页显示的数量
	
	
	@Override
	public String toString() {
		return "House [hid=" + hid + ", hname=" + hname + ", hmianji=" + hmianji + ", hqian=" + hqian + ", did=" + did
				+ ", sid=" + sid + ", uid=" + uid + ", tid=" + tid + ", shijian=" + shijian + ", dianhua=" + dianhua
				+ ", xiangxi=" + xiangxi + "]";
	}
	
}
