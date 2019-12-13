package com.sports.matching.model;

import java.util.List;
import java.util.Map;

import com.sports.matching.dtos.Belonged_TeamDto;
import com.sports.matching.dtos.MembersDto;
import com.sports.matching.dtos.StadiumAdminDto;
import com.sports.matching.dtos.StatDto;
import com.sports.matching.dtos.TeamDto;

public interface MemberShip_IDao {

		//API 회원가입
		public boolean apiLogin(String member_id);
		//일반회원 아이디 중복검사
		public int duplicateUserId(String member_id);
		// 회원 로그인
		public MembersDto selectUser(String member_id);
		//팀 로그인 
		public TeamDto teamLogin(TeamDto TDto);
		//관리자 로그인
		public StadiumAdminDto adminLogin(StadiumAdminDto SADto);
		//개인회원의 팀 가입
		public boolean joinTeam(Belonged_TeamDto BTDto);
		//팀 회원 가입 (팀 창단)
		public boolean registTeam(TeamDto TDto);
		//팀 아이디 중복검사
		public TeamDto duplicateTeamId(String team_id);
		//탈퇴회원 검사
		public MembersDto withDraw(MembersDto MDto);
		//재가입
		public boolean reJoin(MembersDto MDto);
		//팀 비밀번호 질문/답변 검사
		public TeamDto teamPasswordQnA(TeamDto TDto);
		//개인회원 마이페이지
		public List<Belonged_TeamDto> memberMypage(String member_id);
		//팀 회원 리스트
		public List<Belonged_TeamDto> teamMemberList(String team_id);
		//팀 조회 (팀 페이지)
		public StatDto selectTeam(String team_id);
		//주장여부
		public TeamDto captainId(TeamDto TDto);
		//팀 정보 수정
		public boolean updateTeamInfo(TeamDto TDto);
		//팀 휴면 전환
		public boolean dormantTeam(TeamDto TDTo);
		//관리자 비밀번호 수정
		public boolean modifyAdminPassword(StadiumAdminDto SADto);
		//탈퇴/미탈퇴 회원 구분
		public boolean updateWithdraw(String member_id);
		//회원탈퇴 
		public boolean deleteMemberTeam(String member_id);
		//팀회원 다중 삭제
		public boolean teamMemberMultiDel(String[] member_id);
		//소속팀 삭제 
		public boolean deleteBelongedTeam(String team_id);
}
