package com.bitcamp.services;

import com.bitcamp.domains.AccountBean;

public interface AdminService {
	public void createAccount(int money);
	public String createAccountNum();
	
	//계좌번호생성 (랜덤숫자4 - 랜덤숫자4);
	
	public AccountBean[] findAll();
	public AccountBean findByAccountNum(String accountNum);
	public int countAccounts();
	public boolean existAccountNum(String accountNum);
	public String findDate(); //오늘날짜, 현재시간(분까지) 반환
	public void depositMoney(AccountBean param);
	public void withdrawMoney(AccountBean param);
	public void deleteAccountNum(String accountNum);
}
