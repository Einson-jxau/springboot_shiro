package com.jxau.bank.model;

public class MoneyBean {

	private String name;
	private String password;
	private double money;

	
	//���ഴ��һ������
	private static MoneyBean instance = null;

	//���췽��˽�л�����ֹ�����ഴ������
	private MoneyBean() {
	}

	//Ϊ������ܹ�ͨ������ֱ�ӵ���
	public static MoneyBean getInstance(){
		if(instance == null) {
			instance = new MoneyBean ();
		}
		return instance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "MoneyBean{" + "name='" + name + '\'' + ", password='" + password + '\'' + ", money=" + money + '}';
	}
}
