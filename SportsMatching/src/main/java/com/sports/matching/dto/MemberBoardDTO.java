package com.sports.matching.dto;

import java.io.Serializable;

public class MemberBoardDTO implements Serializable {

	private static final long serialVersionUID = 8694556402127300780L;
	private int member_board_seq;
	private String member_id;
	private String board_title;
	private String board_content;
	private int readcount;
	private String regdate;
	private String category_code;
	private int replucount;

	public MemberBoardDTO() {
	}

	public MemberBoardDTO(int member_board_seq, String member_id, String board_title, String board_content, int readcount,
			String regdate, String category_code, int replucount) {
		super();
		this.member_board_seq = member_board_seq;
		this.member_id = member_id;
		this.board_title = board_title;
		this.board_content = board_content;
		this.readcount = readcount;
		this.regdate = regdate;
		this.category_code = category_code;
		this.replucount = replucount;
	}

	@Override
	public String toString() {
		return "MemberDTO [member_board_seq=" + member_board_seq + ", member_id=" + member_id + ", board_title="
				+ board_title + ", board_content=" + board_content + ", readcount=" + readcount + ", regdate=" + regdate
				+ ", category_code=" + category_code + ", replucount=" + replucount + "]";
	}

	public int getMember_board_seq() {
		return member_board_seq;
	}

	public void setMember_board_seq(int member_board_seq) {
		this.member_board_seq = member_board_seq;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
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
