package com.jxau.dao.impl;

import java.util.List;

import com.jxau.dao.CustomerDao;
import com.jxau.domain.Customer;
import com.jxau.utils.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;


public class CustomerDaoImpl implements CustomerDao {

	public void save(Customer c) {
		//1 获得session
		Session session = HibernateUtils.getCurrentSession();
		//3 执行保存
		session.save(c);
	}

	public List<Customer> getAll() {
		//1 获得session
				Session session = HibernateUtils.getCurrentSession();
		//2 创建Criteria对象
				Criteria c = session.createCriteria(Customer.class);
		return c.list();
	}

	public Customer getById(Long cust_id) {
		//1 获得session
		Session session = HibernateUtils.getCurrentSession();
		return session.get(Customer.class, cust_id);
	}

	public List<Customer> getAll(DetachedCriteria dc) {
		//1 获得session
				Session session = HibernateUtils.getCurrentSession();
		//2 将离线对象关联到session
				Criteria c = dc.getExecutableCriteria(session);
		//3 执行查询并返回
		return c.list();
	}

}
