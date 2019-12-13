package com.sports.matching.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sports.matching.model.Stadium_IService;

@Controller
public class StadiumController {

	@Autowired
	private Stadium_IService service;
	
	@ResponseBody
	@RequestMapping(value="/search.do", method = RequestMethod.POST)
	public String search(String id) {
		
		return id;
	}
	
}
