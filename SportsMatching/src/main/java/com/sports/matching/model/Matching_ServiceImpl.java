package com.sports.matching.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.sports.matching.dtos.MatchingCardDto;
import com.sports.matching.dtos.ScheduledMatchingDto;

public class Matching_ServiceImpl implements Matching_IService {

	@Autowired
	private Matching_IDao dao;
	
	@Override
	public List<MatchingCardDto> selectAllMatching() {
		return dao.selectAllMatching();
	}

	@Override
	public List<MatchingCardDto> searchMatching(String condition) {
		return searchMatching(condition);
	}

	@Override
	public List<ScheduledMatchingDto> selectMyMatching(String team_id) {
		return selectMyMatching(team_id);
	}

	@Override
	public boolean registMatchingCard(MatchingCardDto mcdto) {
		int row = dao.registMatchingCard(mcdto);
		return (row>0)?true:false;
	}

	@Override
	public boolean applyMatching(Map<String, String> map) {
		int row = dao.applyMatching(map);
		return (row>0)?true:false;
	}

	@Override
	public int selectRegistCount(String team_id) {
		return dao.selectRegistCount(team_id);
	}

	@Override
	public int selectApplyCount(String team_id) {
		return dao.selectApplyCount(team_id);
	}

	@Override
	@Transactional
	public boolean applySchduleMatching(int matching_number) {
		int accomplish = dao.modifyMatchingAccomplish(matching_number);
		int apply = dao.applySchduleMatching(matching_number);
		return (accomplish+apply)>0?true:false;
	}

	@Override
	public boolean deleteMatchingCard(int matching_number) {
		int row = dao.deleteMatchingCard(matching_number);
		return (row>0)?true:false;
	}

	@Override
	public int selectApplyMatching(int matching_number) {
		return dao.selectApplyMatching(matching_number);
	}

	@Override
	public boolean deleteApplyMatching(int matching_number) {
		int row = dao.deleteApplyMatching(matching_number);
		return (row>0)?true:false;
	}

	@Override
	public boolean modifyMatchingHistory(Map<String, String> map) {
		int row = dao.modifyMatchingHistory(map);
		return (row>0)?true:false;
	}

	@Override
	public boolean modifyNearMatching(Map<String, String> map) {
		int row = dao.modifyNearMatching(map);
		return (row>0)?true:false;
	}

}
