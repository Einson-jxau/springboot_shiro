package com.jxau.wmx.entity;
/**
 * ���������Ʒ��Ĺ�ϵ�е��м��
 * @author Administrator
 *
 */
public class OrderItem {

	private String oid;
	private Product product;//ҳ����Ҫ����Ʒ������ݣ��޸�Ϊ������Ʒ��������pid
	private int buynum;//��������
	private double subTotal;//С��
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getBuynum() {
		return buynum;
	}
	public void setBuynum(int buynum) {
		this.buynum = buynum;
	}
	public double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	
	
}
