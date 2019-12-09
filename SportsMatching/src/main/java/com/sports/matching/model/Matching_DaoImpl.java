package com.sports.matching.model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.sports.matching.dtos.MatchingCardDto;
import com.sports.matching.dtos.ScheduledMatchingDto;

public class Matching_DaoImpl implements Matching_IDao {

	@Autowired
	private SqlSessionTemplate session;
	private final String NS = "com.sports.matching.matching_mapper.";
	
	@Override
	public List<MatchingCardDto> selectAllMatching() {
		return session.selectList(NS+"selectAllMatching");
	}

	@Override
	public List<MatchingCardDto> searchMatching(String condition) {
		return session.selectList(NS+"searchMatching", condition);
	}

	@Override
	public List<ScheduledMatchingDto> selectMyMatching(String team_id) {
		return session.selectList(NS+"selectMyMatching", team_id);
	}

	@Override
	public int registMatchingCard(MatchingCardDto mcdto) {
		return session.insert(NS+"registMatchingCard", mcdto);
	}

	@Override
	public int applyMatching(Map<String, String> map) {
		return session.update(NS+"applyMatching", map);
	}

	@Override
	public int selectRegistCount(String team_id) {
		return session.selectOne(NS+"selectRegistCount", team_id);
	}

	@Override
	public int selectApplyCount(String team_id) {
		return session.selectOne(NS+"selectApplyCount", team_id);
	}

	@Override
	public int modifyMatchingAccomplish(int matching_number) {
		return session.update(NS+"modifyMatchingAccomplish", matching_number);
	}

	@Override
	public int applySchduleMatching(int matching_number) {
		return session.insert(NS+"applySchduleMatching", matching_number);
	}

	@Override
	public int deleteMatchingCard(int matching_number) {
		return session.delete(NS+"deleteMatchingCard", matching_number);
	}

	@Override
	public int selectApplyMatching(int matching_number) {
		return session.selectOne(NS+"selectApplyMatching", matching_number);
	}

	@Override
	public int deleteApplyMatching(int matching_number) {
		return session.update(NS+"deleteApplyMatching", matching_number);
	}

	@Override
	public int modifyMatchingHistory(Map<String, String> map) {
		return session.update(NS+"modifyMatchingHistory", map);
	}

	@Override
	public int modifyNearMatching(Map<String, String> map) {
		return session.update(NS+"modifyNearMatching", map);
	}

}
