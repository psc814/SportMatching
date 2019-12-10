package com.sports.matching.dtos;

import java.io.Serializable;

public class ScheduledMatchingDto implements Serializable {

	private static final long serialVersionUID = -1568805712129557971L;

	private String matching_number;
	private String comments;
	private String home_score;
	private String away_score;

	public ScheduledMatchingDto() {

	}

	@Override
	public String toString() {
		return "ScheduledMatchingDto [matching_number=" + matching_number + ", comments=" + comments + ", home_score="
				+ home_score + ", away_score=" + away_score + "]";
	}

	public String getMatching_number() {
		return matching_number;
	}

	public void setMatching_number(String matching_number) {
		this.matching_number = matching_number;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getHome_score() {
		return home_score;
	}

	public void setHome_score(String home_score) {
		this.home_score = home_score;
	}

	public String getAway_score() {
		return away_score;
	}

	public void setAway_score(String away_score) {
		this.away_score = away_score;
	}

}
