package com.jxau.bank.util;

/**
 * 存款为负数异常
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
