package com.sports.matching.dtos;

import java.io.Serializable;

public class StadiumAdminDto implements Serializable {

	private static final long serialVersionUID = -7144406024044827246L;

	private String admin_id;
	private String admin_pw;

	public StadiumAdminDto() {
		
	}

	@Override
	public String toString() {
		return "StadiumAdminDto [admin_id=" + admin_id + ", admin_pw=" + admin_pw + "]";
	}

	public String getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}

	public String getAdmin_pw() {
		return admin_pw;
	}

	public void setAdmin_pw(String admin_pw) {
		this.admin_pw = admin_pw;
	}

}
