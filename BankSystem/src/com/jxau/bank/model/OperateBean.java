package com.jxau.bank.model;

import java.sql.Timestamp;

public class OperateBean {
    private int id;             //�û�id
    private String Ousername;   //�û���
    private String Otype;       //��������
    private Timestamp Otime;    //����ʱ��
    private double Omoney;      //�������
    private double OBmoney;     //�ϴ����
    private double Amoney;      //�������

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOusername() {
        return Ousername;
    }

    public void setOusername(String ousername) {
        Ousername = ousername;
    }

    public String getOtype() {
        return Otype;
    }

    public void setOtype(String otype) {
        Otype = otype;
    }

    public Timestamp getOtime() {
        return Otime;
    }

    public void setOtime(Timestamp otime) {
        Otime = otime;
    }

    public double getOmoney() {
        return Omoney;
    }

    public void setOmoney(double omoney) {
        Omoney = omoney;
    }

    public double getOBmoney() {
        return OBmoney;
    }

    public void setOBmoney(double OBmoney) {
        this.OBmoney = OBmoney;
    }

    public double getAmoney() {
        return Amoney;
    }

    public void setAmoney(double amoney) {
        Amoney = amoney;
    }

    @Override
    public String toString() {
        return "OperateBean{" + "id=" + id + ", Ousername='" + Ousername + '\'' + ", Otype='" + Otype + '\'' + ", Otime=" + Otime + ", Omoney=" + Omoney + ", OBmoney=" + OBmoney + ", Amoney=" + Amoney + '}';
    }
}
