package com.jxau.bank.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import com.jxau.bank.manager.ManagerImpl;
import com.jxau.bank.manager.ManagerInterface;
import com.jxau.bank.model.MoneyBean;
import com.jxau.bank.util.AccountOverDrawnException;
import com.jxau.bank.util.InvalidDepositException;
import com.jxau.bank.util.MD5Utils;

public class TestBank {

    public static void main(String[] args) {

        ManagerInterface mi = ManagerImpl.getInstance();
        Scanner sc = new Scanner(System.in);

        while (true) {
            printWelcomeMenu();
            System.out.println("��ѡ�������:");
            String s = sc.nextLine();
            switch (s) {
                case "1":
                    System.out.println("��ӭע������ϵͳ�������������Ϣ����ע��");
                    System.out.println("������������");
                    String name = sc.nextLine();
                    System.out.println("���������룺");
                    String password = sc.nextLine();
                    try {
                        File file = new File("D:\\IdeaProjects\\BankTest\\" + name + "_info.properties");
                        if (file.exists()) {
                            System.out.println("���û��ѱ�ע��");
                        } else {
                            mi.register(name, password);
                            System.out.println("ע��ɹ������¼");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "2":
                    System.out.println("������������");
                    String loginName = sc.nextLine();
                    System.out.println("���������룺");
                    String loginPassword = sc.nextLine();
                    try {
                        MoneyBean mb = mi.login(loginName);
                        if (mb.getName().equals(loginName) && mb.getPassword().equals(MD5Utils.md5(loginPassword))) {
                            System.out.println("��¼�ɹ�����ӭ����" + loginName + "���밴�ղ˵�����в���");
                            MainMenu();
                        } else {
                            System.out.println("�û������������������");
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("����δע�ᣬ���Ƚ���ע��");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    System.out.println("�Ƿ����룬�밴�ղ˵����Ӧ���ֽ��в�����");
            }

        }
    }

    public static void MainMenu() {
        ManagerInterface mi = ManagerImpl.getInstance();
        Scanner sc = new Scanner(System.in);
        while (true) {
            printMenu();
            System.out.println("������˵���Ӧ���ֽ��в���:");
            String line = sc.nextLine();
            switch (line) {
                case "1":
                    double money = 0.0;
                    try {
                        money = mi.inquiry();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("�������Ϊ" + money);
                    break;
                case "2":
                    System.out.println("��������Ҫ����Ľ�");
                    String addMoney = sc.nextLine();
                    try {
                        double putMoney = mi.deposit(Double.parseDouble(addMoney));
                        System.out.println("�ɹ����룤" + putMoney);
                    } catch (NumberFormatException nfe) {
                        System.out.println("�Ƿ����룡����������");
                    } catch (InvalidDepositException e) {
                        System.out.println(e.getMessage());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "3":
                    System.out.println("��������Ҫȡ���Ľ�");
                    String getMoney = sc.nextLine();
                    try {
                        double getMoneys = mi.withdrawals(Double.parseDouble(getMoney));
                        System.out.println("�ɹ�ȡ����" + getMoneys);
                    } catch (NumberFormatException nfe) {
                        System.out.println("�Ƿ����룡������ȡ����");
                    } catch (AccountOverDrawnException e) {
                        System.out.println(e.getMessage());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case "4":
                    System.out.println("������Ҫת�˵��û���");
                    String getMoneyName = sc.nextLine();
                    System.out.println("������ת�˽�");
                    String strTransferMoney = sc.nextLine();
                    double transferMoney = Double.parseDouble(strTransferMoney);
                    try {
                    File file = new File("D:\\IdeaProjects\\BankTest\\" + getMoneyName + "_info.properties") ;
                    if (file.exists()){
                        mi.transfer(getMoneyName, transferMoney);
                    }else {
                        System.out.println("���û������ڣ�");
                    }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("�ɹ���" + getMoneyName + "ת�ˣ�" + strTransferMoney);
                    break;
                case "5":
                    mi.exitSystem();
                default:
                    System.out.println("�Ƿ����룬�밴�ղ˵����Ӧ���ֽ��в�����");
            }
        }
    }

    private static void printWelcomeMenu() {
        System.out.println("===============����ϵͳ1.4===============");
        System.out.println("|              1.ע     ��              |");
        System.out.println("|              2.��     ¼              |");
        System.out.println("=================��ӭʹ��================");
    }

    /**
     * ��ӡ�˵�
     */
    public static void printMenu() {
        System.out.println("===============����ϵͳ1.4===============");
        System.out.println("|              1.��ѯ���               |");
        System.out.println("|              2.��    ��               |");
        System.out.println("|              3.ȡ    ��               |");
        System.out.println("|              4.ת    ��               |");
        System.out.println("|              5.�˳�ϵͳ               |");
        System.out.println("=================��ӭʹ��================");
    }
}
