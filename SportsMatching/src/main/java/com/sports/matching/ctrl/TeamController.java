package com.sports.matching.ctrl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String teamInfo(Belonged_TeamDto BTDto,Model model,HttpSession session) {
		log.info("팀 정보 \t:{}");
		String team_id = (String) session.getAttribute("tdto");
		System.out.println(team_id);
		List<Belonged_TeamDto> lists = service.teamMemberList(team_id);
		model.addAttribute("lists", lists);
		return "TeamInfo";
	}

}
