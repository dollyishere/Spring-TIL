package com.dolly.spring.account;

public class AccountVO {
	private String accountNo;
	private String custName;
	private int balance;
	
	// 기본 생성자
	public AccountVO() {
	}
	
	// setter
	public AccountVO(String accountNo, String custName, int balance) {
		this.accountNo = accountNo;
		this.custName = custName;
		this.balance = balance;
	}

}
