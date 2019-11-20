package com.jxau.bank.manager.impl;

import com.jxau.bank.dao.BankDaoInterface;
import com.jxau.bank.dao.OperateDaoInterface;
import com.jxau.bank.dao.impl.OperateDaoImpl;
import com.jxau.bank.factory.UserDaoFactory;
import com.jxau.bank.manager.ManagerInterface;
import com.jxau.bank.model.MoneyBean;
import com.jxau.bank.model.OperateBean;
import com.jxau.bank.model.UserBean;
import com.jxau.bank.util.AccountOverDrawnException;
import com.jxau.bank.util.AccountOverTransferException;
import com.jxau.bank.util.InvalidDepositException;
import com.jxau.bank.util.InvalidWithdrawalsException;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

public class ManagerImpl implements ManagerInterface {
    //˽�л����췽�������������ഴ������
    private ManagerImpl(){}

    private static ManagerImpl instance = null;

    public synchronized static ManagerImpl getInstance(){
        if(instance == null){
            instance = new ManagerImpl();
        }
        return instance;
    }

    //����MoneyBean����
    MoneyBean userMoney = new MoneyBean();
    UserBean user = new UserBean();
    OperateBean operateBean = new OperateBean();
    //��ȡBankDaoImpl����
    //BankDaoImpl bankDao = BankDaoImpl.getInstance();
    private OperateDaoInterface operateDao = new OperateDaoImpl();


    private BankDaoInterface bankDao;

    {
        try {
            bankDao = UserDaoFactory.getInstance().createBankDao();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*private UserDaoFactory daoFactory;

    {
        try {
            daoFactory = UserDaoFactory.getInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    BankDaoInterface bankDao = daoFactory.createBankDao();*/


    /**
     * ע�Ṧ��
     * @param registerName
     * @param password
     * @throws IOException
     * @return
     */
    @Override
    public boolean register(String registerName, String password) throws IOException {

        if (bankDao.findUserByName(registerName).getUserName() != null)
            return false;
        else {
            bankDao.register(registerName, password);
            return true;
        }
    }

    /**
     * ��¼����
     * @param loginName
     * @param loginPassword
     * @return
     */
    @Override
    public boolean login(String loginName, String loginPassword) throws IOException {

        user = bankDao.login(loginName, loginPassword);
        //System.out.println(user);
        //��¼�ɹ�
        if (user != null) {
            double currentMoney = user.getMoney();
            userMoney.setMoney(currentMoney);
            return true;
        } else {
            //��¼ʧ��
            return false;
        }
    }

    /**
     * ��ѯ����
     * @return
     * @throws IOException
     */
    @Override
    public double inquiry() throws IOException {
        return userMoney.getMoney();
    }

    /**
     * ����
     * @param addMoney
     * @throws InvalidDepositException
     */
    @Override
    public void deposit(double addMoney) throws InvalidDepositException {
        if (addMoney < 0) {
            throw new InvalidDepositException("����Ϊ������");
        } else {
            operateBean.setId(user.getId());
            operateBean.setOusername(user.getUserName());
            operateBean.setOBmoney(userMoney.getMoney());
            operateBean.setOmoney(addMoney);
            userMoney.setMoney(userMoney.getMoney() + addMoney);
            operateBean.setAmoney(userMoney.getMoney());
            operateBean.setOtype("���");
            operateDao.insertRecord(operateBean);
        }
    }

    /**
     * ȡ���
     * @param getMoney
     * @throws AccountOverDrawnException
     */
    @Override
    public void withdrawals(double getMoney) throws AccountOverDrawnException, InvalidWithdrawalsException, IOException {
        System.out.println(userMoney.getMoney());
        if (getMoney < 0) {
            throw new InvalidWithdrawalsException("ȡ���Ϊ������");
        } else if (getMoney > userMoney.getMoney()) {
            throw new AccountOverDrawnException("��������!");
        } else {
            operateBean.setId(user.getId());
            operateBean.setOusername(user.getUserName());
            operateBean.setOBmoney(userMoney.getMoney());
            operateBean.setOmoney(getMoney);
            userMoney.setMoney(userMoney.getMoney() - getMoney);
            operateBean.setAmoney(userMoney.getMoney());
            operateBean.setOtype("ȡ��");
            operateDao.insertRecord(operateBean);
        }
    }

    /**
     * �˳�����
     */
    @Override
    public void exitSystem() throws IOException {
        bankDao.addBank(userMoney.getMoney(),user.getId());

    }

    /**
     * ת�˹���
     * @param getMoneyUser
     * @param transferMoney
     * @throws IOException
     * @return
     */
    @Override
    public boolean transfer(String getMoneyUser, double transferMoney) throws IOException, AccountOverTransferException {

        if (userMoney.getMoney() < transferMoney){
            throw new AccountOverTransferException("�������㣡");
        }else {
            if (bankDao.findUserByName(getMoneyUser).getUserName() == null){
                return false;
            }else {
                operateBean.setId(user.getId());
                operateBean.setOusername(user.getUserName());
                operateBean.setOBmoney(userMoney.getMoney());
                operateBean.setOmoney(transferMoney);
                operateBean.setOtype("ת��");
                UserBean getMonUser = bankDao.findUserByName(getMoneyUser);
                //��ȡת���û���ǰ���
                double moneyBygetMonUser = getMonUser.getMoney();
                //��ת���û���Ӧ�������
                double currentMoney = transferMoney + moneyBygetMonUser;
                bankDao.transfer(getMoneyUser, currentMoney);
                //ת���û���Ӧ������
                userMoney.setMoney(userMoney.getMoney() - transferMoney);
                operateBean.setAmoney(userMoney.getMoney());
                operateDao.insertRecord(operateBean);

                OperateBean transferInUser = new OperateBean();
                transferInUser.setId(getMonUser.getId());
                transferInUser.setOusername(getMoneyUser);
                transferInUser.setOtype("ת��");
                transferInUser.setOmoney(transferMoney);
                transferInUser.setOBmoney(getMonUser.getMoney());
                transferInUser.setAmoney(getMonUser.getMoney() + transferMoney);

                operateDao.insertRecord(transferInUser);
                return true;
            }

        }
    }

    /**
     * �����û������Ҷ�Ӧ������¼
     * @param username
     * @return
     */
    @Override
    public Vector<OperateBean> findRecordByUsername(String username) {
        return operateDao.findRecordByUsername(username);
    }

    public UserBean findUserByName(String username){
        return bankDao.findUserByName(username);
    }

    @Override
    public List<UserBean> findAll() {
        return bankDao.findAll();
    }

    @Override
    public void blockedUserById(int id,int isBlocked) {
        bankDao.blockedUserById(id,isBlocked);
    }


}
