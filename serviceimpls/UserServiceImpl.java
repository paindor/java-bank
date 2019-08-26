package com.bitcamp.serviceimpls;

import com.bitcamp.domains.AdminBean;
import com.bitcamp.domains.CustomerBean;
import com.bitcamp.domains.MemberBean;
import com.bitcamp.services.UserService;

public class UserServiceImpl implements UserService{
	MemberBean[] members;
//	AdminBean[] admins;
	
	int count;
	//int countAdms;
	
	
	public UserServiceImpl() {
		members = new CustomerBean[10];
		count = 0;
		
		
		
	}

	@Override
	public void join(MemberBean param) {
		// TODO Auto-generated method stub
		members[count] = param;
		count++;
	}

	@Override
	public CustomerBean[] findAll() {
		MemberBean[] resultMems = new CustomerBean[count];
		for(int i = 0 ; i < count ;i++) {
			resultMems[i] = members[i];
			
		}
		
		return (CustomerBean[]) resultMems;
		
	}

	@Override
	public MemberBean[] findByName(String name) {
		int index =0;
		
		for(int i = 0 ;i <count ; i++) {
			
			if(name.equals(members[i].getName())){
				index++;
				
			}
		}
		MemberBean[] tempCust = new CustomerBean[index];
		index = 0;
		
		for(int i = 0 ;i <count ; i++) {
			
			if(name.equals(members[i].getName())){
				tempCust[index] = members[i];
				index++;
				if(index == tempCust.length) {
					break;
					
				}
				
				
			}
		}
		return tempCust;
	}

	@Override
	public MemberBean findById(String id) {
		MemberBean temp = new MemberBean();
		for(int i = 0 ;i < count; i++) {
			if(id.equals(members[i].getId())) {
				temp = members[i];
				
			}
		}
		return temp;
	}

	@Override
	public boolean login(MemberBean param) {
		boolean isSuccess = false;
		for(int i = 0 ; i < count ; i++) {
			if(param.getId().equals(members[i].getId()) && param.getPw().equals(members[i].getPw())){
				isSuccess = true;
				
			}
		}
		return isSuccess;
	}

	@Override
	public int countCustomers() {

		
		return count;
	}

	@Override
	public int countAdmins() {


		return count;
	}

	@Override
	public boolean existId(String id) {
		boolean isExist = false;
		for(int i = 0 ; i < count; i++) {
			if(id.equals(members[i].getId())){
				isExist = true;
			}
		}
		return isExist;
	}

	@Override
	public void updatePass(MemberBean param) {
		for(int i = 0 ; i< count; i++) {
			String[] arr = param.getPw().split(",");
			if(param.getId().equals(members[i].getId() )&& arr[0].equals(members[i].getPw())){
				members[i].setPw(arr[1]);
			}
		}
		
	}

	@Override
	public void deleteMember(MemberBean param) {
		MemberBean[] temp = new MemberBean[count-1];
		int iter = 0;
		for(int i = 0 ;i < count; i++) {
			if(param.getId().equals(members[i].getId())){
				members[i] = new MemberBean();
				
			}
			else {
				temp[iter] = members[i];
				iter++;
			}
		}
		count--;
		for(int i = 0 ;i <count; i++) {
			members[i] = temp[i];
			
		}
		// TODO Auto-generated method stub
		
	}



}
