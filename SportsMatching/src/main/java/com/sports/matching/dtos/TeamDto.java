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
	
	public TeamDto() {
		// TODO Auto-generated constructor stub
	}
}
