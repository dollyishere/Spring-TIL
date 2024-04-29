package com.dolly.spring.account;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/** action-mybatis.xml <tx:~~~> **/
@Transactional(propagation=Propagation.REQUIRED)
public class AccountService {
	private AccountDAO accDAO;
	
	public void setAccDAO(AccountDAO accDAO) {
		this.accDAO = accDAO;
	}

	public void sendMoney() throws Exception {
		accDAO.upBalance1();
		accDAO.upBalance2();
	}
	
	public AccountService() {
		// TODO Auto-generated constructor stub
	}

}
