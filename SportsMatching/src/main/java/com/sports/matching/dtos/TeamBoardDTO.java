package com.sports.matching.dtos;

import java.io.Serializable;

public class TeamBoardDTO implements Serializable {

	private static final long serialVersionUID = 4419065816739155056L;
	private int team_board_seq;
	private String team_id;
	private String board_title;
	private String board_content;
	private int readcount;
	private String regdate;
	private String category_code;
	private int replucount;

	public TeamBoardDTO() {
		
	}

	public TeamBoardDTO(int team_board_seq, String team_id, String board_title, String board_content, int readcount,
			String regdate, String category_code, int replucount) {
		super();
		this.team_board_seq = team_board_seq;
		this.team_id = team_id;
		this.board_title = board_title;
		this.board_content = board_content;
		this.readcount = readcount;
		this.regdate = regdate;
		this.category_code = category_code;
		this.replucount = replucount;
	}

	@Override
	public String toString() {
		return "TeamBoardDTO [team_board_seq=" + team_board_seq + ", team_id=" + team_id + ", board_title="
				+ board_title + ", board_content=" + board_content + ", readcount=" + readcount + ", regdate=" + regdate
				+ ", category_code=" + category_code + ", replucount=" + replucount + "]";
	}

	public int getTeam_board_seq() {
		return team_board_seq;
	}

	public void setTeam_board_seq(int team_board_seq) {
		this.team_board_seq = team_board_seq;
	}

	public String getTeam_id() {
		return team_id;
	}

	public void setTeam_id(String team_id) {
		this.team_id = team_id;
	}

	public String getBoard_title() {
		return board_title;
	}

	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}

	public String getBoard_content() {
		return board_content;
	}

	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getCategory_code() {
		return category_code;
	}

	public void setCategory_code(String category_code) {
		this.category_code = category_code;
	}

	public int getReplucount() {
		return replucount;
	}

	public void setReplucount(int replucount) {
		this.replucount = replucount;
	}

}
