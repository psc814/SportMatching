package com.sports.matching.ctrl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class MainPageController {

	private Logger logger = LoggerFactory.getLogger(MainPageController.class);
	
	@Autowired
	private Schedule_IService sc_service;
	
	@RequestMapping(value = "/main.do", method = RequestMethod.GET)
	public String mainPage() {
		logger.info("메인페이지로~~!");
		return "MainPage";
	}
	
	@RequestMapping(value = "/showSchedule.do", method = RequestMethod.POST)
	@ResponseBody
	public List<String> showSchedule(String game_date){
		logger.info("{}날짜의 스케쥴을 보여줘",game_date);
		ScheduleDto dto = new ScheduleDto();
		dto.setGame_date(game_date);
		dto.setStadium_code("SC0003");
		System.out.println(dto);
		List<String> scheduleList = sc_service.selectAllSchedule(dto);
		System.out.println(scheduleList);
		return scheduleList;
	}

}
