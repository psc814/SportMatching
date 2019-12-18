package com.sports.matching.ctrl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sports.matching.dtos.MemberBoardDTO;
import com.sports.matching.dtos.MembersDto;
import com.sports.matching.dtos.RowNum_DTO;
import com.sports.matching.dtos.TeamBoardDTO;
import com.sports.matching.model.Board_IService;

@Controller
public class BoardController {
	
	
	Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private Board_IService service;
	
	
	//멤버
	
	@RequestMapping(value = "/memberBoardPage.do", method = RequestMethod.GET)
	public String MemberBoardPage(Model model, HttpSession session,Map<String, String> map) {
		logger.info("MemberBoardPage 멤버 게시판 페이지 이동  \t{}",new Date());
		map.put("category_code", "MB001");
		map.put("start", "1");
		map.put("end", "15");
		logger.info("map 받아오는 값 확인 \t{}",map);
		List<MemberBoardDTO> lists = service.MemberBoardList(map);
		logger.info("멤버 보드 Lists 에서 받아오는 값 확인 \t{}",lists);
		model.addAttribute("MBL", lists);
		
		
		return "MemberBoardPage";
	}
	
	
	
	@RequestMapping(value = "/memberWritePage.do")
	public String MemberWriteForm(Model model) {
		logger.info("MemberWriteForm 멤버 게시글 작성 페이지 이동 \t{}",new Date());
		
		return "MemberWritePage";
	}
	
	@RequestMapping(value = "/memberBoardWrite.do", method = RequestMethod.GET)
	public String MemberBoardWrite(MemberBoardDTO mboarddto, Model model) {
		logger.info("MemberBoardWrite 멤버 게시글 작성 \t{}", mboarddto);
		boolean memeberBoardWrite = service.MembarBoardWrite(mboarddto);
		model.addAttribute("MbWDto", memeberBoardWrite);
		return "MemberBoardPage";
	}
	
	@RequestMapping(value = "/memberBoardDetailPage.do", method = RequestMethod.GET)
	public String MemberBoardDetail(String seq, Model model) {
		logger.info("MemberBoardDetail 멤버 게시글 상세 조회 \t{}", seq);
		MemberBoardDTO MDetail = service.MemberBoardDetail(seq);
		model.addAttribute("MDetail", MDetail);
		
		return "MemberBoardDetailPage";
	}
	
	@RequestMapping(value = "/memberBoardModifyPage.do", method = RequestMethod.POST)
	public String MemberBoardModifyPage(String seq, Model model) {
		logger.info("MemberBoardModify 멤버 게시글 수정 페이지 이동 \t{}", new Date());
		logger.info("요청 받은 SEQ 값 \t{}",seq);
		MemberBoardDTO MemberModifydto = service.MemberBoardDetail(seq);
		model.addAttribute("MmFyDto", MemberModifydto);
		
		return "MemberBoardModifyPage";
	}
	
	@RequestMapping(value = "/memberBoardModify.do", method = RequestMethod.POST)
	public String MemberBoardModify(MemberBoardDTO mboarddto,Model model) {
		logger.info("MemberBoardModify 멤버 게시글 수정");
		boolean isc = service.MemberBoardModify(mboarddto);
		
		return isc?"redirect:/memberBoardDetailPage.do":"/memberBoardModifyPage.do";
	}
	
	
	// 팀
	@RequestMapping(value = "/teamBoardPage.do", method = RequestMethod.GET)
	public String TeamBoardPage() {
		logger.info("TeamBoardPage 팀 게시판 페이지 이동 \t{}");
		return "TeamBoardPage";
	}
	
	
	
}
