package com.itheima.pullparser.domain;
/*
 * 
 *   ��װ���ݵ� �� ׼�� javabean
 * 
<product type="mobile">
	<phonenum>13512345678</phonenum>
	<location>�����ƶ������п�</location>
	<phoneJx>�е���ʧ��������ʵ������ٲƣ�ʼ��ƽ�� ������</phoneJx>
 </product>
 * 
 */
public class Product {

	private String type;
	private String phonenum;
	private String location;
	private String phoneJx;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPhoneJx() {
		return phoneJx;
	}
	public void setPhoneJx(String phoneJx) {
		this.phoneJx = phoneJx;
	}
	@Override
	public String toString() {
		return "Product [type=" + type + ", phonenum=" + phonenum
				+ ", location=" + location + ", phoneJx=" + phoneJx + "]";
	}
	
}
