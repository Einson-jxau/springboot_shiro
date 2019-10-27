package com.jxau.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //ǿ��ת��
        HttpServletRequest request = (HttpServletRequest) req;

        //��ȡ��Դ����·��
        String uri = request.getRequestURI();

        //�ж��Ƿ������¼�����Դ·��,Ҫע���ų��� css/js/ͼƬ/��֤�����Դ
        if(uri.contains("/login.jsp") || uri.contains("/adminServlet/login")|| uri.contains("/studentServlet/login") || uri.contains("/register.jsp")|| uri.contains("/images/")|| uri.contains("/css/")|| uri.contains("/js/")|| uri.contains("/fonts/")|| uri.contains("/checkCodeServlet")){
            //����,֤���û��������¼
            //����
            chain.doFilter(req,resp);
        }else {
            //������,�������¼
            //��֤�û��Ƿ��¼
            //��session�л�ȡuser����
            Object student = request.getSession().getAttribute("student");
            Object admin = request.getSession().getAttribute("admin");
            if(student != null || admin != null){
                //֤���û���¼��,����
                chain.doFilter(req,resp);
            }else {
                //û�е�¼,��ת��¼ҳ��
                request.setAttribute("login_error","����δ��¼,���¼!");
                request.getRequestDispatcher("/login.jsp").forward(request,resp);
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
