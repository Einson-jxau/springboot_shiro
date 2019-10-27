package com.jxau.bank.view;

import com.jxau.bank.manager.ManagerInterface;
import com.jxau.bank.manager.impl.ManagerImpl;
import com.jxau.bank.model.UserBean;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;


public class AdminMenu extends JFrame implements ActionListener {
    private ManagerInterface manager = ManagerImpl.getInstance();
    JTable jt = null;
    JScrollPane jsp = null;
    JPanel jp;
    JButton jb1, jb2;
    int id;
    int isBlocked;
    int row;

    public void AdminMenu() {
        //columnNames�������
        Vector<String> columnNames = new Vector();
        //��������
        columnNames.add("�û�id");
        columnNames.add("�û���");
        columnNames.add("�û�����");
        columnNames.add("�û����");
        columnNames.add("�Ƿ񶳽�");

        //rowData�������������
        //rowData���Դ�Ŷ���,��ʼ�����ݿ���ȡ
        Vector<Vector<Object>> rowData = new Vector<Vector<Object>>();

        List<UserBean> list = manager.findAll();

        for (int i = 0; i < list.size(); i++) {
            Vector<Object> v = new Vector<>();
            UserBean user = list.get(i);
            v.add(user.getId());
            v.add(user.getUserName());
            v.add(user.getPassword());
            v.add(user.getMoney());
            v.add(user.getIsBlocked());
            rowData.add(v);
        }

        //��ʼ��JTable
        DefaultTableModel dtm = new DefaultTableModel(rowData, columnNames);
        jt = new JTable(dtm) {
            //���ñ��Ϊ���ɱ༭
            @Override
            public boolean isCellEditable(int row, int col) {
                    return false;
            }
        };


        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        //���ñ�����־���
        r.setHorizontalAlignment(JLabel.CENTER);
        jt.setDefaultRenderer(Object.class, r);
        //��ʼ�� jsp
        jsp = new JScrollPane(jt);
        this.setLayout(new BorderLayout());
        //��jsp���뵽jframe
        this.add(jsp,BorderLayout.NORTH);

        jp = new JPanel();
        jb1 = new JButton("����");
        jb1.setFont(new Font("Microsoft JhengHei",1,22));
        jb2 = new JButton("�ⶳ");
        jb2.setFont(new Font("Microsoft JhengHei",1,22));

        jb1.addActionListener(this);
        jb2.addActionListener(this);

        jt.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //��ѡ
                row = jt.rowAtPoint(e.getPoint());// ѡ����
                // int col =table.columnAtPoint(e.getPoint());//ѡ����
                //System.out.println(jt.getValueAt(row, 0) + "\t" + jt.getValueAt(row, 1));
                id = (int)jt.getValueAt(row,0);
                isBlocked = (int)jt.getValueAt(row,4);
                System.out.println(id + " " + isBlocked);
            }
        });

        jp.add(jb1);
        jp.add(jb2);
        this.add(jp,BorderLayout.SOUTH);

        this.setSize(1500, 600);

        jt.getTableHeader().setReorderingAllowed(false);   //���������ƶ�
        //���ñ�ͷ�����ֺ�
        jt.getTableHeader().setFont(new Font("Microsoft JhengHei", 1, 20));
        //���ñ���������ֺ�
        jt.setFont(new Font("Microsoft JhengHei", 1, 16));
        jt.getTableHeader().setBackground(Color.LIGHT_GRAY);
        jt.setBackground(Color.cyan);
        //�����и�
        jt.setRowHeight(40);
        this.setTitle("�û���Ϣ");


        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  //���ý��رյ�ǰ����
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand() == "����"){

            if (isBlocked == 1){
                JOptionPane.showMessageDialog(null,"���û��Ѿ������ᣡ�����ظ�����");
            }else {
                isBlocked = 1;
                manager.blockedUserById(id,isBlocked);
                JOptionPane.showMessageDialog(null,"����ɹ���");
                jt.setValueAt(1,row,4);
            }
        }else if (e.getActionCommand() == "�ⶳ"){
            if (isBlocked == 0){
                JOptionPane.showMessageDialog(null,"���û�δ�����ᣡ����˲���");
            }else {
                isBlocked = 0;
                manager.blockedUserById(id,isBlocked);
                JOptionPane.showMessageDialog(null,"�ⶳ�ɹ���");
                jt.setValueAt(0,row,4);
            }
        }
    }
}