package com.sports.matching.ctrl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sports.matching.dtos.ScheduleDto;
import com.sports.matching.model.Schedule_IService;

@Controller
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	Schedule_IService sc_service;

	@RequestMapping(value = "/AdminMyPage.do", method =  RequestMethod.GET)
	public String AdminMyPage() {
		logger.info("관리자 마이페이지 입장");
		return "AdminMyPage";
	}
	
	@RequestMapping(value = "/AdminReservation.do",method = RequestMethod.GET)
	public String AdminReservation() {
		logger.info("관리자 예약승인 페이지 입장");
		return "AdminReservationPage";
	}
	
	@RequestMapping(value = "/AdminCancel.do",method = RequestMethod.GET)
	public String AdminCancel() {
		logger.info("관리자 예약 취소 페이지 입장");
		return "AdminCancelPage";
	}
	
	@RequestMapping(value = "/showRequestReservation.do",method = RequestMethod.POST)
	@ResponseBody
	public List<ScheduleDto> showRequestReservation(String game_date) {
		logger.info("관리자가 {} 날짜로 요청된 예약을 조회",game_date);
		ScheduleDto dto = new ScheduleDto();
		dto.setGame_date(game_date);
		dto.setStadium_code("SC0003");
		List<ScheduleDto> lists = sc_service.selectRequestReservation(dto);
		return lists;
	}
	
//	@RequestMapping(value = "/confirmReservation.do",method = RequestMethod.POST)
//	@ResponseBody
//	public List<ScheduleDto> confirmReservation(String schedule_id) {
//		logger.info("관리자가 스케쥴 아이디가 {}인 예약을 확정",schedule_id);
//		return lists;
//	}
	
	

}
