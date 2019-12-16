package com.sports.matching.model;

import java.util.List;

import com.sports.matching.dtos.ScheduleDto;

public interface Schedule_IDao {

	public boolean registerSchedule(ScheduleDto dto);
	public boolean homeRegisterSchedule(ScheduleDto dto);
	public boolean homeConfirmSchedule(ScheduleDto dto);
	public boolean awayRegisterSchedule(int schedule_id);
	public boolean awayConfirmSchedule(ScheduleDto dto);
	
	public boolean homeCancel(int schedule_id);
	public boolean homeCancelConfirm(int schedule_id);
	public boolean awayCancel(int schedule_id);
	public boolean awayCancelConfirm(int schedule_id);
	public boolean deleteSchedule(ScheduleDto dto);
	
	public boolean denyHomeSchedule(int schedule_id);
	public boolean denyAwaySchedule(int schedule_id);
	
	public List<String> selectAllSchedule(ScheduleDto dto);
	public List<ScheduleDto> selectSchedule(ScheduleDto dto);
	public List<ScheduleDto> selectRequestReservation(ScheduleDto dto);
	
}
