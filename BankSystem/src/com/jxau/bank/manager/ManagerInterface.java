package com.jxau.bank.manager;

import com.jxau.bank.model.OperateBean;
import com.jxau.bank.model.UserBean;
import com.jxau.bank.util.AccountOverDrawnException;
import com.jxau.bank.util.AccountOverTransferException;
import com.jxau.bank.util.InvalidDepositException;
import com.jxau.bank.util.InvalidWithdrawalsException;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

public interface ManagerInterface {
    /**
     * ע�Ṧ��
     * @param registerName
     * @param password
     * @return
     */
    public abstract boolean register(String registerName, String password) throws IOException;

    /**
     * ��¼����
     * @param loginName
     * @param loginPassword
     * @return
     */
    public abstract boolean login(String loginName, String loginPassword) throws IOException;

    /**
     * ��ѯ����
     * @return
     */
    public abstract double inquiry() throws IOException;

    /**
     * ����
     * @param addMoney
     */
    public abstract void deposit(double addMoney) throws InvalidDepositException;

    /**
     * ȡ���
     * @param getMoney
     */
    public abstract void withdrawals(double getMoney) throws AccountOverDrawnException, InvalidWithdrawalsException, IOException;

    /**
     * �˳�����
     */
    public abstract void exitSystem() throws IOException;

    /**
     * ת�˹���
     * @param getMoneyUser
     * @param transferMoney
     * @return
     */
    public abstract boolean transfer(String getMoneyUser, double transferMoney) throws IOException, AccountOverTransferException;



    public abstract Vector<OperateBean> findRecordByUsername(String username);

    public abstract UserBean findUserByName(String username);


    public abstract List<UserBean> findAll();

    void blockedUserById(int id,int isBlocked);
}


