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

import com.sports.matching.dtos.Belonged_TeamDto;
import com.sports.matching.dtos.MembersDto;
import com.sports.matching.dtos.TeamDto;
import com.sports.matching.model.MemberShip_IService;

@Controller
public class HomePageController {

	private Logger log = LoggerFactory.getLogger(HomePageController.class);
	
	@Autowired
	MemberShip_IService service;
	
	@RequestMapping(value = "/MemberMyPage.do", method = RequestMethod.GET)
	public String myPage(Model model, HttpSession session) {
		log.info("마이페이지 {}");
		String member_id = (String)session.getAttribute("uEmail");
		System.out.println(member_id);
		List<Belonged_TeamDto> btdto = service.memberMypage(member_id);
		model.addAttribute("btdto", btdto);
		return "MemberMyPage";
	}
	@RequestMapping(value = "/withdraw.do", method = RequestMethod.POST)
	public String withdraw(HttpSession session, String member_id) {
		log.info("개인회원 탈퇴");
		MembersDto mdto = (MembersDto) session.getAttribute("uEmail");
		boolean isc = service.updateWithdraw(member_id);
		if(isc) {
			service.deleteMemberTeam(member_id);
		}else {
			return "MemberMyPage";
		}
		return "SearchPage";
	}
	
	@RequestMapping(value = "/delTeam.do", method = RequestMethod.GET)
	public String deleteBelongTeam(HttpSession session, String team_id) {
		log.info("마이페이지에서 소속팀 탈퇴");
		TeamDto Tdto = (TeamDto) session.getAttribute("tdto");
		boolean isc = service.deleteBelongedTeam(team_id);
		if(isc) {
			return "redirect:/MemberMyPage.do";
		}else {
			return "MemberMyPage";
		}
	}
	
	/**
	 * 마이페이지에서 소속팀 추가
	 * @param session
	 * @param team_id
	 * @return
	 */
	@RequestMapping(value = "/addTeam.do", method = RequestMethod.GET)
	public String addBelongteam(HttpSession session, String team_id) {
		
		return "";
		
	}
	
	
	@RequestMapping(value = "/MakeTeam.do",method = RequestMethod.GET)
	public String registTeamForm() {
		log.info("팀 창설(회원가입폼)");		
		return "RegistTeam";
	}
	
	
	@RequestMapping(value = "/idchk.do",method = RequestMethod.GET)
	public String idCheck(Model model, String team_id) {
		log.info("팀 아이디 중복체크 \t:{}",team_id);
		int n = service.duplicateTeamId(team_id);
		if(n>0) {
			model.addAttribute("isc", n==0?true:false);
		}else {
			model.addAttribute("isc", n==0?true:false);
		}
		return "RegistTeamIdChk";
	}
	
	@RequestMapping(value = "/Regist.do", method = RequestMethod.POST)
	public String registTeam(TeamDto TDto) {
		log.info("팀회원가입");
		boolean isc = service.registTeam(TDto);
		return isc?"redirect:/SearchPage.do":"redirect:/MakeTeam.do";
	}
	
	@RequestMapping(value = "/SearchPage.do", method = RequestMethod.GET)
	public String searchPage() {
		return "SearchPage";
	}
	
	@RequestMapping(value = "/TeamPage.do", method = RequestMethod.GET)
	public String teamPage() {
		return "teamPage";
	}
}
