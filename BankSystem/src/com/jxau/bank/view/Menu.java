
package com.jxau.bank.view;
/*
import com.jxau.bank.manager.ManagerInterface;
import com.jxau.bank.manager.impl.ManagerImpl;
import com.jxau.bank.util.AccountOverDrawnException;
import com.jxau.bank.util.InvalidDepositException;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TestBank {
    public static void main(String[] args) {
        //��ȡҵ������
        ManagerImpl manager = ManagerImpl.getInstance();
        //���������������
        Scanner sc = new Scanner(System.in);

        while (true) {
            printWelcomeMenu();
            System.out.println("��ӭʹ������ϵͳ���밴�ղ˵�����в���");
            //�����û�������Ϣ
            String line = sc.nextLine();
            switch (line) {
                case "1":
                    System.out.println("��ӭע������ϵͳ�������������Ϣ����ע��");
                    System.out.println("�������û�����");
                    String registerName = sc.nextLine();
                    System.out.println("���������룺");
                    String password = sc.nextLine();
                    File file = new File(registerName + ".properties");
                    try {
                        if (file.exists())
                            System.out.println("���û���ע�ᣡ");
                        else {
                            boolean registerFlag = manager.register(registerName, password);
                            if (!registerFlag) {
                                System.out.println("�û��������벻��Ϊ��");
                            } else {
                                System.out.println("ע��ɹ���");
                            }

                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "2":
                    System.out.println("�������û�����");
                    String loginName = sc.nextLine();
                    System.out.println("���������룺");
                    String loginPassword = sc.nextLine();
                    try {
                        boolean flag = manager.login(loginName, loginPassword);
                        if (!flag) {
                            System.out.println("�û�����������������ԣ�");
                        } else {
                            System.out.println("��¼�ɹ�����ӭ����" + loginName);
                            MainMenu();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "3":
                    System.out.println("�ѳɹ��˳���ϵͳ����ӭ�´�ʹ��");
                    System.exit(0);
                default:
                    System.out.println("�������������밴�ղ˵�����в���");
            }
        }
    }

    private static void MainMenu() {

        ManagerInterface manager = ManagerImpl.getInstance();
        Scanner sc = new Scanner(System.in);
        while (true) {
            printMenu();
            System.out.println("������˵���Ӧ���ֽ��в���:");
            String line = sc.nextLine();
            switch (line) {
                case "1":
                    double money = 0;
                    try {
                        money = manager.inquiry();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println("�������Ϊ��" + money);
                    break;
                case "2":
                    System.out.println("��������Ҫ����Ľ�");
                    String addMoney = sc.nextLine();
                    try {
                        manager.deposit(Double.parseDouble(addMoney));
                        System.out.println("�ɹ����룤" + Double.parseDouble(addMoney));
                    } catch (InvalidDepositException e) {
                        System.out.println(e.getMessage());
                    } catch (NumberFormatException e) {
                        System.out.println("������Ľ��������������ȷ���");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "3":
                    System.out.println("��������Ҫȡ���Ľ�");
                    String getMoney = sc.nextLine();
                    try {
                        manager.withdrawals(Double.parseDouble(getMoney));
                        System.out.println("�ɹ�ȡ����" + Double.parseDouble(getMoney));
                    } catch (NumberFormatException nfe) {
                        System.out.println("������Ľ��������������ȷ���");
                    } catch (AccountOverDrawnException e) {
                        System.out.println(e.getMessage());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "4":
                    System.out.println("������Ҫת�˵��û���");
                    String getMoneyUser = sc.nextLine();
                    System.out.println("������ת�˽�");
                    String strTransferMoney = sc.nextLine();
                    File file = new File(getMoneyUser + ".properties");
                    try {
                        if (file.exists()) {
                            manager.transfer(getMoneyUser, Double.parseDouble(strTransferMoney));
                        } else {
                            System.out.println("���û������ڣ�");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (NumberFormatException e){
                        System.out.println("������Ľ�����������ԣ�");
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case "5":
                    try {
                        System.out.println("�ѳɹ��˳���ϵͳ����ӭ�´�ʹ��");
                        manager.exitSystem();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                default:
                    System.out.println("�Ƿ����룬�밴�ղ˵����Ӧ���ֽ��в�����");
            }
        }
    }

    private static void printWelcomeMenu() {
        System.out.println("===============����ϵͳ1.5===============");
        System.out.println("|              1.ע     ��              |");
        System.out.println("|              2.��     ¼              |");
        System.out.println("|              3.��     ��              |");
        System.out.println("=================��ӭʹ��================");
    }

    public static void printMenu() {
        System.out.println("===============����ϵͳ1.5===============");
        System.out.println("|              1.��ѯ���               |");
        System.out.println("|              2.��    ��               |");
        System.out.println("|              3.ȡ    ��               |");
        System.out.println("|              4.ת    ��               |");
        System.out.println("|              5.�˳�ϵͳ               |");
        System.out.println("=================��ӭʹ��================");
    }
}
*/

import com.jxau.bank.manager.ManagerInterface;
import com.jxau.bank.manager.impl.ManagerImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;


