package com.sports.matching.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sports.matching.dtos.Belonged_TeamDto;
import com.sports.matching.dtos.MembersDto;
import com.sports.matching.dtos.StadiumAdminDto;
import com.sports.matching.dtos.StatDto;
import com.sports.matching.dtos.TeamDto;
@Service
public class MemberShip_ServiceImpl implements MemberShip_IService {

	@Autowired
	private MemberShip_IDao dao;
	
	@Override
	public boolean apiLogin(String member_id) {
		return dao.apiLogin(member_id);
	}
	
	@Override
	public int duplicateUserId(String member_id) {
		return dao.duplicateUserId(member_id);
	}
	
	@Override
	public MembersDto selectUser(String member_id) {
		return dao.selectUser(member_id);
	}

	@Override
	public TeamDto teamLogin(Map<String, String> map) {
		return dao.teamLogin(map);
	}

	@Override
	public StadiumAdminDto adminLogin(Map<String, String> map) {
		return dao.adminLogin(map);
	}

	@Override
	public boolean joinTeam(Belonged_TeamDto BTDto) {
		return dao.joinTeam(BTDto);
	}

	@Override
	public boolean registTeam(TeamDto TDto) {
		return dao.registTeam(TDto);
	}

	@Override
	public int duplicateTeamId(String team_id) {
		return dao.duplicateTeamId(team_id);
	}

	@Override
	public MembersDto withDraw(MembersDto MDto) {
		return dao.withDraw(MDto);
	}

	@Override
	public boolean reJoin(MembersDto MDto) {
		return dao.reJoin(MDto);
	}

	@Override
	public TeamDto teamPasswordQnA(TeamDto TDto) {
		return dao.teamPasswordQnA(TDto);
	}

	@Override
	public List<Belonged_TeamDto> memberMypage(String member_id) {
		return dao.memberMypage(member_id);
	}

	@Override
	public List<Belonged_TeamDto> teamMemberList(String team_id) {
		return dao.teamMemberList(team_id);
	}

	@Override
	public StatDto selectTeam(String team_id) {
		return dao.selectTeam(team_id);
	}

	@Override
	public TeamDto captainId(TeamDto TDto) {
		return dao.captainId(TDto);
	}

	@Override
	public boolean updateTeamInfo(TeamDto TDto) {
		return dao.updateTeamInfo(TDto);
	}

	@Override
	public boolean dormantTeam(TeamDto TDTo) {
		return dao.dormantTeam(TDTo);
	}

	@Override
	public boolean modifyAdminPassword(StadiumAdminDto SADto) {
		return dao.modifyAdminPassword(SADto);
	}

	@Override
	public boolean updateWithdraw(String member_id) {
		return dao.updateWithdraw(member_id);
	}

	@Override
	public boolean deleteMemberTeam(String member_id) {
		return dao.deleteMemberTeam(member_id);
	}

	@Override
	public boolean teamMemberMultiDel(String[] member_id) {
		return dao.teamMemberMultiDel(member_id);
	}

	@Override
	public boolean deleteBelongedTeam(String team_id) {
		return dao.deleteBelongedTeam(team_id);
	}

	

	

}
