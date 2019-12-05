package com.sports.matching.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sports.matching.dtos.ScheduleDto;

@Service
public class Schedule_ServiceImpl implements Schedule_IService {

	@Autowired
	private Schedule_IDao dao;

	@Override
	public boolean registerSchedule(ScheduleDto dto) {
		return dao.registerSchedule(dto);
	}

	@Override
	public boolean homeRegisterSchedule(int schedule_id) {
		return dao.homeRegisterSchedule(schedule_id);
	}

	@Override
	public boolean homeCofirmSchedule(ScheduleDto dto) {
		return dao.homeCofirmSchedule(dto);
	}

	@Override
	public boolean awayRegisterSchedule(int schedule_id) {
		return dao.awayRegisterSchedule(schedule_id);
	}

	@Override
	public boolean awayConfirmSchedule(ScheduleDto dto) {
		return dao.awayConfirmSchedule(dto);
	}

	@Override
	public boolean homeCancel(int schedule_id) {
		return dao.homeCancel(schedule_id);
	}

	@Override
	public boolean homeCancelConfirm(int schedule_id) {
		return dao.homeCancelConfirm(schedule_id);
	}

	@Override
	public boolean awayCancel(int schedule_id) {
		return dao.awayCancel(schedule_id);
	}

	@Override
	public boolean awayCancelConfirm(int schedule_id) {
		return dao.awayCancelConfirm(schedule_id);
	}

	@Override
	public boolean deleteSchedule(int schedule_id) {
		return dao.deleteSchedule(schedule_id);
	}

	@Override
	public boolean deleteMultiSchedule(int[] schedule_id) {
		return dao.deleteMultiSchedule(schedule_id);
	}

	@Override
	public boolean denyHomeSchedule(int schedule_id) {
		return dao.denyHomeSchedule(schedule_id);
	}

	@Override
	public boolean denyAwaySchedule(int schedule_id) {
		return dao.denyAwaySchedule(schedule_id);
	}

	@Override
	public List<String> selectAllSchedule(ScheduleDto dto) {
		return dao.selectAllSchedule(dto);
	}

	@Override
	public List<ScheduleDto> selectSchedule(ScheduleDto dto) {
		return dao.selectSchedule(dto);
	}

}
