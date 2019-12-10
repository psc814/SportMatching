package com.sports.matching.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sports.matching.dtos.PictureDto;
import com.sports.matching.dtos.StadiumDto;

@Service
public class Stadium_ServiceImpl implements Stadium_IService {
	
	@Autowired
	Stadium_IDao dao;

	@Override
	public List<StadiumDto> searchStadium(String condition) {
		return dao.searchStadium(condition);
	}

	@Override
	public StadiumDto selectDetailStadium(String stadium_code) {
		return dao.selectDetailStadium(stadium_code);
	}

	@Override
	public List<StadiumDto> selectMyStadium(String admin_id) {
		return dao.selectMyStadium(admin_id);
	}

	@Override
	public int selectStadiumMonthStatistic(Map<String, String> map) {
		return dao.selectStadiumMonthStatistic(map);
	}

	@Override
	public int selectStadiumDayStatistic(Map<String, String> map) {
		return dao.selectStadiumDayStatistic(map);
	}

	@Override
	public int selectStadiumTimeStatistic(Map<String, String> map) {
		return dao.selectStadiumTimeStatistic(map);
	}

	@Override
	@Transactional
	public boolean modifyStadium(StadiumDto stDto, PictureDto ptDto) {
		int rowInfo = dao.modifyStadiumInfo(stDto);
		int rowPicture = dao.modifyStadiumPicture(ptDto);
		return (rowInfo+rowPicture)>0?true:false;
	}

	@Override
	public boolean modifyScore(Map<String, String> map) {
		int row = dao.modifyScore(map);
		return (row>0)?true:false;
	}

	@Override
	public int selectReservationInfo(String stadium_code) {
		return dao.selectReservationInfo(stadium_code);
	}

	@Override
	public int adminLogin(Map<String, String> map) {
		return dao.adminLogin(map);
	}

	@Override
	@Transactional
	public boolean deleteStadium(String stadium_code) {
		int rowPicture = dao.deleteStadiumPicture(stadium_code);
		int rowSchedule = dao.deleteStadiumSchedule(stadium_code);
		int row = dao.deleteStadium(stadium_code);
		return (rowPicture+rowSchedule+row)>0?true:false;
	}

	@Override
	public boolean registStadium(StadiumDto stDto) {
		int row = dao.registStadium(stDto);
		return (row>0)?true:false;
	}

}
