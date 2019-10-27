package com.jxau.wmx.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jxau.wmx.dao.IOrderDao;
import com.jxau.wmx.dao.IProductDao;
import com.jxau.wmx.entity.Order;
import com.jxau.wmx.entity.OrderItem;
import com.jxau.wmx.entity.Product;
import com.jxau.wmx.entity.User;
import com.jxau.wmx.util.C3P0Util;

public class OrderDaoImpl implements IOrderDao {
    private Connection conn;
    //private PreparedStatement ps;
    private ResultSet rs;
    IProductDao productDao=new ProductDaoImpl();
	@Override
	public void creatOrder(Order order) {
	  conn=C3P0Util.getConn();
	  PreparedStatement ps=null;
	  String insert_sql="insert into orders values(?,?,?,?,?,?,?,?) ";
	try {
		ps = conn.prepareStatement(insert_sql);
		ps.setString(1, order.getOid());
		ps.setDouble(2, order.getMoney());
		ps.setString(3, order.getAddress());
		ps.setString(4, order.getName());
		ps.setString(5, order.getPhone());
		ps.setInt(6, order.getPaystate());
		//��������uid
		ps.setInt(7, order.getUser().getUid());
		//�����µ�ʱ��
		ps.setString(8, order.getOrdertime());
		int result=ps.executeUpdate();
		//�˴�ӡ����Ϊ�˲���
		System.out.println("���ɶ����ɹ�"+result);
	} catch (SQLException e) {
		
		e.printStackTrace();
	}finally {
		C3P0Util.close(conn, ps, rs);
	}
	 
		
	}
	//�ҵ�һ���û����ж������
	@Override
	public List<Order> findOrderByUser(User user) {
		conn=C3P0Util.getConn();
		List<Order>orders=new ArrayList<Order>();
		String select_sql="select * from orders where uid=?";
	    PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement(select_sql);
			ps.setInt(1, user.getUid());
			rs=ps.executeQuery();
			while(rs.next()) {
			 String oid=rs.getString("oid");
			 //���ݶ�������ҵ��Ķ���
			 Order order=findByOid(oid);
			 order.setOid(oid);
			 order.setMoney(rs.getDouble("money"));
			 order.setAddress(rs.getString("address"));
			 order.setName(rs.getString("name"));
			 order.setPhone(rs.getString("phone"));
			 order.setUser(user);
			 order.setPaystate(rs.getInt("paystate"));
			 Date d=rs.getTimestamp("ordertime");
			 SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			 order.setOrdertime(sd.format(d));
			 orders.add(order);
			}
			//System.out.println("dao���ȡ������"+orders);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			C3P0Util.close(conn, ps, rs);
		}
		return orders;
	}
	//���������oid,ȥ��ѯ�����µ����ж������Ʒ��
	@Override
	public Order findByOid(String oid) {
	    conn=C3P0Util.getConn();
	    String select_sql="select * from orderitem  where oid=?";
	    Order order=new Order();
	    PreparedStatement ps=null;
		ResultSet rs=null;
	    try {
			ps=conn.prepareStatement(select_sql);
			ps.setString(1, oid);
			rs=ps.executeQuery();
			while(rs.next()) {
			OrderItem orderItem=new OrderItem();
			orderItem.setOid(oid);
			int pid=rs.getInt("pid");
			//����pid�õ���Ӧ��Ʒ����
			Product product=productDao.findById(pid);
			orderItem.setProduct(product);
			orderItem.setBuynum(rs.getInt("buynum"));
			orderItem.setSubTotal(rs.getDouble("subTotal"));
			//һ�Զ�Ĺ�ϵ
			order.getOrderItems().add(orderItem);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			C3P0Util.close(conn, ps, rs);
		}
		return order;
	}

}
