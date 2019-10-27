package com.jxau.xw.web.sevlet;

import com.jxau.xw.domain.User;
import com.jxau.xw.service.UserService;
import com.jxau.xw.service.impl.UserServiceImpl;
import com.jxau.xw.utils.MyBeanUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/updatePersonalServlet")
public class UpdatePersonalServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //设置编码
        request.setCharacterEncoding("utf-8");
        //获取数据
        Map<String, String[]> map = request.getParameterMap();
        //封装对象
        User user = new User();
        MyBeanUtils.populate(user,map);
        //调用service修改
        UserService service = new UserServiceImpl();
         service.updateUser(user);
        //跳转回用户信息页面
        response.sendRedirect(request.getContextPath()+"/login.jsp");



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }
}
