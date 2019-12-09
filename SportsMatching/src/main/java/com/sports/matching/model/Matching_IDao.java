package com.sports.matching.model;

import java.util.List;
import java.util.Map;

import com.sports.matching.dtos.MatchingCardDto;
import com.sports.matching.dtos.ScheduledMatchingDto;

public interface Matching_IDao {
	
	public List<MatchingCardDto> selectAllMatching();

	public List<MatchingCardDto> searchMatching(String condition);
	
	public List<ScheduledMatchingDto> selectMyMatching(String team_id);

	public int registMatchingCard(MatchingCardDto mcdto);

	public int applyMatching(Map<String, String> map);

	public int selectRegistCount(String team_id);

	public int selectApplyCount(String team_id);

	public int modifyMatchingAccomplish(int matching_number);

	public int applySchduleMatching(int matching_number);

	public int deleteMatchingCard(int matching_number);

	public int selectApplyMatching(int matching_number);

	public int deleteApplyMatching(int matching_number);

	public int modifyMatchingHistory(Map<String, String> map);

	public int modifyNearMatching(Map<String, String> map);

}
