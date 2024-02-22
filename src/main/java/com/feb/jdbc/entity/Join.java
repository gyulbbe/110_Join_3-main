package com.feb.jdbc.entity;

import org.apache.ibatis.type.Alias;

@Alias("Join")
public class Join {

	String memberId;
	String passWd;
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getPassWd() {
		return passWd;
	}
	public void setPassWd(String passWd) {
		this.passWd = passWd;
	}
	@Override
	public String toString() {
		return "Join [memberId=" + memberId + ", passWd=" + passWd + "]";
	}
}
