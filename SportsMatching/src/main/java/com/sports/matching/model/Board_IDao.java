package com.sports.matching.model;

import java.util.List;
import java.util.Map;

import com.sports.matching.dtos.MemberBoardDTO;
import com.sports.matching.dtos.MemberReplyDTO;
import com.sports.matching.dtos.RowNum_DTO;
import com.sports.matching.dtos.TeamBoardDTO;
import com.sports.matching.dtos.TeamReplyDTO;

public interface Board_IDao {
	
	
	//게시글 조회
	/**
	 * 멤버 게시글 조회
	 * @return MemberBoardList
	 */
	public List<MemberBoardDTO> MemberBoardList(Map<String, String> map);
		
	
	/**
	 * 팀 게시글 조회
	 * @return TeamBoardList
	 */
	public List<TeamBoardDTO> TeamBoardList();
	
	/**
	 * 멤버 게시글 전체 갯수
	 * @return
	 */
	public int MemberBoardTotalCount();
	
	/**
	 * 팀 게시글 전체 갯수
	 * @return
	 */
	public int TeamBoardTotalCount();
	
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
	 * 멤버 게시글 검색 조회
	 * @param searchOption
	 * @param keyword
	 * @return
	 */
//	public List<MemberBoardDTO> MemberBoardSearch(String searchOption, String keyword);
	
	
	/**
	 * 팀 게시글 검색 조회
	 * @param searchOption
	 * @param keyword
	 * @return
	 */
//	public List<TeamBoardDTO> TeamBoardSearch(String searchOption, String keyword);
	
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
	 * @return 
	 */
	public boolean MembarBoardWrite(MemberBoardDTO mboarddto);
	
	/**
	 * 팀 게시글 작성
	 * @param tboarddto
	 * @return 
	 */
	public boolean TeamBoardWrite(TeamBoardDTO tboarddto);
	
	/**
	 * 멤버 게시판 댓글 작성
	 * @param mreplydto
	 * @return 
	 */
	public boolean MemberWriteReply(MemberReplyDTO mreplydto);
	
	/**
	 * 팀 게시판 댓글 작성
	 * @param treplydto
	 * @return 
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
	 * @param mreplydto, mboarddto
	 * @return MemberReplyDTO, MemberBoardDTO
	 */
	public boolean MemberDetailReReplyDel(MemberReplyDTO mreplydto);
	public boolean MemberDetailReplyDel(MemberReplyDTO mreplydto);
	public boolean MemberDetailDelBoard(MemberBoardDTO mboarddto);
	
	/**
	 * 팀 게시글 원본글 삭제
	 * @param treplydto, tboarddto
	 * @return TeamReplyDTO, TeamBoardDTO
	 */
	public boolean TeamDetailReReplyDel(TeamReplyDTO treplydto);
	public boolean TeamDetailReplyDel(TeamReplyDTO treplydto);
	public boolean TeamDetailDelBoard(TeamBoardDTO tboarddto);
	
	/**
	 * 멤버 댓글 삭제
	 * @param mreplydto
	 * @return MemberReplyDTO
	 */
	public boolean MembarReReplyDel(MemberReplyDTO mreplydto);
	public boolean MembarReplyDel(MemberBoardDTO mboarddto);
	
	/**
	 * 팀 댓글 삭제
	 * @param treplydto
	 * @return TeamReplyDTO
	 */
	public boolean TeamReReplyDel(TeamReplyDTO treplydto);
	public boolean TeamReplyDel(TeamBoardDTO tboarddto);
	
	
	/**
	 * 멤버 대댓글 삭제
	 * @param mreplydto
	 * @return MemberReplyDTO
	 */
	public boolean DelMembarReReply(MemberReplyDTO mreplydto);
	
	/**
	 * 팀 대댓글 삭제
	 * @param treplydto
	 * @return TeamReplyDTO
	 */
	public boolean DelTeamReReply(TeamReplyDTO treplydto);
	
	/**
	 * 멤버 게시판 페이징 처리
	 * @param dto
	 * @return
	 */
	public List<MemberBoardDTO> MemberPageList(RowNum_DTO dto);
	
	/**
	 * 팀 게시판 페이징 처리
	 * @param dto
	 * @return
	 */
	public List<TeamBoardDTO> TeamPageList(RowNum_DTO dto);


}
