package com.jxau.bank.view;

import com.jxau.bank.manager.ManagerInterface;
import com.jxau.bank.manager.impl.ManagerImpl;
import com.jxau.bank.model.OperateBean;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

public class RecordFrame extends JFrame {

    private ManagerInterface manager = ManagerImpl.getInstance();
    JTable jt = null;
    JScrollPane jsp = null;

    public void recordFrame(String username) {
        //columnNames�������
        Vector<String> columnNames = new Vector();
        //��������
        columnNames.add("�û�id");
        columnNames.add("�û���");
        columnNames.add("��������");
        columnNames.add("����ʱ��");
        columnNames.add("�������");
        columnNames.add("�ϴ����");
        columnNames.add("�������");

        //rowData�������������
        //rowData���Դ�Ŷ���,��ʼ�����ݿ���ȡ
        Vector<Vector<Object>> rowData = new Vector<Vector<Object>>();

        Vector<OperateBean> record = manager.findRecordByUsername(username);

        for (int i = 0; i < record.size(); i++) {
            Vector<Object> v = new Vector<>();
            OperateBean o = record.get(i);
            v.add(o.getId());
            v.add(o.getOusername());
            v.add(o.getOtype());
            v.add(o.getOtime());
            v.add(o.getOmoney());
            v.add(o.getOBmoney());
            v.add(o.getAmoney());
            rowData.add(v);
        }


        //��ʼ��JTable
        DefaultTableModel dtm = new DefaultTableModel(rowData,columnNames);
        jt = new JTable(dtm){
            //���ñ��Ϊ���ɱ༭
             @Override
             public boolean isCellEditable(int row, int col){
                 return false;
             }
        };

        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        //���ñ�����־���
        r.setHorizontalAlignment(JLabel.CENTER);
        jt.setDefaultRenderer(Object.class,r);
        //��ʼ�� jsp
        jsp = new JScrollPane(jt);

        //��jsp���뵽jframe
        this.add(jsp);

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
        this.setTitle("���׼�¼");

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  //���ý��رյ�ǰ����
        this.setVisible(true);

    }
}
