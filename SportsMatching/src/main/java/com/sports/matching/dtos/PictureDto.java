package com.sports.matching.dtos;

import java.io.Serializable;

public class PictureDto implements Serializable {

	private static final long serialVersionUID = 2748167194596263660L;
	
	private String stadium_code;
	private String image1;
	private String image2;
	private String image3;

	public PictureDto() {

	}

	public String getStadium_code() {
		return stadium_code;
	}

	public void setStadium_code(String stadium_code) {
		this.stadium_code = stadium_code;
	}

	public String getImage1() {
		return image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public String getImage2() {
		return image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	public String getImage3() {
		return image3;
	}

	public void setImage3(String image3) {
		this.image3 = image3;
	}

	@Override
	public String toString() {
		return "PictureDto [stadium_code=" + stadium_code + ", image1=" + image1 + ", image2=" + image2 + ", image3="
				+ image3 + "]";
	}

}
