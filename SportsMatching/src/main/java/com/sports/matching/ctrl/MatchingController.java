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

import com.sports.matching.dtos.MatchingCardDto;
import com.sports.matching.model.Matching_IService;

@Controller
public class MatchingController {

	private Logger log = LoggerFactory.getLogger(StadiumController.class);
	@Autowired
	private Matching_IService service;
	
	@ResponseBody
	@RequestMapping(value="/matchingSearch.do", method = RequestMethod.POST)
	public Map<String, List<MatchingCardDto>> matchingSearch(Model model, String condition) {
		log.info("matchingSearch 진입");
		List<MatchingCardDto> lists = service.searchMatching(condition);
		System.out.println(lists);
		Map<String, List<MatchingCardDto>> map = new HashMap<String, List<MatchingCardDto>>();
		map.put("searchLists", lists);
		return map;
	}
	
	@RequestMapping(value="/applyForm.do", method = RequestMethod.GET)
	public String applyForm(Model model, String matching_number, HttpSession session) {
		log.info("applyForm 진입 {}", matching_number);
		String team_id = (String)session.getAttribute("tdto");
		int appliedCount = service.selectApplyCount(team_id);
		System.out.println(appliedCount);
		if(appliedCount > 3) {
			return "errorApply";
		}else {
			model.addAttribute("matching_number", matching_number);
			return "MatchingApply";			
		}
	}
	@RequestMapping(value="/matchingApply.do", method = RequestMethod.GET)
	public String matchingApply(HttpSession session, Model model, MatchingCardDto mcdto, String matching_number) {
		log.info("matchingApply 진입 {}", mcdto);
		mcdto.setMatching_number(Integer.parseInt(matching_number));
		mcdto.setApplied_team_id((String)session.getAttribute("tdto"));
		boolean isc = service.applyMatching(mcdto);
		System.out.println(isc);
		return "SearchPage";
	}
}
