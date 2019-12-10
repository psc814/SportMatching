package com.sports.matching.dto;

import java.io.Serializable;

public class MemberReplyDTO implements Serializable {

	
	private static final long serialVersionUID = 2655231755314043117L;
	private int reply_seq;
	private String member_id;
	private String reply_content;
	private int parents_board;
	private int refer;
	private int depth;

	public MemberReplyDTO() {
	}

	public MemberReplyDTO(int reply_seq, String member_id, String reply_content, int parents_board, int refer,
			int depth) {
		super();
		this.reply_seq = reply_seq;
		this.member_id = member_id;
		this.reply_content = reply_content;
		this.parents_board = parents_board;
		this.refer = refer;
		this.depth = depth;
	}

	@Override
	public String toString() {
		return "MemberReplyDTO [reply_seq=" + reply_seq + ", member_id=" + member_id + ", reply_content="
				+ reply_content + ", parents_board=" + parents_board + ", refer=" + refer + ", depth=" + depth + "]";
	}

	public int getReply_seq() {
		return reply_seq;
	}

	public void setReply_seq(int reply_seq) {
		this.reply_seq = reply_seq;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
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
