package com.jxau.bank.util;

/**
 * ȡ�������쳣
 * @author xie
 *
 */
@SuppressWarnings("serial")
public class AccountOverDrawnException extends Exception {

	public AccountOverDrawnException(){ }
	
	public AccountOverDrawnException(String message){
		super(message);
	}
}
