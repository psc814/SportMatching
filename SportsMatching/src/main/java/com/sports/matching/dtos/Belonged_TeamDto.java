package com.sports.matching.dtos;

public class Belonged_TeamDto {

	private int belonged_team_code;
	private String member_id;
	private String team_id;
	public Belonged_TeamDto() {
		// TODO Auto-generated constructor stub
	}

	public Belonged_TeamDto(int belonged_team_code, String member_id, String team_id) {
		super();
		this.belonged_team_code = belonged_team_code;
		this.member_id = member_id;
		this.team_id = team_id;
	}

	@Override
	public String toString() {
		return "Belonged_TeamDto [belonged_team_code=" + belonged_team_code + ", member_id=" + member_id + ", team_id="
				+ team_id + "]";
	}

	public int getBelonged_team_code() {
		return belonged_team_code;
	}

	public void setBelonged_team_code(int belonged_team_code) {
		this.belonged_team_code = belonged_team_code;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getTeam_id() {
		return team_id;
	}

	public void setTeam_id(String team_id) {
		this.team_id = team_id;
	}
	
}
