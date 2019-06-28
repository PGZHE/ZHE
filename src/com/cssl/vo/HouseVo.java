package com.cssl.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HouseVo {
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
}
