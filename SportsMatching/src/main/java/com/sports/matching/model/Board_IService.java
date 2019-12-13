package com.sports.matching.model;

import java.util.List;
import java.util.Map;

import com.sports.matching.dtos.MemberBoardDTO;
import com.sports.matching.dtos.MemberReplyDTO;
import com.sports.matching.dtos.TeamBoardDTO;
import com.sports.matching.dtos.TeamReplyDTO;

public interface Board_IService {
	
	//게시글 조회
	/**
	 * 멤버 게시글 조회
	 * @return MemberBoardList
	 */
	public List<MemberBoardDTO> MemberBoardList();
	
	/**
	 * 팀 게시글 조회
	 * @return TeamBoardList
	 */
	public List<TeamBoardDTO> TeamBoardList();
	
	/**
	 * 멤버 게시글 상세 조회
	 * @param seq
	 * @return MemberBoardDTO
	 */
	public MemberBoardDTO MemberBoardDetail(String member_board_seq);
	
	/**
	 * 팀 게시글 상세 조회
	 * @param seq
	 * @return TeamBoardDTO
	 */
	public TeamBoardDTO TeamBoardDetail(String team_board_seq);
	
	/**
	 * 멤버 게시글 댓글 조회
	 * @param seq
	 * @return MemberReplyDTO
	 */
	public MemberReplyDTO DetailMemberReply(String reply_seq);
	
	/**
	 * 팀 게시글 댓글 조회
	 * @param seq
	 * @return TeamReplyDTO
	 */
	public TeamReplyDTO DetailTeamReply(String reply_seq);
	
	
	/**
	 * 멤버 게시판 상세글 조회수 증가
	 * @param seq
	 */
	public boolean MemberCountBoard (String member_board_seq);
	
	/**
	 * 팀 게시판 상세글 조회수 증가
	 * @param seq
	 */
	public boolean TeamCountBoard (String team_board_seq);
	
	
	
	// 게시글 작성
	/**
	 * 멤버 게시글 작성
	 * @param mboarddto
	 */
	public boolean MembarBoardWrite(MemberBoardDTO mboarddto);
	
	/**
	 * 팀 게시글 작성
	 * @param tboarddto
	 */
	public boolean TeamBoardWrite(TeamBoardDTO tboarddto);
	
	/**
	 * 멤버 게시판 댓글 작성
	 * @param mreplydto
	 */
	public boolean MemberWriteReply(MemberReplyDTO mreplydto);
	
	/**
	 * 팀 게시판 댓글 작성
	 * @param treplydto
	 */
	public boolean TeamWriteReply (TeamReplyDTO treplydto);
	
	
	
	// 게시글 수정
	/**
	 * 멤버 게시글 수정
	 * @param mboarddto
	 * @return MemberBoardDTO
	 */
	public boolean MemberBoardModify(MemberBoardDTO mboarddto);
	
	/**
	 * 팀 게시글 수정
	 * @param tboarddto
	 * @return TeamBoardDTO
	 */
	public boolean TeamBoarModify(TeamBoardDTO tboarddto);
	
	/**
	 * 멤버 게시글 댓글 수정
	 * @param mreplydto
	 * @return MemberReplyDTO
	 */
	public boolean MemReplyModify(MemberReplyDTO mreplydto);
	
	/**
	 * 팀 게시글 댓글 수정
	 * @param treplydto
	 * @return TeamReplyDTO
	 */
	public boolean TeamReplyModify(TeamReplyDTO treplydto);
	
	
	
	// 게시글 삭제
	/**
	 * 멤버 게시글 원본글 삭제
	 * @param mboarddto, mreplydto
	 * @return MemberReplyDTO, MemberBoardDTO
	 */
	public boolean DelMemberBoard(MemberBoardDTO mboarddto, MemberReplyDTO mreplydto);
	
	/**
	 * 팀 게시글 원본글 삭제
	 * @param tboarddto, treplydto
	 * @return TeamReplyDTO, TeamBoardDTO
	 */
	public boolean DelTeamBoard(TeamBoardDTO tboarddto, TeamReplyDTO treplydto);
	
	
	/**
	 * 멤버 댓글 삭제
	 * @param mreplydto
	 * @return MemberReplyDTO
	 */
	public boolean DelMembarReply(MemberReplyDTO mreplydto, MemberBoardDTO mboarddto);
	
	
	/**
	 * 팀 댓글 삭제
	 * @param treplydto
	 * @return TeamReplyDTO
	 */
	public boolean DelTeamReply(TeamReplyDTO treplydtom, TeamBoardDTO tboarddto);
	
	
	
	/**
	 * 멤버 대댓글 삭제
	 * @param mreplydto
	 * @return
	 */
	public boolean DelMembarReReply(MemberReplyDTO mreplydto);
	
	/**
	 * 팀 대댓글 삭제
	 * @param treplydto
	 * @return
	 */
	public boolean DelTeamReReply(TeamReplyDTO treplydto);


}
