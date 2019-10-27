package com.jxau.wmx.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jxau.wmx.dao.IProductDao;
import com.jxau.wmx.dao.IUserDao;
import com.jxau.wmx.dao.impl.ProductDaoImpl;
import com.jxau.wmx.entity.Product;
import com.jxau.wmx.factory.FactoryBean;
import com.jxau.wmx.util.C3P0Util;

/**
 * Servlet implementation class MenuSearchServlet
 */
/*
 * ������������
 */
@WebServlet(urlPatterns= {"/simpleSearch.do","/supperSearch.do"})
public class MenuSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IProductDao productDao;
		
    public MenuSearchServlet() {
        super();
        try {
			productDao = FactoryBean.getInstance("productimpl", IProductDao.class);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//���������������
		response.setContentType("text/html;charset=utf-8");//������Ӧ����	
		String url=request.getRequestURL().toString();
		//����Ѱ
		if(url.contains("simpleSearch.do")) {
			getProductBySearchName(request, response);
		}
		//������Ѱ
		else if(url.contains("supperSearch.do")) {
			supperSearch(request, response);
		}
		
				
	}
	
	protected void getProductBySearchName(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pageIndex=1;//��ǰҳ��
		int pagesize=100;//ÿҳ��ʾ������
		String currentPage=request.getParameter("pageIndex");
		String bookname=request.getParameter("keywords");
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
		List<Product>products=productDao.getProductBySearchName(pageIndex,pagesize,bookname);
		int totalPages=count%pagesize==0?(count/pagesize):(count/pagesize+1);
		//������ҳ����ÿҳ�����ݡ�ҳ��
		HttpSession session=request.getSession();
		session.setAttribute("totalpages", totalPages);
		session.setAttribute("pageIndex", pageIndex);
		session.setAttribute("products", products);
		if(products!=null&&!products.isEmpty()) {
			StringBuffer sb = new StringBuffer(); // ʵ����StringBuffer
	        for (int i = 1; i <= totalPages; i++) { // ͨ��ѭ��������ҳ������
	            if (i == pageIndex) { // �ж��Ƿ�Ϊ��ǰҳ
	                sb.append("[" + i + "]"); // ������ҳ������
	            } else {
	                // ������ҳ������
	                sb.append("<a href='index?pageIndex=" + i + "'>" + i + "</a>");
	            }
	            sb.append(" "); // ������ҳ������
	        }
	        
	        request.setAttribute("bar", sb.toString()); // ����ҳ���������ַ������õ�request��
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("searchFail.jsp").forward(request, response);
		}
	}
	
	
	private void supperSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		List<Product> products0=new ArrayList<Product>();
		//ͨ�����ӳ��������ݿ�
		Connection conn=C3P0Util.getConn();
		//ȡ���������д����Ĳ���
		String bookname=request.getParameter("bookName");
		//Ҫ��double�͵ļ۸����ת��
		double price1=Double.parseDouble(request.getParameter("price1"));
		double price2=Double.parseDouble(request.getParameter("price2"));
		String categoryId=request.getParameter("category");//ȡ����������б��ֵ
		
		/*
		//������д����Ĳ���
		System.out.println("����:"+bookname);
		System.out.println("price1:"+price1);
		System.out.println("price2:"+price2);
		System.out.println("����:"+categoryId);
		*/
		
		/*		
		//���Ե�����ѯ����
		products0=productDao.findByBookCategory(categoryId);
		if(products0.size()>0) {
			System.out.println("��Ʒ���ҵ�!");
			this.print(products0);
			request.setAttribute("products0",products0);
			request.getRequestDispatcher("productCategory.jsp").forward(request, response);
		}else {
			System.out.println("���ź�,û���ҵ�");
			request.getRequestDispatcher("productCategory.jsp").forward(request, response);
		}
		*/
					
		//����Dao�㷽���ҵ���Ӧ����Ʒ
		products0=productDao.findByBookName(bookname);//���������ҵ���Ʒ����װ
		if(products0.size()==0) { //ͨ��size()�����ж��Ƿ��ҵ���Ʒ
			//���ݼ۸��ҵ���Ʒ����װ
			 products0=productDao.findByBookPrice(price1,price2);	
			 System.out.println(products0.size());
		} if(products0.size()==0){ 
			//��������ҵ���Ʒ����װ
			products0=productDao.findByBookCategory(categoryId);	
		} if(products0.size()==0){ //����������Ҳ���
			System.out.println("���ź�,û���ҵ�");
			request.getRequestDispatcher("productCategory.jsp").forward(request, response);			
		}else{	
			//���������õ�request���ö�����,��ת����jspҳ��
			request.setAttribute("products0",products0);
			request.getRequestDispatcher("productCategory.jsp").forward(request, response);					
	}	
}
	
	//���List<Product>�����е�ֵ
	public void print(List<Product> products) {
		System.out.print("List:");
		for(int i=0;i<products.size();i++) {
		System.out.println("��"+(i+1)+"��Ԫ��:"+products.get(i));
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {			

		doGet(request, response);
	}
}
