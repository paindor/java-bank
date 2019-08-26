package com.bitcamp.domains;

public class CustomerBean extends MemberBean{
	private int credit;
	
	
	public void setCredit(int credit) {
		this.credit = credit;
		
	}
	public int getCredit() {
		return this.credit;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("아이디: %s \n"
				+ "이름:%s\n"
				+ "주민번호:%s\n"
				+ "신용등급: %d", super.getId(), super.getName(), super.getSsn(), this.credit);
	}

}
