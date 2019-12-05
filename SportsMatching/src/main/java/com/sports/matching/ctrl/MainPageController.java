package com.sports.matching.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainPageController {

	@RequestMapping(value = "/main.do", method = RequestMethod.GET)
	public String mainPage() {
		return "MainPage";
	}
	
//	@RequestMapping(value = "/showSchedule.do", method = RequestMethod.POST)
//	public String showSchedule() {
//		
//	}

}
