package com.sports.matching.dtos;

import java.io.Serializable;

public class TeamDto implements Serializable{
	
	
	
	private static final long serialVersionUID = 7503700142728839874L;
	
	private String team_id;
	private String team_pw;
	private String captain_id;
	private String captain_phone_number;
	private String playground;
	private String question;
	private String answer;
	private String dormant_id;
	private String last_login_date;
	
	public TeamDto() {
		// TODO Auto-generated constructor stub
	}

	public TeamDto(String team_id, String team_pw, String captain_id, String captain_phone_number, String playground,
			String question, String answer, String dormant_id, String last_login_date) {
		super();
		this.team_id = team_id;
		this.team_pw = team_pw;
		this.captain_id = captain_id;
		this.captain_phone_number = captain_phone_number;
		this.playground = playground;
		this.question = question;
		this.answer = answer;
		this.dormant_id = dormant_id;
		this.last_login_date = last_login_date;
	}

	@Override
	public String toString() {
		return "TeamDto [team_id=" + team_id + ", team_pw=" + team_pw + ", captain_id=" + captain_id
				+ ", captain_phone_number=" + captain_phone_number + ", playground=" + playground + ", question="
				+ question + ", answer=" + answer + ", dormant_id=" + dormant_id + ", last_login_date="
				+ last_login_date + "]";
	}

	public String getTeam_id() {
		return team_id;
	}

	public void setTeam_id(String team_id) {
		this.team_id = team_id;
	}

	public String getTeam_pw() {
		return team_pw;
	}

	public void setTeam_pw(String team_pw) {
		this.team_pw = team_pw;
	}

	public String getCaptain_id() {
		return captain_id;
	}

	public void setCaptain_id(String captain_id) {
		this.captain_id = captain_id;
	}

	public String getCaptain_phone_number() {
		return captain_phone_number;
	}

	public void setCaptain_phone_number(String captain_phone_number) {
		this.captain_phone_number = captain_phone_number;
	}

	public String getPlayground() {
		return playground;
	}

	public void setPlayground(String playground) {
		this.playground = playground;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getDormant_id() {
		return dormant_id;
	}

	public void setDormant_id(String dormant_id) {
		this.dormant_id = dormant_id;
	}

	public String getLast_login_date() {
		return last_login_date;
	}

	public void setLast_login_date(String last_login_date) {
		this.last_login_date = last_login_date;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}
