package com.sports.matching.dtos;

public class StatDto {

	private String team_id;
	private int attack;
	private int defence;
	private int manner;
	
	public StatDto() {
		// TODO Auto-generated constructor stub
	}

	public StatDto(String team_id, int attack, int defence, int manner) {
		super();
		this.team_id = team_id;
		this.attack = attack;
		this.defence = defence;
		this.manner = manner;
	}

	@Override
	public String toString() {
		return "StatDto [team_id=" + team_id + ", attack=" + attack + ", defence=" + defence + ", manner=" + manner
				+ "]";
	}

	public String getTeam_id() {
		return team_id;
	}

	public void setTeam_id(String team_id) {
		this.team_id = team_id;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefence() {
		return defence;
	}

	public void setDefence(int defence) {
		this.defence = defence;
	}

	public int getManner() {
		return manner;
	}

	public void setManner(int manner) {
		this.manner = manner;
	}
	
	
}
