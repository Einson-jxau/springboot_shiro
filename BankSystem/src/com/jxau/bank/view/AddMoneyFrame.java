package com.jxau.bank.view;

import com.jxau.bank.manager.ManagerInterface;
import com.jxau.bank.manager.impl.ManagerImpl;
import com.jxau.bank.util.InvalidDepositException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddMoneyFrame extends JFrame implements ActionListener {
    JButton jb1, jb2, jb3;   //��ť
    JLabel jlb1, jlb2, jlb3; //��ǩ
    JTextField jtf;           //�ı���

    private ManagerInterface manager = ManagerImpl.getInstance();

    public void addMoneyFrame() {

        jb1 = new JButton("ȷ��");
        jb2 = new JButton("����");

        //���ð�ť����
        jb1.addActionListener(this);
        jb2.addActionListener(this);


        jlb1 = new JLabel("����������");  //��ӱ�ǩ

        //�����ı���
        jtf = new JTextField();


        //���ò���
        this.setTitle("���");
        this.setLayout(null);
        this.setSize(300, 200);

        //�����ǩ���ı���
        jlb1.setBounds(5, 20, 200, 20);
        jtf.setBounds(20, 50, 250, 30);
        jtf.setFont(new java.awt.Font("Dialog", 0, 15)); //��������Ϊ���Σ� ���Ӵ֣�15������

        //ȷ�������ð�ť
        jb1.setBounds(60, 120, 62, 28);
        jb2.setBounds(160, 120, 62, 28);


        this.add(jlb1);
        this.add(jtf);
        this.add(jb1);
        this.add(jb2);

        this.setLocationRelativeTo(null);//����Ļ�м���ʾ(������ʾ)
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  //���ý��رյ�ǰ����

        this.setVisible(true);  //���ÿɼ�
        this.setResizable(false);    //���ò��������С

    }

    //����˺ź������
    private void clear() {
        jtf.setText("");    //����Ϊ��

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String addMoney = jtf.getText();
        if (e.getActionCommand() == "ȷ��") {
            addMoney(addMoney);

        } else if (e.getActionCommand() == "����") {
            clear();
        }

    }

    private void addMoney(String addMoney) {
        try {
            manager.deposit(Double.parseDouble(addMoney));
            JOptionPane.showMessageDialog(null, "�ɹ����룤" + Double.parseDouble(addMoney),"��Ϣ��ʾ",JOptionPane.WARNING_MESSAGE);
            dispose();
        } catch (InvalidDepositException e) {
            JOptionPane.showMessageDialog(null,e.getMessage(),"��Ϣ��ʾ",JOptionPane.WARNING_MESSAGE);
            clear();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,"������Ľ����������������","��Ϣ��ʾ",JOptionPane.WARNING_MESSAGE);
            clear();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
