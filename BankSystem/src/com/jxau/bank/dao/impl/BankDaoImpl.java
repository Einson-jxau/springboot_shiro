package com.jxau.bank.dao.impl;

import com.jxau.bank.dao.BankDaoInterface;
import com.jxau.bank.model.UserBean;
import com.jxau.bank.util.JDBCUtils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BankDaoImpl implements BankDaoInterface {

   /* //���췽��˽�л�
    private BankDaoImpl(){}
    private static BankDaoImpl instance = null;

    public static BankDaoImpl getInstance(){
        if(instance == null){
            instance = new BankDaoImpl();
        }
        return instance;
    }*/

    private Connection conn = null;

    /**
     * ע�Ṧ��
     * @param registerName
     * @param password
     */
    @Override
    public void register(String registerName, String password) throws IOException {
        conn = JDBCUtils.getConnection();
        String sql = "insert into user values(null,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,registerName);
            ps.setString(2,password);
            ps.setDouble(3,0);
            ps.setInt(4,0);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null,ps,conn);
        }
    }

    /**
     * ��¼����
     * @param loginName
     * @param loginPassword
     * @return
     * @throws IOException
     */
    @Override
    public UserBean login(String loginName, String loginPassword) {
        conn = JDBCUtils.getConnection();
        String sql = "select * from user where username = ? and password  = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        UserBean user = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,loginName);
            ps.setString(2,loginPassword);
            rs = ps.executeQuery();
            while (rs.next()){
                user = new UserBean();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setMoney(rs.getDouble("money"));
                user.setIsBlocked(rs.getInt("isBlocked"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs,ps,conn);
        }

        return user;
    }


    /**
     * ���û�������properties�ļ���
     * @param money
     * @param id
     * @throws IOException
     */
    @Override
    public void addBank(double money, int id) throws IOException {
        conn = JDBCUtils.getConnection();
        String sql = "update user set money = ? where id = ?";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setDouble(1,money);
            ps.setInt(2,id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null,ps,conn);
        }

    }

    /**
     * ת�˹���
     * @param getMoneyUser
     * @param currentMoney
     * @throws IOException
     */
    @Override
    public void transfer(String getMoneyUser, double currentMoney){
        //��ת���û��������

        conn = JDBCUtils.getConnection();
        String sql = "update user set money = ? where username = ?";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setDouble(1,currentMoney);
            ps.setString(2,getMoneyUser);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null,ps,conn);
        }
    }


    /**
     * �����û��������û�
     * @param username
     * @return
     */
    @Override
    public UserBean findUserByName(String username) {
        conn = JDBCUtils.getConnection();
        String sql = "select * from user where username = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        UserBean user = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            rs = ps.executeQuery();
            user = new UserBean();
            while (rs.next()){
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setMoney(rs.getDouble("money"));
                user.setIsBlocked(rs.getInt("isBlocked"));
            }
            System.out.println(user);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs,ps,conn);
        }
        return user;
    }

    /**
     * ���������û�
     * @return
     */
    @Override
    public List<UserBean> findAll() {
        conn = JDBCUtils.getConnection();
        String sql = "select * from user";
        PreparedStatement ps = null;
        ResultSet rs = null;
        UserBean user = null;
        List<UserBean> list = new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                user = new UserBean();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setMoney(rs.getDouble("money"));
                user.setIsBlocked(rs.getInt("isBlocked"));
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs,ps,conn);
        }
        return list;
    }

    /**
     * ����id�����ⶳ�û�
     * @param id
     * @param isBlocked
     */
    @Override
    public void blockedUserById(int id,int isBlocked) {
        conn = JDBCUtils.getConnection();
        String sql = "update user set isBlocked = ? where id = ?";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,isBlocked);
            ps.setInt(2,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null,ps,conn);
        }
    }


}
