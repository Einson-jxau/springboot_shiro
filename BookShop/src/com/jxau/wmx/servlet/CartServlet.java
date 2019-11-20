package com.jxau.wmx.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jxau.wmx.dao.IProductDao;
import com.jxau.wmx.entity.Cart;
import com.jxau.wmx.entity.CartItem;
import com.jxau.wmx.entity.Product;
import com.jxau.wmx.factory.FactoryBean;

public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IProductDao productDao;

	public CartServlet() {
		super();
		try {
			productDao = FactoryBean.getInstance("productimpl", IProductDao.class);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		if (url.contains("addCart.do")) {
			addCart(request, response);
		} else if (url.contains("removeCart.do")) {
			removeCart(request, response);
		} else if (url.contains("clearCart.do")) {
			clearCart(request, response);
		}

	}

	public Cart getCart(HttpSession session) {
		// 1��ȷ���Ƿ��й��ﳵ
	Cart cart = (Cart) session.getAttribute("cart");
	if (cart == null) {
	cart = new Cart();
	session.setAttribute("cart", cart);
	}
	return cart;
	}
	protected void addCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		// 2�������ﳵ�м�����Ʒ
		Cart cart = getCart(session);
		String[] ids = request.getParameterValues("bookId");
		for (int i = 0; i < ids.length; i++) {
			// ��ȡÿ����Ʒ��id
			int pid = Integer.parseInt(ids[i]);
			Product product = productDao.findById(pid);
			CartItem cartItem = new CartItem();
			cartItem.setProduct(product);
			cartItem.setCount(1);
			cart.addCart(cartItem);
		}
		// ��¼�͹��ﳵ����ʹ���ض���
		response.sendRedirect("shopping.jsp");

	}

	protected void removeCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Cart cart = getCart(session);
		//��Ҫ�޸�shopping.jspҳ���ɾ�������ӣ�����һ��pid����
		int pid = Integer.parseInt(request.getParameter("pid"));
		// ���ù��ﳵɾ��������
		cart.removeCart(pid);
		//���ع��ﳵҳ��
		request.getRequestDispatcher("shopping.jsp").forward(request, response);
	}

	protected void clearCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		//��ȡ���ﳵ
		Cart cart = getCart(session);
		// ������ﳵ
		cart.clearCart();
		//���ع��ﳵҳ��
		request.getRequestDispatcher("shopping.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
