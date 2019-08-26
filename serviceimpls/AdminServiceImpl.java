package com.bitcamp.serviceimpls;

import java.util.Random;

import com.bitcamp.domains.AccountBean;
import com.bitcamp.services.AdminService;

public class AdminServiceImpl implements AdminService{

	AccountBean[] accounts;
	int count;
	Random rd;
	public AdminServiceImpl() {
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
	public String createAccountNum() {
		rd = new Random();
		String acnum ="";
		String num1 ="";
		String num2 = "";
		
		for(int i = 0; i< 4; i++ ) {
			num1 += rd.nextInt(9)+1;
			num2 += rd.nextInt(9)+1;
		}
		System.out.println(num1 + num2);
		return num1 + "-"+num2;
		
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
