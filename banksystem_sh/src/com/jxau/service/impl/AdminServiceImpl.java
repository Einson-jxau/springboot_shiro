package com.jxau.service.impl;

import java.util.List;
import java.util.Map;

import com.jxau.dao.AdminDao;
import com.jxau.dao.UserDao;
import com.jxau.domain.Admin;
import com.jxau.domain.User;
import com.jxau.factory.BeanFactory;
import com.jxau.service.AdminService;
import com.jxau.util.HibernateFilter;
import com.jxau.util.HibernateUtils;
import com.jxau.util.PageBean;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

public class AdminServiceImpl implements AdminService {
    private static AdminServiceImpl instance;
    private AdminDao                adminDao = (AdminDao) BeanFactory.getBean("adminDao");
    private UserDao                 userDao  = (UserDao) BeanFactory.getBean("userDao");

    private AdminServiceImpl() {}

    @Override
    public void changLocked(String id, String isLocked) {
        Transaction transaction = null;
        try {
            Session session = HibernateFilter.getSession();
            transaction = session.getTransaction();
            transaction.begin();
            adminDao.changeLocked(Integer.parseInt(id), Integer.parseInt(isLocked));
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public PageBean findAllUser(int currentPage, int currentCount) {
        //查询总用户个数
        Long totalCount = userDao.getTotalUser();
        //总页数 = (总记录数 / 每页显示的条数) + 1
        Long totalPage = (totalCount / currentCount) + 1;
        //开始查询的索引 = （当前页 - 1） * 每页显示的条数
        int index = (currentPage - 1) * currentCount;

        List<User> users =  userDao.findUserByPage(index, currentCount);

        //封装PageBean
        PageBean<User> pageBean = new PageBean<>();
        pageBean.setTotalCount(totalCount);
        pageBean.setTotalPage(totalPage);
        pageBean.setCurrentCount(currentCount);
        pageBean.setCurrentPage(currentPage);
        pageBean.setList(users);

        return pageBean;
    }

    @Override
    public List<User> findUser(Map<String, String> condition) {
        return userDao.findUser(condition);
    }

    @Override
    public PageBean<User> findUserByCondition(DetachedCriteria dc, int currentPage, int currentCount) {

        //开始查询的索引
        int index = (currentPage - 1) * currentCount;

        //封装的分页数据
        List<User> list = userDao.findUserByCondition(dc,index,currentCount);

        Long totalCount = userDao.getUserConditionCount(dc);

        //总页数
       Long totalPage = (totalCount / currentCount) + 1;

       //封装pageBean
        PageBean<User> userPageBean = new PageBean<>();
        userPageBean.setTotalCount(totalCount);
        userPageBean.setTotalPage(totalPage);
        userPageBean.setCurrentPage(currentPage);
        userPageBean.setCurrentCount(currentCount);
        userPageBean.setList(list);
        return userPageBean;
    }

    @Override
    public Admin login(Admin admin) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtils.getCurrentSession();
            transaction = session.getTransaction();
            transaction.begin();
            Admin adminLogin = adminDao.findAdminByNameAndPassword(admin.getUsername(), admin.getPassword());
            transaction.commit();
            return adminLogin;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
            return null;
        }
    }

    public static synchronized AdminServiceImpl getInstance() {
        if (instance == null) {
            instance = new AdminServiceImpl();
        }

        return instance;
    }
}


