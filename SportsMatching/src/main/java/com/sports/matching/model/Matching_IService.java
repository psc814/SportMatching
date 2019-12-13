package com.sports.matching.model;

import java.util.List;
import java.util.Map;

import com.sports.matching.dtos.MatchingCardDto;
import com.sports.matching.dtos.ScheduledMatchingDto;

public interface Matching_IService {

	public List<MatchingCardDto> selectAllMatching();

	public List<MatchingCardDto> searchMatching(String condition);
	
	public List<ScheduledMatchingDto> selectMyMatching(String team_id);

	public boolean registMatchingCard(MatchingCardDto mcdto);

	public boolean applyMatching(Map<String, String> map);

	public int selectRegistCount(String team_id);

	public int selectApplyCount(String team_id);
	
	public boolean applySchduleMatching(int matching_number);

	public boolean deleteMatchingCard(int matching_number);

	public int selectApplyMatching(int matching_number);

	public boolean deleteApplyMatching(int matching_number);

	public boolean modifyMatchingHistory(Map<String, String> map);

	public boolean modifyNearMatching(Map<String, String> map);

}
