package com.sports.matching.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegistController {

	@RequestMapping(value = "/regForm.do", method = RequestMethod.POST)
	public String regForm() {
		return null;
	}
	
	
}
