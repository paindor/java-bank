package com.bitcamp.domains;

public class AdminBean extends MemberBean {
	
	int sabun;

	public int getSabun() {
		return sabun;
	}

	public void setSabun(int sabun) {
		this.sabun = sabun;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("아이디: %s \n"
				+ "이름:%s\n"
				+ "주민번호:%s\n"
				+ "사번: %d", super.getId(), super.getName(), super.getSsn(), this.sabun);
	}

}
