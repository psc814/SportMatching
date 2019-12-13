package com.sports.matching.ctrl;

import java.util.Date;
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

import com.sports.matching.dtos.MemberBoardDTO;
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
	public String MemberBoardPage(Model model,HttpSession session) {
		logger.info("MemberBoardPage 멤버 게시판 페이지 이동  \t{}",new Date());
		

		
		
		
		return "MemberBoardPage";
	}
	
//	@RequestMapping(value = "/membarWritePage.do")
//	public String MembarWriteForm(Model model) {
//		logger.info("MembarWriteForm 멤버 게시글 작성 페이지 이동 \t{}",new Date());
//		
//		
//		return "MembarWritePage";
//	}
	
//	@RequestMapping(value = "/membarBoardWrite.do", method = RequestMethod.GET)
//	public String MembarBoardWrite(MemberBoardDTO mboarddto, Model model) {
//		logger.info("MembarBoardWrite 멤버 게시글 작성 \t{}", mboarddto);
//		boolean memeberBoardWrite = service.MembarBoardWrite(mboarddto);
//		model.addAttribute("write", memeberBoardWrite);
//		
//		return "MemberBoardPage";
//	}
	
	
	// 팀
	@RequestMapping(value = "/teamBoardPage.do", method = RequestMethod.GET)
	public String TeamBoardPage() {
		logger.info("TeamBoardPage 팀 게시판 페이지 이동 \t{}");
		
		RowNum_DTO rowNum = null;
		List<TeamBoardDTO> lists = service.TeamBoardList();
		
		
		return "TeamBoardPage";
	}
	
	
	
}
