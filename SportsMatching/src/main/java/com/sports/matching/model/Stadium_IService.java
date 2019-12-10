package com.sports.matching.model;

import java.util.List;
import java.util.Map;

import com.sports.matching.dtos.PictureDto;
import com.sports.matching.dtos.StadiumDto;

public interface Stadium_IService {

	public List<StadiumDto> searchStadium(String condition);

	public StadiumDto selectDetailStadium(String stadium_code);

	public List<StadiumDto> selectMyStadium(String admin_id);

	public int selectStadiumMonthStatistic(Map<String, String> map);

	public int selectStadiumDayStatistic(Map<String, String> map);

	public int selectStadiumTimeStatistic(Map<String, String> map);

	public boolean modifyStadium(StadiumDto stDto, PictureDto ptDto);

	public boolean modifyScore(Map<String, String> map);

	public int selectReservationInfo(String stadium_code);

	public int adminLogin(Map<String, String> map);
	
	public boolean deleteStadium(String stadium_code);

	public boolean registStadium(StadiumDto stDto);

}
