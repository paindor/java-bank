package com.bitcamp.services;

import com.bitcamp.domains.AdminBean;
import com.bitcamp.domains.CustomerBean;
import com.bitcamp.domains.MemberBean;

public interface UserService {
	
	public void join(MemberBean param);
	CustomerBean[] findAll();
	MemberBean[] findByName(String name); 
	MemberBean findById(String id); // 고객사원 공용
	boolean login(MemberBean param);// 고객사원공용
	int countCustomers(); //고객수 
	int countAdmins();	//직원수
	boolean existId(String id);
	void updatePass(MemberBean param);
	void deleteMember(MemberBean param);
	
	
	
	
	

}
