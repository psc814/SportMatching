package com.sports.matching.dtos;

import java.io.Serializable;

public class TeamReplyDTO implements Serializable {


	private static final long serialVersionUID = -5980271256225560476L;
	private int reply_seq;
	private String team_id;
	private String reply_content;
	private int parents_board;
	private int refer;
	private int depth;

	public TeamReplyDTO() {
	}

	public TeamReplyDTO(int reply_seq, String team_id, String reply_content, int parents_board, int refer, int depth) {
		super();
		this.reply_seq = reply_seq;
		this.team_id = team_id;
		this.reply_content = reply_content;
		this.parents_board = parents_board;
		this.refer = refer;
		this.depth = depth;
	}

	@Override
	public String toString() {
		return "TeamReplyDTO [reply_seq=" + reply_seq + ", team_id=" + team_id + ", reply_content=" + reply_content
				+ ", parents_board=" + parents_board + ", refer=" + refer + ", depth=" + depth + "]";
	}

	public int getReply_seq() {
		return reply_seq;
	}

	public void setReply_seq(int reply_seq) {
		this.reply_seq = reply_seq;
	}

	public String getTeam_id() {
		return team_id;
	}

	public void setTeam_id(String team_id) {
		this.team_id = team_id;
	}

	public String getReply_content() {
		return reply_content;
	}

	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}

	public int getParents_board() {
		return parents_board;
	}

	public void setParents_board(int parents_board) {
		this.parents_board = parents_board;
	}

	public int getRefer() {
		return refer;
	}

	public void setRefer(int refer) {
		this.refer = refer;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

}
