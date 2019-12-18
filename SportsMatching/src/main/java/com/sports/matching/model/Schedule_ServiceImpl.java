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
	public boolean homeRegisterSchedule(ScheduleDto dto) {
		return dao.homeRegisterSchedule(dto);
	}

	@Override
	public boolean homeConfirmSchedule(ScheduleDto dto) {
		return dao.homeConfirmSchedule(dto);
	}

	@Override
	public boolean awayRegisterSchedule(ScheduleDto dto) {
		return dao.awayRegisterSchedule(dto);
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
	public boolean deleteSchedule(ScheduleDto dto) {
		return dao.deleteSchedule(dto);
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
	public List<ScheduleDto> selectAllSchedule(ScheduleDto dto) {
		return dao.selectAllSchedule(dto);
	}

	@Override
	public ScheduleDto selectSchedule(ScheduleDto dto) {
		return dao.selectSchedule(dto);
	}

	@Override
	public List<ScheduleDto> selectRequestReservation(ScheduleDto dto) {
		return dao.selectRequestReservation(dto);
	}

	@Override
	public List<ScheduleDto> selectAllReserved(ScheduleDto dto) {
		return dao.selectAllReserved(dto);
	}

	@Override
	public List<ScheduleDto> selectRequestCancel(ScheduleDto dto) {
		return dao.selectRequestCancel(dto);
	}
	

}
