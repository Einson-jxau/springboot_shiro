package com.jxau.wmx.entity;

import java.io.Serializable;

/**
 * 
 * ���ﳵ������Ʒ��Ϣ
 *
 */
public class CartItem implements Serializable{
	
	private Product product;//���ﳵ��Ʒ��Ϣ
	private int count;//������Ʒ���������
	private double subTotal;//����ĳ����ƷС��
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	//�Զ����� 
	public double getSubTotal() {
		return count*product.getPrice();
	}
	

}
