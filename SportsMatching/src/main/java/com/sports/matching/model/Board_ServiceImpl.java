package com.sports.matching.model;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sports.matching.dtos.MemberBoardDTO;
import com.sports.matching.dtos.MemberReplyDTO;
import com.sports.matching.dtos.RowNum_DTO;
import com.sports.matching.dtos.TeamBoardDTO;
import com.sports.matching.dtos.TeamReplyDTO;

@Service
public class Board_ServiceImpl implements Board_IService {

	private Logger logger = LoggerFactory.getLogger(Board_IService.class);
	
	@Autowired
	private Board_IDao dao;
	
	
	
	// 게시글 조회
	@Override
	/**
	 * 멤버 게시글 조회
	 */
	public List<MemberBoardDTO> MemberBoardList() {
		logger.info("MemberBoardList 멤버 게시글 조회");
		
		return dao.MemberBoardList();
	}
	

	@Override
	/**
	 * 팀 게시글 조회
	 */
	public List<TeamBoardDTO> TeamBoardList() {
		logger.info("TeamBoardList 팀 게시글 조회");
		return dao.TeamBoardList();
	}
	
	@Override
	/**
	 * 멤버 게시글 상세 조회
	 */
	public MemberBoardDTO MemberBoardDetail(String member_board_seq) {
		logger.info("MemberBoardDetail 멤버 게시글 상세 조회");
		return dao.MemberBoardDetail(member_board_seq);
	}

	@Override
	/**
	 * 팀 게시글 상세 조회
	 */
	public TeamBoardDTO TeamBoardDetail(String team_board_seq) {
		logger.info("TeamBoardDetail 팀 게시글 상세 조회");
		return dao.TeamBoardDetail(team_board_seq);
	}

	@Override
	/**
	 * 멤버 게시글 댓글 조회
	 */
	public MemberReplyDTO DetailMemberReply(String reply_seq) {
		logger.info("DetailMemberReply 멤버 게시글 댓글 조회");
		return dao.DetailMemberReply(reply_seq);
	}

	@Override
	/**
	 * 팀 게시글 댓글 조회
	 */
	public TeamReplyDTO DetailTeamReply(String reply_seq) {
		logger.info("DetailTeamReply 팀 게시글 댓글 조회");
		return dao.DetailTeamReply(reply_seq);
	}


	@Override
	/**
	 * 멤버 게시판 상세글 조회수 증가
	 */
	public boolean MemberCountBoard(String member_board_seq) {
		logger.info("MemberCountBoard 멤버 게시판 상세글 조회수 증가");
		return dao.MemberCountBoard(member_board_seq);
	}

	@Override
	/**
	 * 팀 게시판 상세글 조회수 증가
	 */
	public boolean TeamCountBoard(String team_board_seq) {
		logger.info("TeamCountBoard 팀 게시판 상세글 조회수 증가");
		return dao.TeamCountBoard(team_board_seq);
	}

	
	
	//게시글 작성
	@Override
	/**
	 * 멤버 게시글 작성
	 */
	public boolean MembarBoardWrite(MemberBoardDTO mboarddto) {
		logger.info("MembarBoardWrite 멤버 게시글 작성");
		return dao.MembarBoardWrite(mboarddto);
	}

	@Override
	/**
	 * 팀 게시글 작성
	 */
	public boolean TeamBoardWrite(TeamBoardDTO tboarddto) {
		logger.info("TeamBoardWrite 팀 게시글 작성");
		return dao.TeamBoardWrite(tboarddto);

	}

	@Override
	/**
	 * 멤버 게시판 댓글 작성
	 */
	public boolean MemberWriteReply(MemberReplyDTO mreplydto) {
		logger.info("MemberWriteReply 멤버 게시판 댓글 작성");
		return dao.MemberWriteReply(mreplydto);
	}

	@Override
	/**
	 * 팀 게시판 댓글 작성
	 */
	public boolean TeamWriteReply(TeamReplyDTO treplydto) {
		logger.info("TeamWriteReply 팀 게시판 댓글 작성");
		return dao.TeamWriteReply(treplydto);
	}
	
	
	
