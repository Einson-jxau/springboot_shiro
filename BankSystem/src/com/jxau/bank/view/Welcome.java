package com.jxau.bank.view;

import com.jxau.bank.manager.ManagerInterface;
import com.jxau.bank.manager.impl.ManagerImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Welcome extends JFrame implements ActionListener {

    JButton jb1, jb2;  //��ť
    JPanel jp0, jp1, jp2, jp3, jp4;        //���
    JTextField jtf;   //�ı���
    JLabel jlb0, jlb1, jlb2; //��ǩ
    JPasswordField jpf; //�����
    JRadioButton jrb1, jrb2;
    ButtonGroup bg;

    private ManagerInterface manager = ManagerImpl.getInstance();


    public void Welcome() {
        jb1 = new JButton("��¼");
        jb1.setFont(new Font("Microsoft JhengHei",1,16));
        jb2 = new JButton("ע��");
        jb2.setFont(new Font("Microsoft JhengHei",1,16));
        //���ð�ť����
        jb1.addActionListener(this);
        jb2.addActionListener(this);

        //jb1.setBounds(100,300,80,30);

        //�������
        jp0 = new JPanel();
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();

        //��ӱ�ǩ
        jlb0 = new JLabel("�� �� ϵ ͳ 1.9");
        jlb0.setFont(new Font("΢���ź�",1,32));
        jlb1 = new JLabel("�û�����");
        jlb1.setFont(new Font("Microsoft JhengHei",0,22));
        jlb2 = new JLabel("��  �룺");
        jlb2.setFont(new Font("Microsoft JhengHei",0,22));

        //�����ı���������
        jtf = new JTextField(10);
        jtf.setFont(new Font("Microsoft JhengHei",1,16));
        jpf = new JPasswordField(10);
        jpf.setFont(new Font("Microsoft JhengHei",1,16));

        //������ѡ��
        jrb1 = new JRadioButton("����Ա");
        jrb1.setFont(new Font("Microsoft JhengHei",1,16));
        jrb2 = new JRadioButton("�� ��");
        jrb2.setFont(new Font("Microsoft JhengHei",1,16));
        //�����û���ѡ��ΪĬ��ѡ��
        jrb2.setSelected(true);

        //ʹ��ѡ�򻥳�
        bg = new ButtonGroup();
        bg.add(jrb1);
        bg.add(jrb2);

        //���������
        jp0.add(jlb0);
        jp1.add(jlb1);
        jp1.add(jtf);

        jp2.add(jlb2);
        jp2.add(jpf);

        jp3.add(jrb1);
        jp3.add(jrb2);

        jp4.add(jb1);
        jp4.add(jb2);

        //��JPane����JFrame��
        this.add(jp0);
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.add(jp4);

        //���ò���
        this.setTitle("����ϵͳ");
        this.setLayout(new GridLayout(5, 1));
        this.setSize(700, 500);   //���ô����С
        this.setLocationRelativeTo(null);//����Ļ�м���ʾ(������ʾ)
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  //���ý��رյ�ǰ����

        this.setVisible(true);  //���ÿɼ�
        this.setResizable(false);   //���ò��������С

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String username = jtf.getText();
        String password = jpf.getText();
        if (e.getActionCommand() == "��¼") {
            if (jrb1.isSelected()){
                //����Ա��¼
                if("admin".equals(username) && "admin".equals(password)) {
                    new AdminMenu().AdminMenu();
                    dispose();
                }else if("".equals(username) || "".equals(password)){
                    JOptionPane.showMessageDialog(null,"�û��������벻��Ϊ��");
                }else{
                    JOptionPane.showMessageDialog(null, "�����ǹ���Ա��");
                }
            }else {
                //�û���¼
                if("".equals(username) || "".equals(password)){
                    JOptionPane.showMessageDialog(null,"�û��������벻��Ϊ��");
                } else{
                    checkLogin(username, password);
                }
            }


        } else if (e.getActionCommand() == "ע��") {
            if (jrb1.isSelected()){
                JOptionPane.showMessageDialog(null,"��ѡ����ͨ�û�����ע�ᣡ");
            }else {
                checkRegister(username, password);
            }
        }
    }

    public void checkLogin(String loginName,String loginPassword){
        boolean flag = false;
        try {
            flag = manager.login(loginName, loginPassword);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!flag) {
            JOptionPane.showMessageDialog(null, "�û������������������","��Ϣ��ʾ",JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "��¼�ɹ���","��Ϣ��ʾ",JOptionPane.WARNING_MESSAGE);
            dispose();  //ʹ��ԭ������ʧ
            new Menu().Menu(loginName,loginPassword);
        }

    }

    public void checkRegister(String username,String password){
        if ("".equals(username) && "".equals(password)){
            JOptionPane.showMessageDialog(null, "�û��������벻��Ϊ�գ�","��Ϣ��ʾ",JOptionPane.WARNING_MESSAGE);
        }else {
            boolean registerFlag = false;
            try {
                registerFlag = manager.register(username, password);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (registerFlag){
                JOptionPane.showMessageDialog(null, "ע��ɹ���","��Ϣ��ʾ",JOptionPane.WARNING_MESSAGE);
                //dispose();
                //new Menu().Menu(username,password);
            }else {
                JOptionPane.showMessageDialog(null, "���û��Ѵ��ڣ�","��Ϣ��ʾ",JOptionPane.WARNING_MESSAGE);

            }
        }

    }



}
