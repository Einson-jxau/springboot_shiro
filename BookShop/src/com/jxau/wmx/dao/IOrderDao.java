package com.jxau.wmx.dao;

import java.util.List;

import com.jxau.wmx.entity.Order;
import com.jxau.wmx.entity.User;

public interface IOrderDao {

	//���ɶ�������
	void creatOrder(Order order);
	//����ĳ���û������ж���
	List<Order>findOrderByUser(User user);
	//���ݶ�����Ų��Ҷ�Ӧ�Ķ���
	Order findByOid(String oid);
	
}
