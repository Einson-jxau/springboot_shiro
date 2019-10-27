package com.jxau.bank.view;

import com.jxau.bank.model.UserBean;

import javax.swing.*;

public class InquiryFrame extends JFrame {

    JLabel jlb1, jlb2;  //��ǩ
    JTextField jtf1,jtf2;   //�ı���
    JPanel jp1,jp2,jp3;     //���

    UserBean user = new UserBean();
    public void inquiryFrame(double money, String loginName){


        //��ǩ��Ϣ

        jlb1 = new JLabel("        ����");
        jlb2 = new JLabel("        ���");

        jtf1 = new JTextField(13);
        jtf1.setEditable(false);
        jtf2 = new JTextField(13);
        jtf2.setEditable(false);

        jp1 = new JPanel();
        jp2 = new JPanel();

        jp1.add(jlb1);
        jp1.add(jtf1);
        jp2.add(jlb2);
        jp2.add(jtf2);

        //���ò���
        this.setTitle("��ѯ���");
        this.setLayout(null);   //���ÿղ���

        jp1.setBounds(-10, 40, 300, 50);   //-������Ϊʲô-10 ��Ϊ ����ÿ�һ�㰡
        jp2.setBounds(-10, 110, 300, 50);

        //��JPane����JFrame��
        this.add(jp1);
        this.add(jp2);

        this.setSize(300, 300);   //���ô����С
        this.setLocationRelativeTo(null);//����Ļ�м���ʾ(������ʾ)
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  //���ý��رյ�ǰ����

        this.setVisible(true);  //���ÿɼ�
        this.setResizable(false);   //���ò��������С



        jtf1.setText(loginName);   //����Ϣ��ʾ���ı�����
        jtf2.setText(money + "");
    }
}
