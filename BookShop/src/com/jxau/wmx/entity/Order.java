package com.jxau.wmx.entity;
/**
 * ����������Ӧ��ʵ����
 * @author Administrator
 *
 */

import java.util.ArrayList;
import java.util.List;

public class Order {
	private String oid;//uuid 32λ��ͬ�ַ���
	private double money;
	private String address;
	private String name;
	private String phone;
	private String ordertime;// �µ�ʱ��
	private int paystate;
	private User user;// ҳ����Ҫʹ���û���������Ϣ�����Ա����û�����
	// Ϊ�����ֶ�����Ͷ������һ�Զ�Ĺ�ϵ��
	private List<OrderItem>orderItems =new ArrayList<OrderItem>();

	
	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}

	public int getPaystate() {
		return paystate;
	}

	public void setPaystate(int paystate) {
		this.paystate = paystate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	@Override
	public String toString() {
		
		return "["+oid+money+"]";
	}
	

}
