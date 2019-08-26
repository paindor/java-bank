package com.bitcamp.serviceimpls;

import java.util.Random;

import com.bitcamp.domains.AccountBean;
import com.bitcamp.services.AccountService;

public class AccountServiceImpl implements AccountService {

	AccountBean[] accounts;
	int count;
	public AccountServiceImpl() {
		accounts = new AccountBean[10];
		count = 0;
		
	}
	@Override
	public void createAccount(int money) {
		AccountBean acc = new AccountBean();
		String acnum = "", now = "";
		
		while(true) {
			acnum = this.createAccountNum();
			 now = this.findDate();
			if(!this.existAccountNum(acnum)) {
				break;
				
			}
			
		}
		acc.setAccNum(acnum);
		acc.setMoney(money);
		acc.setToday(now);
		accounts[count] = acc;
		count++;
		
		
		
	}

	@Override
	public String createAccountNum() {  // 랜덤4-랜4
		Random rd = new Random();
		
		
		return null;
	}

	@Override
	public AccountBean[] findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountBean findByAccountNum(String accountNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countAccounts() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean existAccountNum(String accountNum) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String findDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void depositMoney(AccountBean param) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void withdrawMoney(AccountBean param) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAccountNum(String accountNum) {
		// TODO Auto-generated method stub
		
	}

}
