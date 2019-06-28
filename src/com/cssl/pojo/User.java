package com.cssl.pojo;

public class User {
	private int uid;
	private String uname;
	private String upwd;
	private String uqrpwd;
	private int dianhua;
	private String uxingming;
	private int gl;//管理员
	public int getGl() {
		return gl;
	}
	public void setGl(int gl) {
		this.gl = gl;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public String getUqrpwd() {
		return uqrpwd;
	}
	public void setUqrpwd(String uqrpwd) {
		this.uqrpwd = uqrpwd;
	}
	public int getDianhua() {
		return dianhua;
	}
	public void setDianhua(int dianhua) {
		this.dianhua = dianhua;
	}
	public String getUxingming() {
		return uxingming;
	}
	public void setUxingming(String uxingming) {
		this.uxingming = uxingming;
	}

}
