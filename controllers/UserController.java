package com.bitcamp.controllers;

import javax.swing.JOptionPane;

import com.bitcamp.domains.CustomerBean;
import com.bitcamp.domains.MemberBean;
import com.bitcamp.serviceimpls.UserServiceImpl;
import com.bitcamp.services.UserService;

public class UserController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String temp = "";
		MemberBean mb = null;
		MemberBean[] mbs = null;
		String[] arr = null;
		UserService us = new UserServiceImpl();
		while(true) {
			switch(JOptionPane.showInputDialog("0.종료\n"
					+ "1.회원가입\n"
					+ "2.모든회원보기\n"
					+ "3.이름으로 찾기\n"
					+ "4.아이디로찾기\n"
					+ "5.로그인\n"
					+ "6.고객수\n"
					+ "7.아이디체크\n"
					+ "8.패스워드변경\n"
					+ "9.회원탈퇴\n")) {
			case "0":
				return;
			case "1":
				temp = JOptionPane.showInputDialog("아이디,비번,이름,주민번호");
				arr = temp.split(",");
				mb = new CustomerBean();
				mb.setId(arr[0]);
				mb.setPw(arr[1]);
				mb.setName(arr[2]);
				mb.setSsn(arr[3]);
				us.join(mb);
				
				break;
			case "2":
				
				mbs = new CustomerBean[11];
				UserServiceImpl usi = new UserServiceImpl();
				int count = usi.getCount();
				mbs = us.findAll();
				for(int i = 0;i < count;i++) {
				
					temp += mbs[i].toString() +"n";
					System.out.println(mbs[i].toString());
					
				}
				//, us.findAll().toString());
				JOptionPane.showMessageDialog(null, temp);
				
				break;
			case "3":
				 usi = new UserServiceImpl();
				 count = usi.getCount();
				 mbs = us.findByName( JOptionPane.showInputDialog("이름 입력"));
				 for(int i = 0 ;i < count; i++) {
					 if(mbs[i] == null) {break;}
					 temp += mbs[i].getId() + "  ";
					 
					 
				 }
				 JOptionPane.showMessageDialog(null, temp);
				
				break;
			case "4":
				
				mb = new MemberBean();
				mb = us.findById(JOptionPane.showInputDialog("아이디입력"));
				JOptionPane.showMessageDialog(null, mb.toString());
				break;
			case "5":
				temp = JOptionPane.showInputDialog("아이디,패스워드");
				arr = temp.split(",");
				mb.setId(arr[0]);
				mb.setPw(arr[1]);
				temp = (us.login(mb))? "로그인성공" : "로그인 실패";
				JOptionPane.showMessageDialog(null,temp);
				
				break;
			case "6":
				JOptionPane.showMessageDialog(null, String.valueOf(us.countCustomers()));
				break;
			case "7":
				temp = JOptionPane.showInputDialog("아이디입력");
				String n = (us.existId(temp))? "존재하는아이디" : "사용가능아이디";
				JOptionPane.showMessageDialog(null, n);
				break;
			case "8":
				arr = JOptionPane.showInputDialog("아이디,비번,새로운비번").split(",");
				mb.setId(arr[0]);
				mb.setPw(arr[1] + "," + arr[2]);
				us.updatePass(mb);
				
				
				break;
			case "9":
				arr = JOptionPane.showInputDialog("아이디,비번").split(",");
				mb.setId(arr[0]);
				mb.setPw(arr[1]);
				us.deleteMember(mb);
				break;
			
			}
		}

	}

}
