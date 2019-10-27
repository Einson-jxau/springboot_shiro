package com.jxau.bank.dao;

import com.jxau.bank.model.OperateBean;

import java.awt.print.Book;
import java.util.Vector;

public interface OperateDaoInterface {


    /**
     * ����һ��������¼
     * @param operateBean
     */
    void insertRecord(OperateBean operateBean);


    /**
     * �����û�����ѯ�û�
     * @param username
     * @return
     */
    Vector<OperateBean> findRecordByUsername(String username);
}
