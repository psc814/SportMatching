package com.sports.matching.model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sports.matching.dtos.PictureDto;
import com.sports.matching.dtos.StadiumDto;

@Repository
public class Stadium_DaoImpl implements Stadium_IDao {
	
	@Autowired
	private SqlSessionTemplate session;
	private final String NS = "com.sports.matching.stadium_mapper.";

	@Override
	public List<StadiumDto> searchStadium(String condition) {
		return session.selectList(NS+"searchStadium", condition);
	}

	@Override
	public StadiumDto selectDetailStadium(String stadium_code) {
		return session.selectOne(NS+"selectDetailStadium", stadium_code);
	}

	@Override
	public List<StadiumDto> selectMyStadium(String admin_id) {
		return session.selectList(NS+"selectMyStadium", admin_id);
	}

	@Override
	public int selectStadiumMonthStatistic(Map<String, String> map) {
		return session.selectOne(NS+"selectStadiumMonthStatistic", map);
	}

	@Override
	public int selectStadiumDayStatistic(Map<String, String> map) {
		return session.selectOne(NS+"selectStadiumDayStatistic", map);
	}

	@Override
	public int selectStadiumTimeStatistic(Map<String, String> map) {
		return session.selectOne(NS+"selectStadiumTimeStatistic", map);
	}

	@Override
	public int modifyStadiumInfo(StadiumDto stDto) {
		int row = session.update(NS+"modifyStadiumInfo", stDto);
		return row;
	}

	@Override
	public int modifyStadiumPicture(PictureDto ptDto) {
		int row = session.update(NS+"modifyStadiumPicture", ptDto);
		return row;
	}

	@Override
	public int modifyScore(Map<String, String> map) {
		int row = session.update(NS+"modifyScore", map);
		return row;
	}

	@Override
	public int selectReservationInfo(String stadium_code) {
		int count = session.selectOne(NS+"selectReservationInfo", stadium_code);
		return count;
	}


	@Override
	public int deleteStadiumPicture(String stadium_code) {
		int row = session.delete(NS+"deleteStadiumPicture", stadium_code);
		return row;
	}

	@Override
	public int deleteStadiumSchedule(String stadium_code) {
		int row = session.delete(NS+"deleteStadiumSchedule", stadium_code);
		return row;
	}

	@Override
	public int deleteStadium(String stadium_code) {
		int row = session.delete(NS+"deleteStadium", stadium_code);
		return row;
	}

	@Override
	public int registStadium(StadiumDto stDto) {
		int row = session.insert(NS+"registStadium", stDto);
		return row;
	}

}
