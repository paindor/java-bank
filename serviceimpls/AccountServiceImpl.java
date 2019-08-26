package com.bitcamp.serviceimpls;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import com.bitcamp.domains.AccountBean;
import com.bitcamp.services.AccountService;

public class AccountServiceImpl implements AccountService {


	private AccountBean[] accounts;
	private int count;
	private Random rd;
	private SimpleDateFormat sdf;
	private Date date;
	public AccountServiceImpl() {
		accounts = new AccountBean[10];
		count = 0;
		
	}
	public int getCount() {
		return this.count;
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
		return accounts;
	}

	@Override
	public AccountBean findByAccountNum(String accountNum) {
		AccountBean result = new AccountBean();
		for(int i =0 ; i< count; i++) {
			if(accountNum.equals(accounts[i].getAccNum())){
				result = accounts[i];
			}
		}
		return result;
	}

	@Override
	public int countAccounts() {
		// TODO Auto-generated method stub
		return count;
	}

	@Override
	public boolean existAccountNum(String accountNum) {
		boolean result = false;
		for(int i = 0 ;i < count ; i++) {
			if(accountNum.equals(accounts[i].getAccNum())) {
				result = true;
				
			}
		}
		return result;
	}

	@Override
	public String findDate() {
		sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm");
		date = new Date();
		String now = sdf.format(date);
		
		
		
		return now;
	}

	@Override
	public void depositMoney(AccountBean param) {
		if(this.existAccountNum(param.getAccNum())) {
			for(int i = 0 ; i < count ;i++) {
				if(param.getAccNum().equals(accounts[i].getAccNum())) {
					int money = accounts[i].getMoney();
					accounts[i].setMoney(money + param.getMoney());
					break;
				}
			}
		}
		
	}

	@Override
	public void withdrawMoney(AccountBean param) {
		if(this.existAccountNum(param.getAccNum())) {
			for(int i = 0 ; i < count; i++) {
				if(param.getAccNum().equals(accounts[i].getAccNum())) {
					if(param.getMoney() <= accounts[i].getMoney()) {
						int money = accounts[i].getMoney();
						accounts[i].setMoney(money - param.getMoney());
						break;
					}
					break;
					
					
				}
			}
		}
		
	}

	@Override
	public void deleteAccountNum(String accountNum) {
		AccountBean[] temp = new AccountBean[count -1];
		int index = 0;
		for(int i = 0; i < count; i++) {
			if(accountNum.equals(accounts[i].getAccNum())) {
				accounts[i] = new AccountBean();
				
			}
			else {
				temp[index] = accounts[i];
				index++;
				
			}
			
		}
		count--;
		for(int i = 0 ; i < count ; i++) {
			accounts[i] = temp[i];
		}
		
		
		// TODO Auto-generated method stub
		
	}

}
