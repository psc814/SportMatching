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
}
