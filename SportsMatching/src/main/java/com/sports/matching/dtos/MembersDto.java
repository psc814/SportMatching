package com.sports.matching.dtos;

public class MembersDto {
	private String member_id;
	private String withdraw;
	
	public MembersDto() {
		// TODO Auto-generated constructor stub
	}

	public MembersDto(String member_id, String withdraw) {
		super();
		this.member_id = member_id;
		this.withdraw = withdraw;
	}

	@Override
	public String toString() {
		return "MembersDto [member_id=" + member_id + ", withdraw=" + withdraw + "]";
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(String withdraw) {
		this.withdraw = withdraw;
	}
	

}
