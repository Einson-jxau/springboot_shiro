package com.jxau.wmx.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jxau.wmx.dao.IUserDao;
import com.jxau.wmx.entity.User;
import com.jxau.wmx.factory.FactoryBean;
import com.jxau.wmx.util.DBUtil;


public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IUserDao userDao;   
   
    public UserServlet() {
        super();
        try {
			userDao=FactoryBean.getInstance("userdaoimpl", IUserDao.class);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd=request.getParameter("cmd");
		String url=request.getRequestURL().toString();
		if(url.contains("logout.action")) {
			logOut(request,response);
		}else {
		switch (cmd) {
		case "register":
			register(request, response);
			break;
		case "login":
			login(request, response);
			break;
		default:
			break;
		}
		}
	}

    protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1����ȡע��ҳ����ύ����Ϣ
    	String username=request.getParameter("userName");
    	String pwd=request.getParameter("passWord");
    	String email=request.getParameter("email");
    	User user=new User();
    	user.setUsername(username);
    	user.setPwd(pwd);
    	user.setEmail(email);
    	if(userDao.register(user)>0) {
    		request.getRequestDispatcher("register_success.jsp").forward(request, response);
    	}else {
    		request.getRequestDispatcher("register.jsp").forward(request, response);;
    	}
    	
    	
	}

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String username=request.getParameter("userName");
		String pwd=request.getParameter("passWord");
		 /*
        �õ�ҳ�洫�������ֶ��������֤��, ����֤��Ҫ������ͼƬ�ϵ�
        �ı���֤��Ƚ�, �����ͬ, ��֤������ɹ�!
     */
    String imageText = request.getParameter("validationCode");
    // ͼƬ����֤��
    String text = (String) request.getSession().getAttribute("validation_code");
    if (!text.equalsIgnoreCase(imageText)) {
        request.setAttribute("imageMess", "��֤���������!");
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }else {
		User user=userDao.login(username, pwd);
		if(user!=null) {
			request.getSession().setAttribute("user", user);
			response.sendRedirect("index?pageIndex=1");
		}else{
			response.sendRedirect("login.jsp");
		}
   	}
    }
		
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
protected void logOut(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		
		if(request.getSession() == null) {
			response.sendRedirect("login.jsp");
			return;
			}
		request.getSession().removeAttribute("user");
		request.getSession().invalidate();
		response.sendRedirect("login.jsp");
}}
