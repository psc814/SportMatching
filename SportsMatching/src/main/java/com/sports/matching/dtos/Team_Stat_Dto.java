package com.sports.matching.dtos;

public class Team_Stat_Dto {

	private String team_id;
	private String captain_id;
	private String captain_phone_number;
	private String playground;
	private int attack;
	private int defence;
	private int manner;
	
	public Team_Stat_Dto() {
		// TODO Auto-generated constructor stub
	}

	public Team_Stat_Dto(String team_id, String captain_id, String captain_phone_number, String playground, int attack,
			int defence, int manner) {
		super();
		this.team_id = team_id;
		this.captain_id = captain_id;
		this.captain_phone_number = captain_phone_number;
		this.playground = playground;
		this.attack = attack;
		this.defence = defence;
		this.manner = manner;
	}

	@Override
	public String toString() {
		return "Team_Stat_Dto [team_id=" + team_id + ", captain_id=" + captain_id + ", captain_phone_number="
				+ captain_phone_number + ", playground=" + playground + ", attack=" + attack + ", defence=" + defence
				+ ", manner=" + manner + "]";
	}

	public String getTeam_id() {
		return team_id;
	}

	public void setTeam_id(String team_id) {
		this.team_id = team_id;
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
