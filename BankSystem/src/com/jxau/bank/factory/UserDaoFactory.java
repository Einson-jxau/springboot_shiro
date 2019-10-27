package com.jxau.bank.factory;

import com.jxau.bank.dao.BankDaoInterface;
import com.jxau.bank.dao.impl.BankDaoImpl;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.util.Properties;

public class UserDaoFactory {
    private static BankDaoInterface bankDao;

    private UserDaoFactory() throws Exception{
        //�������Լ�
        Properties pro = new Properties();
        //�����������ļ����ؽ��ڴ�
        FileInputStream fis = new FileInputStream(new File("classInfo.properties"));
        pro.load(fis);
        fis.close();
        //��ȡ���Լ���keyΪclassName��ֵ
        String className = pro.getProperty("className");
        //����ȡ��className���ؽ��ڴ�
        Class clazz = Class.forName(className);
        //��ȡclassName�Ĺ��췽�������Է������η�
        /*Constructor constructor = clazz.getDeclaredConstructor();
        //���Է���Ȩ�����η��İ�ȫ��飬�������䣬����ȫ
        constructor.setAccessible(true);
        //ִ�й��췽���������־ò����
        Object o = constructor.newInstance();*/
        Object o = clazz.newInstance();
        //�����صĶ�������ΪBankDaoInterface
        bankDao = (BankDaoInterface)o;
        //System.out.println(bankDao);

    }

    private static UserDaoFactory instance;

    //����������������
    public static synchronized UserDaoFactory getInstance() throws Exception {
        if(instance == null){
            instance = new UserDaoFactory();
        }
        return instance;
    }

    //��ȡ������ƴ����ĳ־ò����
    public static BankDaoInterface createBankDao() {
        return bankDao;
    }
}
