package com.sports.matching.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sports.matching.dtos.StadiumDto;
import com.sports.matching.model.Stadium_IService;

@Controller
public class StadiumController {

	private Logger log = LoggerFactory.getLogger(StadiumController.class);
	@Autowired
	private Stadium_IService service;
	
	@ResponseBody
	@RequestMapping(value="/stadiumSearch.do", method = RequestMethod.POST)
	public Map<String, List<StadiumDto>> stadiumSearch(Model model, String condition) {
		log.info("stadiumSearch 진입");
		List<StadiumDto> lists = service.searchStadium(condition);
		Map<String, List<StadiumDto>> map = new HashMap<String, List<StadiumDto>>();
		map.put("searchLists", lists);
		return map;
	}
	
	
}






















