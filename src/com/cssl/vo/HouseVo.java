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
	private int did;//����
	private int sid;//��
	private int uid;//�û�
	private String tid;//����
	private Date shijian;
	private String dianhua;
	private String xiangxi;
	private int i;//��ҳ��ʼ�Ǳ�
	private int s;//ÿҳ��ʾ������
}