public class Menu extends JFrame{

        private ManagerInterface manager = ManagerImpl.getInstance();

        JButton jb1, jb2, jb3, jb4, jb5, jb6;  //������ť
        JLabel jlb1, jlb2, jlb3;                //��ǩ

        public void Menu(String loginName, String loginPassword) {

                jb1 = new JButton("��ѯ");
                jb1.setFont(new Font("Microsoft JhengHei",1,20));
                jb2 = new JButton("���");
                jb2.setFont(new Font("Microsoft JhengHei",1,20));
                jb3 = new JButton("ȡ��");
                jb3.setFont(new Font("Microsoft JhengHei",1,20));
                jb4 = new JButton("ת��");
                jb4.setFont(new Font("Microsoft JhengHei",1,20));
                jb5 = new JButton("��¼");
                jb5.setFont(new Font("Microsoft JhengHei",1,20));
                jb6 = new JButton("�˿�");
                jb6.setFont(new Font("Microsoft JhengHei",1,20));


                jlb1 = new JLabel("����ϵͳ1.9");
                jlb1.setFont(new java.awt.Font("Microsoft JhengHei", 1, 26)); //�����������ͣ� �Ƿ�Ӵ֣��ֺ�
                jlb2 = new JLabel("��ӭ��" + loginName);
                jlb2.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18));
                jlb3 = new JLabel("����ѡ�����");
                jlb3.setFont(new java.awt.Font("Microsoft JhengHei", 1, 22));

                //�¼�����
                //��ѯ�¼�
                jb1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                double money = 0;
                                try {
                                        money = manager.inquiry();
                                } catch (IOException ex) {
                                        ex.printStackTrace();
                                }
                                new InquiryFrame().inquiryFrame(money,loginName);
                        }
                });

                //����¼�
                jb2.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                          if (manager.findUserByName(loginName).getIsBlocked() == 1){
                              JOptionPane.showMessageDialog(null,"�����˻��ѱ�����!","��Ϣ��ʾ",JOptionPane.WARNING_MESSAGE);
                          }else {
                              new AddMoneyFrame().addMoneyFrame();
                          }
                        }
                });

                //ȡ��
                jb3.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (manager.findUserByName(loginName).getIsBlocked() == 1){
                                JOptionPane.showMessageDialog(null,"�����˻��ѱ�����!","��Ϣ��ʾ",JOptionPane.WARNING_MESSAGE);
                            }else {
                                new GetMoneyFrame().getMoneyFrame();
                            }
                        }
                });

                //ת��
                jb4.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (manager.findUserByName(loginName).getIsBlocked() == 1) {
                                JOptionPane.showMessageDialog(null, "�����˻��ѱ�����!", "��Ϣ��ʾ", JOptionPane.WARNING_MESSAGE);
                            } else {

                                new TransferFrame().transferFrame(loginName);
                            }
                        }
                });

                //���׼�¼
                jb5.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            new RecordFrame().recordFrame(loginName);

                        }
                });

                //�˿��¼�
                jb6.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                try {
                                        manager.exitSystem();
                                        System.exit(0);
                                } catch (IOException ex) {
                                        ex.printStackTrace();
                                }
                                dispose();
                        }
                });


                this.setTitle("���й���ϵͳ");  //���ô������
                this.setSize(450, 400);         //���ô����С
                this.setLocation(400, 200);     //����λ��
                this.setLayout(null);           //���ò��֣������ò���


                //���ð�ť��λ�úʹ�С
                jb1.setBounds(0, 50, 90, 60);
                jb2.setBounds(0, 150, 90, 60);
                jb3.setBounds(0, 250, 90, 60);
                jb4.setBounds(354, 50, 90, 60);
                jb5.setBounds(354, 150, 90, 60);
                jb6.setBounds(354, 250, 90, 60);

                //���ñ�ǩ��λ�úʹ�С
                jlb1.setBounds(150, 20, 150, 50);
                jlb2.setBounds(170, 130, 270, 50);
                jlb3.setBounds(150, 250, 150, 50);

                this.add(jb1);   //���봰��
                this.add(jb2);
                this.add(jb3);
                this.add(jb4);
                this.add(jb5);
                this.add(jb6);
                this.add(jlb1);
                this.add(jlb2);
                this.add(jlb3);

                this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);  //���ùر�ǰȷ��
                addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosing(WindowEvent e) {
                                super.windowClosing(e);
                                int result = JOptionPane.showConfirmDialog(null,"ȷ��Ҫ�˳�ϵͳ��","�˳�ϵͳ",JOptionPane.YES_NO_OPTION);
                                if (result == JOptionPane.YES_OPTION){
                                        try {
                                                manager.exitSystem();
                                        } catch (IOException ex) {
                                                ex.printStackTrace();
                                        }
                                }
                        }
                });

                this.setVisible(true);  //���ÿɼ�
                this.setLocationRelativeTo(null);//����Ļ�м���ʾ(������ʾ)
                this.setResizable(false);   //���ò��������С
        }
}

