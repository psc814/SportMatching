package com.sports.matching.model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sports.matching.dtos.Belonged_TeamDto;
import com.sports.matching.dtos.MembersDto;
import com.sports.matching.dtos.StadiumAdminDto;
import com.sports.matching.dtos.StatDto;
import com.sports.matching.dtos.TeamDto;
@Repository
public class MemberShip_DaoImpl implements MemberShip_IDao {
	
	private Logger logger = LoggerFactory.getLogger(MemberShip_IDao.class);
	private final String NS = "com.sports.matching.MemberShip_Mapper.";
	
	@Autowired
	private SqlSessionTemplate session;

	@Override
	public boolean apiLogin(String member_id) {
		logger.info("API 로그인 ");
		int a = session.insert(NS+"apiLogin", member_id);
		return (a>0)?true:false;
	}
	
	@Override
	public int duplicateUserId(String member_id) {
		logger.info("일반회원 아이디 중복검사");
		return session.selectOne(NS+"duplicateUserId", member_id);
	}
	
	@Override
	public MembersDto selectUser(String member_id) {
		logger.info("회원 로그인");
		return session.selectOne(NS+"selectUser", member_id);
	}

	@Override
	public TeamDto teamLogin(TeamDto TDto) {
		logger.info("팀 로그인");
		return session.selectOne(NS+"teamLogin", TDto);
	}

	@Override
	public StadiumAdminDto adminLogin(Map<String, String> map) {
		logger.info("관리자 로그인");
		return session.selectOne(NS+"adminLogin", map);
	}

	@Override
	public boolean joinTeam(Belonged_TeamDto BTDto) {
		logger.info("개인회원의 팀 가입");
		int a = session.insert(NS+"joinTeam",BTDto);
		return (a>0)?true:false;
	}

	@Override
	public boolean registTeam(TeamDto TDto) {
		logger.info("팀 회원 가입 (팀 창단)");
		int a = session.insert(NS+"registTeam", TDto);
		return (a>0)?true:false;
	}

	@Override
	public TeamDto duplicateTeamId(String team_id) {
		logger.info("팀 아이디 중복검사");
		return session.selectOne(NS+"duplicateTeamId", team_id);
	}

	@Override
	public MembersDto withDraw(MembersDto MDto) {
		logger.info("탈퇴회원 검사");
		return session.selectOne(NS+"withDraw", MDto);
	}

	@Override
	public boolean reJoin(MembersDto MDto) {
		logger.info("재가입");
		int a = session.update(NS+"reJoin", MDto);
		return (a>0)?true:false;
	}

	@Override
	public TeamDto teamPasswordQnA(TeamDto TDto) {
		logger.info("팀 비밀번호 질문/답변 검사");
		return session.selectOne(NS+"teamPasswordQnA", TDto);
	}

	@Override
	public List<Belonged_TeamDto> memberMypage(String member_id) {
		logger.info("개인회원 마이페이지");
		return session.selectList(NS+"memberMypage", member_id);
	}

	@Override
	public List<Belonged_TeamDto> teamMemberList(String team_id) {
		logger.info("팀 회원 리스트");
		return session.selectList(NS+"teamMemberList", team_id);
	}

	@Override
	public StatDto selectTeam(String team_id) {
		logger.info("팀 조회 (팀 페이지)");
		return session.selectOne(NS+"selectTeam", team_id);
	}

	@Override
	public TeamDto captainId(TeamDto TDto) {
		logger.info("주장여부");
		return session.selectOne(NS+"captainId", TDto);
	}

	@Override
	public boolean updateTeamInfo(TeamDto TDto) {
		logger.info("팀 정보 수정");
		int a = session.update(NS+"updateTeamInfo", TDto);
		return (a>0)?true:false;
	}

	@Override
	public boolean dormantTeam(TeamDto TDto) {
		logger.info("팀 휴면 전환 ");
		int a = session.update(NS+"dormantTeam", TDto);
		return false;
	}

	@Override
	public boolean modifyAdminPassword(StadiumAdminDto SADto) {
		logger.info("관리자 비밀번호 수정");
		int a = session.update(NS+"modifyAdminPassword", SADto);
		return (a>0)?true:false;
	}

	@Override
	public boolean updateWithdraw(String member_id) {
		logger.info("탈퇴/미탈퇴 회원 구분");
		int a = session.update(NS+"updateWithdraw", member_id);
		return (a>0)?true:false;
	}

	@Override
	public boolean deleteMemberTeam(String member_id) {
		logger.info("회원탈퇴");
		int a = session.delete(NS+"deleteMemberTeam", member_id);
		return (a>0)?true:false;
	}

	@Override
	public boolean teamMemberMultiDel(String[] member_id) {
		logger.info("팀회원 다중 삭제");
		int a = session.delete(NS+"teamMemberMultiDel", member_id);
		return (a>0)?true:false;
	}

	@Override
	public boolean deleteBelongedTeam(String team_id) {
		logger.info("소속팀 삭제 ");
		int a = session.delete(NS+"deleteBelongedTeam", team_id);
		return (a>0)?true:false;
	}

	

	

}
