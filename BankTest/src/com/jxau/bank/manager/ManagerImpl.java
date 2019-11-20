package com.jxau.bank.manager;


import com.jxau.bank.model.MoneyBean;
import com.jxau.bank.model.OrderedProperties;
import com.jxau.bank.util.AccountOverDrawnException;
import com.jxau.bank.util.InvalidDepositException;
import com.jxau.bank.util.MD5Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class ManagerImpl implements ManagerInterface {
    //˽�л����췽�������������ഴ������
    private ManagerImpl() {}

    private static ManagerImpl instance = null;

    public static ManagerImpl getInstance() {
        if (instance == null) {
            instance = new ManagerImpl();
        }
        return instance;
    }

    //����MoneyBean����
    MoneyBean mb = MoneyBean.getInstance();
    OrderedProperties properties = new OrderedProperties();

    /**
     * ע�Ṧ��
     *
     * @param name
     * @param password
     * @throws IOException
     */
    @Override
    public void register(String name, String password) throws IOException {

        properties.setProperty("name", name);
        properties.setProperty("password", MD5Utils.md5(password));
        properties.setProperty("money", "0.0");

        FileOutputStream fileOutputStream = new FileOutputStream(name + "_info.properties");
        properties.store(fileOutputStream, "User Information");
        fileOutputStream.close();


    }

    /**
     * ��¼����
     *
     * @param loginName
     * @return
     * @throws IOException
     */
    @Override
    public MoneyBean login(String loginName) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(loginName + "_info.properties");
        properties.load(fileInputStream);
        String name = properties.getProperty("name");
        String password = properties.getProperty("password");
        mb.setName(name);
        mb.setPassword(password);
        fileInputStream.close();
        return mb;
    }

    /**
     * ��ѯ���
     *
     * @return
     */
    public double inquiry() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(mb.getName() + "_info.properties");
        properties.load(fileInputStream);
        String strMoney = properties.getProperty("money");
        double money = Double.parseDouble(strMoney);
        fileInputStream.close();
        return money;
    }

    /**
     * ����
     *
     * @param money
     * @throws InvalidDepositException
     */
    public double deposit(double money) throws InvalidDepositException, IOException {
        if (money <= 0) {
            throw new InvalidDepositException("����Ϊ������");
        } else {
            String strMoney = properties.getProperty("money");
            double nowMoney = Double.parseDouble(strMoney);
            properties.setProperty("money", Double.toString(nowMoney + money));
            properties.setProperty(new SimpleDateFormat("yyyy��MM��dd��HHʱmm��ss��").format(new Date()) + "���룤", Double.toString(money));
            FileOutputStream fileOutputStream = new FileOutputStream(mb.getName() + "_info.properties");
            properties.store(fileOutputStream, "User Information");
            fileOutputStream.close();
        }
        return money;
    }

    /**
     * ȡ���
     *
     * @param money
     * @throws AccountOverDrawnException
     */
    public double withdrawals(double money) throws AccountOverDrawnException, IOException {
        String strMoney = properties.getProperty("money");
        double nowMoney = Double.parseDouble(strMoney);
        if (money <= 0) {
            System.out.println("������Ľ������");
        } else if (money > nowMoney) {
            throw new AccountOverDrawnException("��������!");
        } else {
            properties.setProperty("money", Double.toString(nowMoney - money));
            properties.setProperty(new SimpleDateFormat("yyyy��MM��dd��HHʱmm��ss��").format(new Date()) + "ȡ����", Double.toString(money));
            FileOutputStream fileOutputStream = new FileOutputStream(mb.getName() + "_info.properties");
            properties.store(fileOutputStream, "User Information");
            fileOutputStream.close();
        }
        return money;
    }

    /**
     * ת�˹���
     * @param name
     * @param money
     * @return
     */
    @Override
    public void transfer(String name, double money) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(name + "_info.properties");
        OrderedProperties getMoneyProperties = new OrderedProperties();
        getMoneyProperties.load(fileInputStream);
        String strGetMoney = getMoneyProperties.getProperty("money");
        double getMoney = Double.parseDouble(strGetMoney);
        FileOutputStream fileOutputStream = new FileOutputStream(name + "_info.properties");
        getMoneyProperties.setProperty("money", Double.toString(getMoney + money));
        getMoneyProperties.setProperty(new SimpleDateFormat("yyyy��MM��dd��HHʱmm��ss��").format(new Date()) + mb.getName() + "ת�룤",Double.toString(money));
        getMoneyProperties.store(fileOutputStream,"User information");
        fileOutputStream.close();
        fileInputStream.close();

        //ת����ɣ����½��
        String strNowMoney = properties.getProperty("money");
        double nowMoney = Double.parseDouble(strNowMoney);
        FileOutputStream outputStream = new FileOutputStream(mb.getName() + "_info.properties");
        properties.setProperty("money",Double.toString(nowMoney - money));
        properties.setProperty(new SimpleDateFormat("yyyy��MM��dd��HHʱmm��ss��").format(new Date()) + "��" + name + "ת����",Double.toString(money));
        properties.store(outputStream,"User information");
        outputStream.close();
    }


    /**
     * �˳�����
     */
    public void exitSystem() {
        System.out.println("�ѳɹ��˳���ϵͳ����ӭ�´�ʹ�ã�");
        System.exit(0);
    }
}