	//게시글 수정
	@Override
	/**
	 * 멤버 게시글 수정
	 */
	public boolean MemberBoardModify(MemberBoardDTO mboarddto) {
		logger.info("MemberBoardModify 멤버 게시글 수정");
		return dao.MemberBoardModify(mboarddto);
	}

	@Override
	/**
	 * 팀 게시글 수정
	 */
	public boolean TeamBoarModify(TeamBoardDTO tboarddto) {
		logger.info("TeamBoarModify 팀 게시글 수정");
		return dao.TeamBoarModify(tboarddto);
	}
	
	@Override
	/**
	 * 멤버 게시글 댓글 수정
	 */
	public boolean MemReplyModify(MemberReplyDTO mreplydto) {
		logger.info("MemReplyModify");
		return dao.MemReplyModify(mreplydto);
	}

	@Override
	/**
	 * 팀 게시글 댓글 수정
	 */
	public boolean TeamReplyModify(TeamReplyDTO treplydto) {
		logger.info("TeamReplyModify 팀 게시글 댓글 수정");
		return dao.TeamReplyModify(treplydto);
	}
	
	
	
	//게시글 삭제
	@SuppressWarnings("unused")
	@Override
	/**
	 * 멤버 게시글 원본글 삭제 (수정이 필요)
	 */
	public boolean DelMemberBoard(MemberBoardDTO mboarddto, MemberReplyDTO mreplydto) {
		logger.info("DelMemberBoard 멤버 게시글 원본글 삭제");
		
		boolean MemReReDel = dao.MemberDetailReReplyDel(mreplydto);
		boolean MemReDel = dao.MemberDetailReplyDel(mreplydto);
		boolean MemDelBoard = dao.MemberDetailDelBoard(mboarddto);
		
		return MemReReDel?true:false;
		
	}

	@SuppressWarnings("unused")
	@Override
	/**
	 * 팀 게시글 원본글 삭제 (수저이 필요)
	 */
	public boolean DelTeamBoard(TeamBoardDTO tboarddto, TeamReplyDTO treplydto) {
		logger.info("DelTeamBoard 팀 게시글 원본글 삭제");
		boolean TeamReReDel = dao.TeamDetailReReplyDel(treplydto);
		boolean TeamReDel = dao.TeamDetailReplyDel(treplydto);
		boolean TeamDelBoardDel = dao.TeamDetailDelBoard(tboarddto);
		
		return TeamReReDel?true:false;
	}

	@Override
	/**
	 * 멤버 댓글 삭제
	 */
	public boolean DelMembarReply(MemberReplyDTO mreplydto, MemberBoardDTO mboarddto) {
		logger.info("DelMembarReply 멤버 댓글 삭제");
		boolean MemReReDel = dao.MembarReReplyDel(mreplydto);
		@SuppressWarnings("unused")
		boolean MemReDel = dao.MembarReplyDel(mboarddto);
		
		return MemReReDel?true:false;
	}

	@Override
	/**
	 * 팀 댓글 삭제
	 */
	public boolean DelTeamReply(TeamReplyDTO treplydto, TeamBoardDTO tboarddto) {
		logger.info("DelTeamReply 팀 댓글 삭제");
		boolean TeamReReDel = dao.TeamReReplyDel(treplydto);
		@SuppressWarnings("unused")
		boolean TeamReDel = dao.TeamReplyDel(tboarddto);
		return TeamReReDel?true:false;
	}

	@Override
	/**
	 * 멤버 대댓글 삭제
	 */
	public boolean DelMembarReReply(MemberReplyDTO mreplydto) {
		logger.info("DelMembarReReply 멤버 대댓글 삭제");
		return dao.DelMembarReReply(mreplydto);
	}

	@Override
	/**
	 * 팀 대댓글 삭제
	 */
	public boolean DelTeamReReply(TeamReplyDTO treplydto) {
		logger.info("DelTeamReReply 팀 대댓글 삭제");
		return dao.DelTeamReReply(treplydto);
	}

}
