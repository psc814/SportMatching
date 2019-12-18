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

import com.sports.matching.dtos.StadiumDto;
import com.sports.matching.model.Stadium_IService;

@Controller
public class StadiumController {

	@Autowired
	private Stadium_IService service;
	
	@ResponseBody
	@RequestMapping(value="/search.do", method = RequestMethod.POST)
	public Map<String, List<StadiumDto>> search(Model model, String condition) {
		List<StadiumDto> lists = service.searchStadium(condition);
		Map<String, List<StadiumDto>> map = new HashMap<String, List<StadiumDto>>();
		map.put("searchLists", lists);
		return map;
	}
	
}

