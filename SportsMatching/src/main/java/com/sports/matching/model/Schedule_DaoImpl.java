package com.sports.matching.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sports.matching.dtos.ScheduleDto;

@Repository
public class Schedule_DaoImpl implements Schedule_IDao {

	private Logger logger = LoggerFactory.getLogger(Schedule_DaoImpl.class);
	private final String NS = "com.sports.matching.Schedule_Mapper.";

	@Autowired
	private SqlSessionTemplate session;

	@Override
	public boolean registerSchedule(ScheduleDto dto) {
		logger.info("관리자 일정 등록");
		int n = session.insert(NS + "registerSchedule", dto);
		return (n > 0) ? true : false;
	}

	@Override
	public boolean homeRegisterSchedule(ScheduleDto dto) {
		logger.info("홈팀 일정 등록 신청");
		int n = session.update(NS + "homeRegisterSchedule", dto);
		return (n > 0) ? true : false;
	}

	@Override
	public boolean homeConfirmSchedule(ScheduleDto dto) {
		logger.info("홈팀 최종 등록");
		int n = session.update(NS + "homeConfirmSchedule", dto);
		return (n > 0) ? true : false;
	}

	@Override
	public boolean awayRegisterSchedule(int schedule_id) {
		logger.info("어웨이팀 일정 등록 신청");
		int n = session.update(NS + "awayRegisterSchedule", schedule_id);
		return (n > 0) ? true : false;
	}

	@Override
	public boolean awayConfirmSchedule(ScheduleDto dto) {
		logger.info("어웨이팀 최종 등록");
		int n = session.update(NS + "awayConfirmSchedule", dto);
		return (n > 0) ? true : false;
	}

	@Override
	public boolean homeCancel(int schedule_id) {
		logger.info("홈팀 일정 취소 신청");
		int n = session.update(NS + "homeCancel", schedule_id);
		return (n > 0) ? true : false;
	}

	@Override
	public boolean homeCancelConfirm(int schedule_id) {
		logger.info("홈팀 최종 취소");
		int n = session.update(NS + "homeCancelConfirm", schedule_id);
		return (n > 0) ? true : false;
	}

	@Override
	public boolean awayCancel(int schedule_id) {
		logger.info("어웨이팀 일정 취소 신청");
		int n = session.update(NS + "awayCancel", schedule_id);
		return (n > 0) ? true : false;
	}

	@Override
	public boolean awayCancelConfirm(int schedule_id) {
		logger.info("어웨이팀 최종 취소");
		int n = session.update(NS + "awayCancelConfirm", schedule_id);
		return (n > 0) ? true : false;
	}

	@Override
	public boolean deleteSchedule(int schedule_id) {
		logger.info("관리자 일정 삭제");
		int n = session.delete(NS + "deleteSchedule", schedule_id);
		return (n > 0) ? true : false;
	}

	@Override
	public boolean deleteMultiSchedule(int[] schedule_id) {
		logger.info("관리자 일정 다중 삭제");
		int n = session.delete(NS + "deleteMultiSchedule", schedule_id);
		return (n > 0) ? true : false;
	}

	@Override
	public boolean denyHomeSchedule(int schedule_id) {
		logger.info("홈팀 신청 거절");
		int n = session.update(NS + "denyHomeSchedule", schedule_id);
		return (n > 0) ? true : false;
	}

	@Override
	public boolean denyAwaySchedule(int schedule_id) {
		logger.info("어웨이팀 신청 거절");
		int n = session.update(NS + "denyAwaySchedule", schedule_id);
		return (n > 0) ? true : false;
	}

	@Override
	public List<String> selectAllSchedule(ScheduleDto dto) {
		logger.info("일정 전체 조회-----{}", dto);
		return session.selectList(NS+"selectAllSchedule", dto);
	}

	@Override
	public List<ScheduleDto> selectSchedule(ScheduleDto dto) {
		logger.info("일정 상세 조회");
		return session.selectList(NS+"selectSchedule", dto);
	}

	@Override
	public List<ScheduleDto> selectRequestReservation(ScheduleDto dto) {
		logger.info("관리자가 요청된 예약 조회");
		return session.selectList(NS+"selectRequestReservation", dto);
	}

}
