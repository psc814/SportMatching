package com.sports.matching.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sports.matching.dtos.Belonged_TeamDto;

import com.sports.matching.dtos.StatDto;
import com.sports.matching.dtos.TeamDto;
import com.sports.matching.dtos.Team_Stat_Dto;
import com.sports.matching.dtos.ScheduleDto;
import com.sports.matching.model.MemberShip_IService;
import com.sports.matching.model.Schedule_IService;

@Controller
public class TeamController {

	private Logger log = LoggerFactory.getLogger(TeamController.class);
	
	@Autowired
	private MemberShip_IService service;
	
	@Autowired
	private Schedule_IService sc_service;
	
	@RequestMapping(value = "/TeamInfo.do", method = RequestMethod.GET)
	public String teamInfo(Belonged_TeamDto BTDto,Model model,HttpSession session) {
		log.info("팀 정보 \t:{}");
		String team_id = (String) session.getAttribute("tdto");
		System.out.println(team_id);
		List<Belonged_TeamDto> lists = service.teamMemberList(team_id);
		model.addAttribute("lists", lists);
		Team_Stat_Dto tsdto = service.selectTeam(team_id);
		model.addAttribute("tsdto", tsdto);
		return "TeamInfo";
	}
	

	@RequestMapping(value = "/TeamManageMent.do", method = RequestMethod.GET)
	public String teamManageMent(HttpSession session, Model model, Belonged_TeamDto BTDto) {
		log.info("팀원관리");
		String team_id = (String) session.getAttribute("tdto");
		List<Belonged_TeamDto> lists = service.teamMemberList(team_id);
		model.addAttribute("lists", lists);
		return "TeamManageMent";
	}
	
	@RequestMapping(value = "/mutliDel.do", method = RequestMethod.POST)
	public String mutliDelMember(Model model, String[] chk) {
		log.info("팀에 등록된 회원 다중추방");
		Map<String, String[]> map = new HashMap<String, String[]>();
		map.put("member_id_", chk);
		boolean isc = service.teamMemberMultiDel(map);
		if(isc) {
			return "redirect:/TeamManageMent.do";
		}else {
			return "TeamManageMent";
		}
	}

	@RequestMapping(value = "/CancelRes.do", method = RequestMethod.GET)
	public String cancelReservation(HttpSession session, Model model) {
		String team_id = (String) session.getAttribute("tdto");
		ScheduleDto dto = new ScheduleDto();
		dto.setHome_team(team_id);
		dto.setAway_team(team_id);
		List<ScheduleDto> scLists = sc_service.selectAllReserved(dto);
		System.out.println(scLists);
		model.addAttribute("scLists", scLists);
		return "cancelReservation";
	}
	
	@RequestMapping(value = "/homecancel", method =RequestMethod.POST)
	@ResponseBody
	public boolean homecancel(String schedule_id) {
		log.info("아이디가 {}인 홈 취소신청",schedule_id);
		return sc_service.homeCancel(Integer.parseInt(schedule_id));
	}
	
	@RequestMapping(value = "/awaycancel", method =RequestMethod.POST)
	@ResponseBody
	public boolean awaycancel(String schedule_id) {
		log.info("아이디가 {}인 어웨이 취소신청",schedule_id);
		return sc_service.homeCancel(Integer.parseInt(schedule_id));

	}

}
