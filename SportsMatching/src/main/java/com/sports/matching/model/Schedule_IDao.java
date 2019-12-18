package com.sports.matching.model;

import java.util.List;

import com.sports.matching.dtos.ScheduleDto;

public interface Schedule_IDao {

	public boolean registerSchedule(ScheduleDto dto);
	public boolean homeRegisterSchedule(ScheduleDto dto);
	public boolean homeConfirmSchedule(ScheduleDto dto);
	public boolean awayRegisterSchedule(ScheduleDto dto);
	public boolean awayConfirmSchedule(ScheduleDto dto);
	
	public boolean homeCancel(int schedule_id);
	public boolean homeCancelConfirm(int schedule_id);
	public boolean awayCancel(int schedule_id);
	public boolean awayCancelConfirm(int schedule_id);
	public boolean deleteSchedule(ScheduleDto dto);
	
	public boolean denyHomeSchedule(int schedule_id);
	public boolean denyAwaySchedule(int schedule_id);
	
	public List<ScheduleDto> selectAllSchedule(ScheduleDto dto);
	public ScheduleDto selectSchedule(ScheduleDto dto);
	public List<ScheduleDto> selectRequestReservation(ScheduleDto dto);
	public List<ScheduleDto> selectRequestCancel(ScheduleDto dto);
	public List<ScheduleDto> selectAllReserved(ScheduleDto dto);
	
}
