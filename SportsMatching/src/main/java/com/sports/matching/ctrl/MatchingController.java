package com.sports.matching.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@Autowired
	private Matching_IService service;
	
	@ResponseBody
	@RequestMapping(value="/matchingSearch.do", method = RequestMethod.POST)
	public Map<String, List<MatchingCardDto>> matchingSearch(Model model, String condition) {
		List<MatchingCardDto> lists = service.searchMatching(condition);
		Map<String, List<MatchingCardDto>> map = new HashMap<String, List<MatchingCardDto>>();
		map.put("searchLists", lists);
		return map;
	}
}
