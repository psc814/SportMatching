package com.sports.matching.ctrl;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sports.matching.dtos.ScheduleDto;
import com.sports.matching.dtos.StadiumAdminDto;
import com.sports.matching.dtos.StadiumDto;
import com.sports.matching.model.MemberShip_IService;
import com.sports.matching.model.Schedule_IService;

@Controller
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	Schedule_IService sc_service;
	@Autowired
	MemberShip_IService service;

	@RequestMapping(value = "/AdminRegisterSchedulePage.do", method =  RequestMethod.GET)
	public String AdminMyPage() {
		logger.info("관리자 마이페이지 입장");
		return "AdminRegisterSchedulePage";
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
	
	@RequestMapping(value = "/confirmReservation.do",method = RequestMethod.POST)
	@ResponseBody
	public boolean confirmReservation(String schedule_id,String home_team, String away_team) {
		logger.info("관리자가 스케쥴 아이디가 {}인 예약을 확정",schedule_id);
		ScheduleDto dto = new ScheduleDto();
		dto.setSchedule_id(Integer.parseInt(schedule_id));
		System.out.println(dto);
		if(home_team.equals("null")) {
			dto.setHome_team("피닉스");
			return sc_service.homeConfirmSchedule(dto);
		}else {
			dto.setAway_team("피닉스");
			return sc_service.awayConfirmSchedule(dto);
		}
	}
	
	@RequestMapping(value = "/denyReservation.do", method = RequestMethod.POST)
	@ResponseBody
	public boolean denyReservation(String schedule_id,String home_team, String away_team) {
		logger.info("관리자가 스케쥴 아이디가 {}인 예약을 거절",schedule_id);
		if(home_team.equals("null")) {
			return sc_service.denyHomeSchedule(Integer.parseInt(schedule_id));
		}else {
			return sc_service.denyAwaySchedule(Integer.parseInt(schedule_id));
		}
		
	}
	
	@RequestMapping(value = "/registSchedule.do", method = RequestMethod.POST)
	@ResponseBody
	public boolean registSchedule(String game_date, String time) {
		logger.info("{}날짜, {}시간의 일정을 등록",game_date, time);
		ScheduleDto dto = new ScheduleDto();
		String[] timeArray = time.split(",");
		String date = "";
		int cnt = 0;
		dto.setStadium_code("SC0003");
		for (int i = 1; i < timeArray.length; i++) {
			if(Integer.parseInt(timeArray[i]) < 10) {
				date = game_date+"0"+timeArray[i];
				dto.setGame_date(date);
			}else {
				date = game_date+timeArray[i];
				dto.setGame_date(date);
			}
			sc_service.registerSchedule(dto);
			cnt++;
		}
		return (cnt == timeArray.length-1)?true:false;
	}
	
	@RequestMapping(value = "/deleteSchedule.do", method = RequestMethod.POST)
	@ResponseBody
	public boolean deleteSchedule(String game_date, String time) {
		logger.info("{}날짜, {}시간의 일정을 삭제",game_date, time);
		ScheduleDto dto = new ScheduleDto();
		String[] timeArray = time.split(",");
		String date = "";
		int cnt = 0;
		dto.setStadium_code("SC0003");
		for (int i = 1; i < timeArray.length; i++) {
			if(Integer.parseInt(timeArray[i]) < 10) {
				date = game_date+"0"+timeArray[i];
				dto.setGame_date(date);
			}else {
				date = game_date+timeArray[i];
				dto.setGame_date(date);
			}
			sc_service.deleteSchedule(dto);
			cnt++;
		}
		return (cnt == timeArray.length-1)?true:false;
	}
	
	@RequestMapping(value = "/showRequestCancel.do",method = RequestMethod.POST)
	@ResponseBody
	public List<ScheduleDto> showRequestCancel(String game_date) {
		logger.info("관리자가 {} 날짜로 요청된 취소를 조회",game_date);
		ScheduleDto dto = new ScheduleDto();
		dto.setGame_date(game_date);
		dto.setStadium_code("SC0003");
		List<ScheduleDto> lists = sc_service.selectRequestCancel(dto);
		System.out.println(lists);
		return lists;
	}
	
	@RequestMapping(value = "/confirmCancel.do", method = RequestMethod.POST)
	@ResponseBody
	public boolean confirmCancel(String schedule_id, String home_cancel, String away_cancel) {
		if(home_cancel.equals("N")) {
			return sc_service.homeCancelConfirm(Integer.parseInt(schedule_id));
		}
		if(away_cancel.equals("N")) {
			return sc_service.awayCancelConfirm(Integer.parseInt(schedule_id));
		}
		return false;
	}
	@RequestMapping(value = "/denyCancel.do", method = RequestMethod.POST)
	@ResponseBody
	public boolean denyCancel(String schedule_id, String home_cancel, String away_cancel) {
		if(home_cancel.equals("N")) {
			return sc_service.homeCancelConfirm(Integer.parseInt(schedule_id));
		}
		if(away_cancel.equals("N")) {
			return sc_service.awayCancelConfirm(Integer.parseInt(schedule_id));
		}
		return false;
	}
	
	@RequestMapping(value = "/changePw.do")
	public String changePasswordPage() {
		return "changePassword";
	}
	
	@RequestMapping(value = "/modifyPW.do", method = RequestMethod.GET)
	public String modifyPW(StadiumAdminDto SADto, HttpSession session) {
		logger.info("관리자 비밀번호 변경");
		session.getAttribute("sadto");
		boolean isc = service.modifyAdminPassword(SADto);
		return isc?"redirect:/loginForm.do":"redirect:/modifyPW.do";
	}
	
}