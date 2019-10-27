package com.jxau.wmx.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
/**
 * ���ﳵ
 * @author Administrator
 *
 */

public class Cart implements Serializable {

	private Map<Integer,CartItem>map=new LinkedHashMap();
	private double total;//�ܼ�
	
	// Cart��������cartItems����.��ȡ������Ʒ��Ϣ
	public Collection<CartItem> getCartItems() {
			return map.values();
	}

	public double getTotal() {
		return total;
	}
	
	public Map<Integer, CartItem> getMap() {
		return map;
	}

	public void setMap(Map<Integer, CartItem> map) {
		this.map = map;
	}

	//���ӹ��ﳵ
	public void addCart(CartItem cartItem) {
		//��ȡ��������Ʒ��id
		int pid=cartItem.getProduct().getPid();
		 //���ﳵ���Ѿ���ӹ�����Ʒ
		if(map.containsKey(pid)) {
		//��ȡ���ﳵ��ԭ������Ʒ
		CartItem oldItem=map.get(pid);
		//��������
		oldItem.setCount(oldItem.getCount()+
				cartItem.getCount());
		}else {
			map.put(pid, cartItem);
		}
		// �����ܼƵ�ֵ
		total += cartItem.getSubTotal();
	}
	
	//������ﳵ
	public void clearCart() {
		map.clear();
		total=0;
	}
	//ɾ��ĳ����Ʒ
	public void removeCart(int pid) {
		CartItem cartItem=map.remove(pid);
		total-=cartItem.getSubTotal();
	}
	
}
