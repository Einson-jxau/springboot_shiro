package com.jxau.bank.util;

/**
 * ���Ϊ�����쳣
 * @author xie
 *
 */
@SuppressWarnings("serial")
public class InvalidDepositException extends Exception {

	public InvalidDepositException() {	}

	public InvalidDepositException(String message) {
		super(message);
	}
	
}
