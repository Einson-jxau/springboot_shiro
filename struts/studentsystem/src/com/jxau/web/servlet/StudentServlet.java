package com.jxau.web.servlet;

import com.jxau.entity.Announce;
import com.jxau.entity.Grade;
import com.jxau.entity.Student;
import com.jxau.service.StudentService;
import com.jxau.service.impl.StudentServiceImpl;
import com.jxau.util.BaseServlet;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author xie
 */
public class StudentServlet extends BaseServlet {

    private StudentService studentService = new StudentServiceImpl();

    /**
     * ע�Ṧ��
     * @param request
     * @param response
     * @throws IOException
     */
    public void register(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //��װ����
        Map<String, String[]> map = request.getParameterMap();
        Student student = new Student();
        try {
            BeanUtils.populate(student,map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //����Service���ע��
        studentService.register(student);
        //ע��ɹ�����תҳ��
        response.sendRedirect(request.getContextPath() + "/register_success.jsp");
    }

    /**
     * ��¼����
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //��װ����
        Map<String, String[]> map = request.getParameterMap();
        Student student = new Student();
        try {
            BeanUtils.populate(student,map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //����service��ѯ
        Student studentLogin = studentService.login(student);
        //�ж��Ƿ��¼�ɹ�
        if (studentLogin != null){
            //��¼�ɹ�,���û���Ϣ������session��
            HttpSession session = request.getSession();
            session.setAttribute("student",studentLogin);
            //��תҳ��
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }else {
            //��¼ʧ��
            request.setAttribute("login_error","�û������������");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }

    }

    /**
     * �޸�����
     * @param request
     * @param response
     * @throws IOException
     */
    public void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //��ȡ����
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        /*System.out.println(id);
        System.out.println(name);*/
        //����service�޸�
        studentService.update(id,name);
        Student student = studentService.findById(id);
        request.getSession().setAttribute("student",student);
        //��תҳ��
        response.sendRedirect(request.getContextPath() + "/student/SeestudentInfo.jsp");
    }

    /**
     * �ɼ���ѯ
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void scoreInquiry(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //��ȡ����
        String id = request.getParameter("id");
        //����service��ѯ
        List<Grade> grade = studentService.inquiryGradeById(id);
        request.setAttribute("grade",grade);
        request.getRequestDispatcher("/student/showgrade.jsp").forward(request,response);
    }

    /**
     * ��ѯ����ͨ��
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void announceInquiry(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //����service��ѯ
        List<Announce> list = studentService.inquiryAnnounce();
        request.setAttribute("announces",list);
        request.getRequestDispatcher("/student/StudentAllAnnounce.jsp").forward(request,response);
    }

    /**
     * �鿴ͨ������
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findAnnounceById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Announce announce = studentService.findAnnounceById(id);
        request.setAttribute("announce",announce);
        request.getRequestDispatcher("/student/studentShowAnnounce.jsp").forward(request,response);
    }

    /**
     * �޸�����
     * @param request
     * @param response
     * @throws IOException
     */
    public void updatePassword(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        String password = request.getParameter("newPwd");
        studentService.updatePasswordById(id,password);
        Student student = studentService.findById(id);
        request.getSession().setAttribute("student",student);
        //��תҳ��
        response.sendRedirect(request.getContextPath() + "/student/SeestudentInfo.jsp");
    }

    /**
     * @Author xie
     * @Description //�˳�
     * @Date  2019/8/21 10:13
     * @Param [request, response]
     * @return void
     **/
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        if (session == null){
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }else {
            session.invalidate();
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
    }

}
