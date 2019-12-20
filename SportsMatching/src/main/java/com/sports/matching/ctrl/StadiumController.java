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

import com.sports.matching.dtos.StadiumAdminDto;
import com.sports.matching.dtos.StadiumDto;
import com.sports.matching.model.MemberShip_IService;
import com.sports.matching.model.Stadium_IService;

@Controller
public class StadiumController {

	private Logger log = LoggerFactory.getLogger(StadiumController.class);
	@Autowired
	private Stadium_IService service;
	@Autowired
	private MemberShip_IService mb_service;
	
	@ResponseBody
	@RequestMapping(value="/stadiumSearch.do", method = RequestMethod.POST)
	public Map<String, List<StadiumDto>> stadiumSearch(Model model, String condition) {
		log.info("stadiumSearch 진입");
		List<StadiumDto> lists = service.searchStadium(condition);
		Map<String, List<StadiumDto>> map = new HashMap<String, List<StadiumDto>>();
		map.put("searchLists", lists);
		return map;
	}
	
	@RequestMapping(value="/selectMyStadium.do", method = RequestMethod.GET)
	public String selectMyStadium(HttpSession session, Model model, int page) {
		log.info("selectMyStadium 진입: {}", page);
		if(page == 0) {
			page = 1;
		}
		String admin_id = (String) session.getAttribute("sadto");
		List<StadiumDto> lists = service.selectMyStadium(admin_id);
		model.addAttribute("stadiumLists", lists);
		model.addAttribute("page", page);
		return "AdminMyPage";
	}
	
	@RequestMapping(value = "/loginCheck.do", method = RequestMethod.GET)
    public String loginCheck(Model model, HttpSession session, StadiumAdminDto SADto, String stadium_code) {
    	log.info("loginCheck \t:{}", stadium_code);
    	int reservationGame = service.selectReservationInfo(stadium_code);
    	if(reservationGame > 0) {
    		return "errorApply";
    	}else {
    		Map<String, String> map = new HashMap<String, String>();
    		map.put("admin_id", SADto.getAdmin_id());
    		map.put("admin_pw", SADto.getAdmin_pw());
    		StadiumAdminDto sadto = mb_service.adminLogin(map);
    		if(sadto != null && sadto.equals(session.getAttribute("sadto"))) {
    			service.deleteStadium(stadium_code);
    		}
    		model.addAttribute("page", 1);
    		return "redirect:/selectMyStadium.do";
    	}
    	
    }
	
	
	
	
	
}






















