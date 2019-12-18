package com.sports.matching.ctrl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sports.matching.dtos.Belonged_TeamDto;
import com.sports.matching.model.MemberShip_IService;

@Controller
public class TeamController {

	private Logger log = LoggerFactory.getLogger(TeamController.class);
	
	@Autowired
	private MemberShip_IService service;
	
	@RequestMapping(value = "/TeamInfo.do", method = RequestMethod.GET)
	public String teamInfo(String team_id, Belonged_TeamDto BTDto) {
		List<Belonged_TeamDto> lists = service.teamMemberList(team_id);
		
		return "TeamInfo";
	}

}
