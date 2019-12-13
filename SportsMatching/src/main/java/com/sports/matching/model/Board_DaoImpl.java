package com.sports.matching.model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sports.matching.dtos.MemberBoardDTO;
import com.sports.matching.dtos.MemberReplyDTO;
import com.sports.matching.dtos.TeamBoardDTO;
import com.sports.matching.dtos.TeamReplyDTO;

@Repository
public class Board_DaoImpl implements Board_IDao {

	
	@Autowired
	private SqlSessionTemplate sqlsession;
	
	private final String NS = "com.sports.matching.boardmapper.";

	
	//게시글 조회
	@Override
	/**
	 * 멤버 게시글 조회
	 */
	public List<MemberBoardDTO> MemberBoardList() {
		return sqlsession.selectList(NS+"MemberBoardList");
	}

	
	@Override
	/**
	 * 팀 게시글 조회
	 */
	public List<TeamBoardDTO> TeamBoardList() {
		return sqlsession.selectList(NS+"TeamBoardList");
	}
			

	@Override
	/**
	 * 멤버 게시글 상세 조회
	 */
	public MemberBoardDTO MemberBoardDetail(String member_board_seq) {
		return sqlsession.selectOne(NS+"MemberBoardDetail", member_board_seq);
	}

	@Override
	/**
	 * 팀 게시글 상세 조회
	 */
	public TeamBoardDTO TeamBoardDetail(String team_board_seq) {
		return sqlsession.selectOne(NS+"TeamBoardDetail", team_board_seq);
	}
	

	@Override
	/**
	 * 멤버 게시글 댓글 조회
	 */
	public MemberReplyDTO DetailMemberReply(String reply_seq) {
		return sqlsession.selectOne(NS+"DetailMemberReply", reply_seq);
	}

	@Override
	/**
	 * 팀 게시글 댓글 조회
	 */
	public TeamReplyDTO DetailTeamReply(String reply_seq) {
		return sqlsession.selectOne(NS+"DetailTeamReply", reply_seq);
	}
	
	
	@Override
	/**
	 * 멤버 게시판 상세글 조회수 증가
	 */
	public boolean MemberCountBoard(String member_board_seq) {
		int cnt = sqlsession.update(NS+"MemberCountBoard", member_board_seq);
		return cnt>0?true:false;
		
	}
	
	@Override
	/**
	 * 팀 게시판 상세글 조회수 증가
	 */
	public boolean TeamCountBoard(String team_board_seq) {
		int cnt = sqlsession.update(NS+"TeamCountBoard", team_board_seq);
		return cnt>0?true:false;

	}
	
	
	//게시글 작성
	@Override
	/**
	 * 멤버 게시글 작성
	 */
	public boolean MembarBoardWrite(MemberBoardDTO mboarddto) {
		int cnt = sqlsession.insert(NS+"MembarBoardWrite", mboarddto);
		return cnt>0?true:false;
	}

	@Override
	/**
	 * 팀 게시글 작성
	 */
	public boolean TeamBoardWrite(TeamBoardDTO tboarddto) {
		int cnt =sqlsession.insert(NS+"TeamBoardWrite", tboarddto);
		return cnt>0?true:false;
	}

	@Override
	/**
	 * 멤버 게시판 댓글 작성
	 */
	public boolean MemberWriteReply(MemberReplyDTO mreplydto) {
		int cnt = sqlsession.insert(NS+"MemberWriteReply", mreplydto);
		return cnt>0?true:false;
	}

	@Override
	/**
	 * 팀 게시판 댓글 작성
	 */
	public boolean TeamWriteReply(TeamReplyDTO treplydto) {
		int cnt = sqlsession.insert(NS+"TeamWriteReply", treplydto);
		return cnt>0?true:false;
	}
	
	
	// 게시글 수정
	@Override
	/**
	 * 멤버 게시글 수정
	 */
	public boolean MemberBoardModify(MemberBoardDTO mboarddto) {
		int cnt = sqlsession.update(NS+"MemberBoardModify", mboarddto);
		return cnt>0?true:false;
	}

