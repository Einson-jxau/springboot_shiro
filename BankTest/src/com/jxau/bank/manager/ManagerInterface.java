package com.jxau.bank.manager;

import com.jxau.bank.model.MoneyBean;
import com.jxau.bank.util.AccountOverDrawnException;
import com.jxau.bank.util.InvalidDepositException;

import java.io.IOException;

public interface ManagerInterface {

    /**
     * ע�Ṧ��
     *
     * @param name
     * @param password
     * @throws IOException
     */
    public abstract void register(String name, String password) throws IOException;

    /**
     * ��¼����
     *
     * @param loginName
     * @return
     * @throws IOException
     */
    public abstract MoneyBean login(String loginName) throws IOException;


    /**
     * ��ѯ����
     */
    public abstract double inquiry() throws IOException;

    /**
     * ����
     *
     * @param money
     * @throws InvalidDepositException
     */
    public abstract double deposit(double money) throws InvalidDepositException, IOException;

    /**
     * ȡ���
     *
     * @param money
     * @throws AccountOverDrawnException
     */
    public abstract double withdrawals(double money) throws AccountOverDrawnException, IOException;

    /**
     * ת�˹���
     * @param name
     * @param money
     * @return
     */
    public abstract void transfer(String name, double money) throws IOException;

    /**
     * �˳�����
     */
    public abstract void exitSystem();
}
