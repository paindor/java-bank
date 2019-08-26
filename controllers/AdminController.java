package com.bitcamp.controllers;

import javax.swing.JOptionPane;

import com.bitcamp.domains.AccountBean;
import com.bitcamp.serviceimpls.AccountServiceImpl;
import com.bitcamp.services.AccountService;

public class AdminController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input = 0;
		String temp = "";
		String[] arr;
		AccountBean ac = null;
		AccountBean[] abs = null;
		AccountService as = new AccountServiceImpl();
		
		while(true) {
			switch(JOptionPane.showInputDialog("0.종료\n"
					+ "1.계좌생성\n"
					+ "2.모든계좌보기\n"
					+ "3.계좌번호검색\n"
					+ "4.계좌수보기\n"
					+ "5.중복확인\n"
					+ "6.입금\n"
					+ "7.출금\n"
					+ "8.해지")) {
			case "0":
				return;
			case "1":
				input = Integer.parseInt(JOptionPane.showInputDialog("금액입력"));
				as.createAccount(input);
				
				break;
			case "2":
				AccountServiceImpl asi = new AccountServiceImpl();
				input = asi.getCount();
				abs = new AccountBean[input];
				abs = as.findAll();
				for(int i = 0; i < input ; i++) {
					temp += abs[i].toString() +", \n";
				}
				JOptionPane.showMessageDialog(null, temp);
				break;
			case "3":
				ac = new AccountBean();
				ac = as.findByAccountNum(JOptionPane.showInputDialog("계좌번호입력"));
				JOptionPane.showMessageDialog(null, ac.toString());
				
				break;
			case "4":
				JOptionPane.showMessageDialog(null, "계좌수" + String.valueOf(as.countAccounts()));
				
				break;
				
			case "5":
				temp = JOptionPane.showInputDialog("계좌번호입력");
				String result = (as.existAccountNum(temp))? "존재하는 계좌번호" : "계좌생성가능";
				JOptionPane.showMessageDialog(null,result);
				break;
			case "6":
				arr = JOptionPane.showInputDialog("계좌번호,입금액 ").split(",");
				ac.setAccNum(arr[0]);
				ac.setMoney(Integer.parseInt(arr[1]));
				as.depositMoney(ac);
				
				break;
			case "7":
				arr = JOptionPane.showInputDialog("계좌번호,출금액 ").split(",");
				ac.setAccNum(arr[0]);
				ac.setMoney(Integer.parseInt(arr[1]));
				as.withdrawMoney(ac);
				break;
			case "8":
				as.deleteAccountNum(JOptionPane.showInputDialog("계좌번호입력"));
				
				break;
			}
		}

	}

}
