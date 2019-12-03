package com.sports.matching.dtos;

import java.io.Serializable;

public class StadiumDto implements Serializable {

	private static final long serialVersionUID = 5931220769839450323L;

	private String stadium_code;
	private String admin_id;
	private String stadium_name;
	private String area;
	private String si_gun_gu;
	private String address;
	private String info;

	public StadiumDto() {

	}

	public String getStadium_code() {
		return stadium_code;
	}

	public void setStadium_code(String stadium_code) {
		this.stadium_code = stadium_code;
	}

	public String getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}

	public String getStadium_name() {
		return stadium_name;
	}

	public void setStadium_name(String stadium_name) {
		this.stadium_name = stadium_name;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getSi_gun_gu() {
		return si_gun_gu;
	}

	public void setSi_gun_gu(String si_gun_gu) {
		this.si_gun_gu = si_gun_gu;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "StadiumDto [stadium_code=" + stadium_code + ", admin_id=" + admin_id + ", stadium_name=" + stadium_name
				+ ", area=" + area + ", si_gun_gu=" + si_gun_gu + ", address=" + address + ", info=" + info + "]";
	}

}