	@Override
	/**
	 * 팀 게시글 수정
	 */
	public boolean TeamBoarModify(TeamBoardDTO tboarddto) {
		int cnt = sqlsession.update(NS+"TeamBoarModify", tboarddto);
		return cnt>0?true:false;
	}

	@Override
	/**
	 * 멤버 게시글 댓글 수정
	 */
	public boolean MemReplyModify(MemberReplyDTO mreplydto) {
		int cnt = sqlsession.update(NS+"MemReplyModify", mreplydto);
		return cnt>0?true:false;
	}

	@Override
	/**
	 * 팀 게시글 댓글 수정
	 */
	public boolean TeamReplyModify(TeamReplyDTO treplydto) {
		int cnt = sqlsession.update(NS+"TeamReplyModify", treplydto);
		return cnt>0?true:false;
	}
	
	
	
	//게시글 삭제
	@Override
	/**
	 * 멤버 게시글 원본글 삭제
	 */
	public boolean MemberDetailReReplyDel(MemberReplyDTO mreplydto) {
		int cnt = sqlsession.delete(NS+"MemberDetailReReplyDel", mreplydto);
		return cnt>0?true:false;
	}
	@Override
	public boolean MemberDetailReplyDel(MemberReplyDTO mreplydto) {
		int cnt = sqlsession.delete(NS+"MemberDetailReplyDel", mreplydto);
		return cnt>0?true:false;
	}
	@Override
	public boolean MemberDetailDelBoard(MemberBoardDTO mboarddto) {
		int cnt = sqlsession.delete(NS+"MemberDetailDelBoard", mboarddto);
		return cnt>0?true:false;
	}
	
	
	@Override
	/**
	 * 팀 게시글 원본글 삭제
	 */
	public boolean TeamDetailReReplyDel(TeamReplyDTO treplydto) {
		int cnt = sqlsession.delete(NS+"TeamDetailReReplyDel", treplydto);
		return cnt>0?true:false;
	}
	@Override
	public boolean TeamDetailReplyDel(TeamReplyDTO treplydto) {
		int cnt = sqlsession.delete(NS+"TeamDetailReplyDel", treplydto);
		return cnt>0?true:false;
	}
	@Override
	public boolean TeamDetailDelBoard(TeamBoardDTO tboarddto) {
		int cnt = sqlsession.delete(NS+"TeamDetailDelBoard", tboarddto);
		return cnt>0?true:false;
	}

	
	@Override
	/**
	 * 멤버 댓글 삭제
	 */
	public boolean MembarReReplyDel(MemberReplyDTO mreplydto) {
		int cnt = sqlsession.delete(NS+"MembarReReplyDel", mreplydto);
		return cnt>0?true:false;
	}
	@Override
	public boolean MembarReplyDel(MemberBoardDTO mboarddto) {
		int cnt = sqlsession.delete(NS+"MembarReplyDel", mboarddto);
		return cnt>0?true:false;
	}
	

	@Override
	/**
	 * 팀 댓글 삭제
	 */
	public boolean TeamReReplyDel(TeamReplyDTO treplydto) {
		int cnt = sqlsession.delete(NS+"TeamReReplyDel", treplydto);
		return cnt>0?true:false;
	}
	@Override
	public boolean TeamReplyDel(TeamBoardDTO tboarddto) {
		int cnt = sqlsession.delete(NS+"TeamReplyDel", tboarddto);
		return cnt>0?true:false;
	}

	@Override
	/**
	 * 멤버 대댓글 삭제 
	 */
	public boolean DelMembarReReply(MemberReplyDTO mreplydto) {
		int cnt = sqlsession.delete(NS+"DelMembarReReply", mreplydto);
		return cnt>0?true:false;
	}

	@Override
	/**
	 * 팀 대댓글 삭제
	 */
	public boolean DelTeamReReply(TeamReplyDTO treplydto) {
		int cnt = sqlsession.delete(NS+"DelTeamReReply", treplydto);
		return cnt>0?true:false;
	}

}
