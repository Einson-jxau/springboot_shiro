package com.jxau.bank.view;

import com.jxau.bank.manager.ManagerInterface;
import com.jxau.bank.manager.impl.ManagerImpl;
import com.jxau.bank.util.AccountOverTransferException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class TransferFrame extends JFrame {
    JButton jb1, jb2;  //��ť
    JLabel jlb1, jlb2; //��ǩ
    JTextField jtf1, jtf2;
    JPanel jp1;

    private ManagerInterface manager = ManagerImpl.getInstance();
    public static boolean flag = true;

    public void transferFrame(String loginName) {

        //��Ӱ�ť
        jb1 = new JButton("ȷ��");
        jb2 = new JButton("����");

        //���ð�ť����
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String getMoneyUser = jtf1.getText();
                String strTransferMoney = jtf2.getText();
                transfer(loginName, getMoneyUser, strTransferMoney);

            }
        });

        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clear();
            }
        });

        //��ӱ�ǩ
        jlb1 = new JLabel("������Է��û�����");
        jlb2 = new JLabel("������ת�˽�");

        //�����ı���
        jtf1 = new JTextField();            //�Է��û���
        jtf2 = new JTextField();            //ת�����

        //�Է��˻��������
        jp1 = new JPanel();
        jp1.add(jlb1);
        jp1.add(jtf1);
        jp1.add(jlb2);
        jp1.add(jtf2);

        //���ò���
        this.setTitle("ת��");
        this.setLayout(null);
        this.setSize(400, 300);

        //�����Է��˻��ı�ǩ
        //jp1.setBounds(20, 20, 210, 60);
        //ȷ�������ð�ť
        jlb1.setBounds(30, 45, 120, 20);
        jtf1.setBounds(150, 45, 200, 30);
        jlb2.setBounds(30, 120, 120, 20);
        jtf2.setBounds(150, 120, 200, 30);
        jb1.setBounds(120, 180, 60, 28);
        jb2.setBounds(220, 180, 60, 28);


        this.add(jp1);
        this.add(jlb1);
        this.add(jtf1);
        this.add(jlb2);
        this.add(jtf2);
        this.add(jb1);
        this.add(jb2);

        this.setLocationRelativeTo(null);//����Ļ�м���ʾ(������ʾ)
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  //���ý��رյ�ǰ����

        this.setVisible(true);  //���ÿɼ�
        this.setResizable(false);    //���ò��������С

    }

    //����˺ź������
    private void clear() {
        jtf1.setText("");
        jtf2.setText("");    //����Ϊ��

    }

    private void transfer(String username, String getMoneyUser, String strTransferMoney) {
        try {
            if (getMoneyUser.equals(username)) {
                JOptionPane.showMessageDialog(null, "�����ܸ��Լ�ת�ˣ�", "��Ϣ��ʾ", JOptionPane.WARNING_MESSAGE);
                clear();
            } else if (Double.parseDouble(strTransferMoney) < 0) {
                JOptionPane.showMessageDialog(null, "ת�˽���Ϊ������", "��Ϣ��ʾ", JOptionPane.WARNING_MESSAGE);
                jtf2.setText("");
            } else {

                boolean flag = manager.transfer(getMoneyUser, Double.parseDouble(strTransferMoney));
                if (!flag) {
                    JOptionPane.showMessageDialog(null, "���û������ڣ�", "��Ϣ��ʾ", JOptionPane.WARNING_MESSAGE);
                    clear();
                } else {
                    JOptionPane.showMessageDialog(null, "�ɹ���" + getMoneyUser + "ת�ˣ�" + Double.parseDouble(strTransferMoney), "��Ϣ��ʾ", JOptionPane.WARNING_MESSAGE);
                    dispose();
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "������Ľ���������������룡", "��Ϣ��ʾ", JOptionPane.WARNING_MESSAGE);
            jtf2.setText("");
        } catch (AccountOverTransferException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "��Ϣ��ʾ", JOptionPane.WARNING_MESSAGE);
            jtf2.setText("");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
