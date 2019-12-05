package com.sports.matching.model;

import java.util.List;

import com.sports.matching.dtos.ScheduleDto;

public interface Schedule_IService {

	public boolean registerSchedule(ScheduleDto dto);
	public boolean homeRegisterSchedule(int schedule_id);
	public boolean homeCofirmSchedule(ScheduleDto dto);
	public boolean awayRegisterSchedule(int schedule_id);
	public boolean awayConfirmSchedule(ScheduleDto dto);
	
	public boolean homeCancel(int schedule_id);
	public boolean homeCancelConfirm(int schedule_id);
	public boolean awayCancel(int schedule_id);
	public boolean awayCancelConfirm(int schedule_id);
	public boolean deleteSchedule(int schedule_id);
	public boolean deleteMultiSchedule(int[] schedule_id);
	
	public boolean denyHomeSchedule(int schedule_id);
	public boolean denyAwaySchedule(int schedule_id);
	
	public List<String> selectAllSchedule(ScheduleDto dto);
	public List<ScheduleDto> selectSchedule(ScheduleDto dto);
}
