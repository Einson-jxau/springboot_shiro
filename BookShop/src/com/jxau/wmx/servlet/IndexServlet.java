package com.jxau.wmx.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.ListModel;

import com.jxau.wmx.dao.IProductDao;
import com.jxau.wmx.entity.Product;
import com.jxau.wmx.factory.FactoryBean;
import com.jxau.wmx.util.DBUtil;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IProductDao productDao;
	/**
	 * ��Ϊservletֻ�ṹ��һ��
	 * ���ԾͿ���ȷ��productdao����ֻ����һ��
	 */
	public IndexServlet() {
		super();
		try {
			productDao=FactoryBean.getInstance("productimpl", 
					IProductDao.class);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pageIndex=1;//��ǰҳ��
		int pagesize=10;//ÿҳ��ʾ������
		String currentPage=request.getParameter("pageIndex");
		//ҳ�����ݵ�ҳ������
		if(currentPage!=null) {
			try {
				pageIndex=Integer.parseInt(currentPage);
			} catch (Exception e) {
				pageIndex=1;//Ϊ�˱����쳣
			}
			
		}
		//����ܼ�¼��
		int count=productDao.findCount();
		//���ÿҳ������
		List<Product>products=productDao.findByPage(pageIndex, pagesize);
		int totalPages=count%pagesize==0?count/pagesize:count/pagesize+1;
		//������ҳ����ÿҳ�����ݡ�ҳ��
		HttpSession session=request.getSession();
		session.setAttribute("totalpages", totalPages);
		session.setAttribute("pageIndex", pageIndex);
		session.setAttribute("products", products);
		StringBuffer sb = new StringBuffer(); // ʵ����StringBuffer
        for (int i = 1; i <= totalPages; i++) { // ͨ��ѭ��������ҳ������
            if (i == pageIndex) { // �ж��Ƿ�Ϊ��ǰҳ
                sb.append("��" + i + "��"); // ������ҳ������
            } else {
                // ������ҳ������
                sb.append("<a href='index?pageIndex=" + i + "'>" + i + "</a>");
            }
            sb.append("��"); // ������ҳ������
        }
        
        request.setAttribute("bar", sb.toString()); // ����ҳ���������ַ������õ�request��
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
