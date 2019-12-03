package com.sports.matching.dtos;

import java.io.Serializable;
import java.util.Date;

public class ScheduleDto implements Serializable{

	private static final long serialVersionUID = 2449387212794307756L;

	private int schedule_id;
	private String stadium_code;
	private Date game_date;
	private String home_team;
	private String away_team;
	private int home_score;
	private int away_score;
	private String home_reservation;
	private String home_cancel;
	private String away_reservation;
	private String away_cancel;
	
	public ScheduleDto() {
		// TODO Auto-generated constructor stub
	}

	public int getSchedule_id() {
		return schedule_id;
	}

	public void setSchedule_id(int schedule_id) {
		this.schedule_id = schedule_id;
	}

	public String getStadium_code() {
		return stadium_code;
	}

	public void setStadium_code(String stadium_code) {
		this.stadium_code = stadium_code;
	}

	public Date getGame_date() {
		return game_date;
	}

	public void setGame_date(Date game_date) {
		this.game_date = game_date;
	}

	public String getHome_team() {
		return home_team;
	}

	public void setHome_team(String home_team) {
		this.home_team = home_team;
	}

	public String getAway_team() {
		return away_team;
	}

	public void setAway_team(String away_team) {
		this.away_team = away_team;
	}

	public int getHome_score() {
		return home_score;
	}

	public void setHome_score(int home_score) {
		this.home_score = home_score;
	}

	public int getAway_score() {
		return away_score;
	}

	public void setAway_score(int away_score) {
		this.away_score = away_score;
	}

	public String getHome_reservation() {
		return home_reservation;
	}

	public void setHome_reservation(String home_reservation) {
		this.home_reservation = home_reservation;
	}

	public String getHome_cancel() {
		return home_cancel;
	}

	public void setHome_cancel(String home_cancel) {
		this.home_cancel = home_cancel;
	}

	public String getAway_reservation() {
		return away_reservation;
	}

	public void setAway_reservation(String away_reservation) {
		this.away_reservation = away_reservation;
	}

	public String getAway_cancel() {
		return away_cancel;
	}

	public void setAway_cancel(String away_cancel) {
		this.away_cancel = away_cancel;
	}

	@Override
	public String toString() {
		return "ScheduleDto [schedule_id=" + schedule_id + ", stadium_code=" + stadium_code + ", game_date=" + game_date
				+ ", home_team=" + home_team + ", away_team=" + away_team + ", home_score=" + home_score
				+ ", away_score=" + away_score + ", home_reservation=" + home_reservation + ", home_cancel="
				+ home_cancel + ", away_reservation=" + away_reservation + ", away_cancel=" + away_cancel + "]";
	}
	
}
