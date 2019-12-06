package com.sports.matching.dtos;

import java.io.Serializable;
import java.util.Date;

public class MatchingCardDto implements Serializable {

	private static final long serialVersionUID = -6692767695839871937L;

	private int matching_number;
	private Date game_date;
	private String regist_team_id;
	private String regist_team_info;
	private String applied_team_id;
	private String applied_team_info;
	private String reservation_stadium;
	private String matching_style;
	private String accomplish;
	private ScheduledMatchingDto smdto;



	public ScheduledMatchingDto getSmdto() {
		return smdto;
	}

	public void setSmdto(ScheduledMatchingDto smdto) {
		this.smdto = smdto;
	}

	public MatchingCardDto() {

	}

	@Override
	public String toString() {
		return "MatchingCardDto [matching_number=" + matching_number + ", game_date=" + game_date + ", regist_team_id="
				+ regist_team_id + ", regist_team_info=" + regist_team_info + ", applied_team_id=" + applied_team_id
				+ ", applied_team_info=" + applied_team_info + ", reservation_stadium=" + reservation_stadium
				+ ", matching_style=" + matching_style + ", accomplish=" + accomplish + "]";
	}

	public int getMatching_number() {
		return matching_number;
	}

	public void setMatching_number(int matching_number) {
		this.matching_number = matching_number;
	}

	public Date getGame_date() {
		return game_date;
	}

	public void setGame_date(Date game_date) {
		this.game_date = game_date;
	}

	public String getRegist_team_id() {
		return regist_team_id;
	}

	public void setRegist_team_id(String regist_team_id) {
		this.regist_team_id = regist_team_id;
	}

	public String getRegist_team_info() {
		return regist_team_info;
	}

	public void setRegist_team_info(String regist_team_info) {
		this.regist_team_info = regist_team_info;
	}

	public String getApplied_team_id() {
		return applied_team_id;
	}

	public void setApplied_team_id(String applied_team_id) {
		this.applied_team_id = applied_team_id;
	}

	public String getApplied_team_info() {
		return applied_team_info;
	}

	public void setApplied_team_info(String applied_team_info) {
		this.applied_team_info = applied_team_info;
	}

	public String getReservation_stadium() {
		return reservation_stadium;
	}

	public void setReservation_stadium(String reservation_stadium) {
		this.reservation_stadium = reservation_stadium;
	}

	public String getMatching_style() {
		return matching_style;
	}

	public void setMatching_style(String matching_style) {
		this.matching_style = matching_style;
	}

	public String getAccomplish() {
		return accomplish;
	}

	public void setAccomplish(String accomplish) {
		this.accomplish = accomplish;
	}

}
