package com.jxau.bank.dao;

import com.jxau.bank.model.UserBean;

import java.io.IOException;
import java.util.List;

public interface BankDaoInterface {

    /**
     * ע�Ṧ��
     * @param registerName
     * @param password
     * @throws IOException
     */
    public abstract void register(String registerName, String password) throws IOException;

    /**
     * ��¼����
     * @param loginName
     * @param loginPassword
     * @return
     * @throws IOException
     */
    public abstract UserBean login(String loginName, String loginPassword) throws IOException;


    /**
     * ���û�������properties��
     * @param money
     * @param id
     * @throws IOException
     */
    public abstract void addBank(double money, int id) throws IOException;

    /**
     * ת�˹���
     * @param getMoneyUser
     * @param currentMoney
     */
    public abstract void transfer(String getMoneyUser, double currentMoney) throws IOException;

    /**
     * ͨ���û��������û�
     * @param username
     * @return
     */
    public abstract UserBean findUserByName(String username);

    List<UserBean> findAll();

    void blockedUserById(int id,int isBlocked);
}
