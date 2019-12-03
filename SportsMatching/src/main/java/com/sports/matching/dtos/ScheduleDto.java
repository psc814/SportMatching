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
	
	
	
}
