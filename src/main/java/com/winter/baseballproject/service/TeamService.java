package com.winter.baseballproject.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.winter.baseballproject.domain.team.Team;
import com.winter.baseballproject.domain.team.TeamRepository;
import com.winter.baseballproject.web.dto.team.TeamReqDto;

import lombok.RequiredArgsConstructor;
import net.bytebuddy.asm.Advice.OffsetMapping.Target.ForArray.ReadOnly;

@RequiredArgsConstructor
@Service
public class TeamService {

	private final TeamRepository teamRepository;

	@Transactional
	public void Team저장(TeamReqDto teamReqDto) {
		System.out.println("TeamService 입력 들어옴");
		System.out.println("TeamService : Team저장 :::"+ teamReqDto);
		String teamName = teamReqDto.getTeamName();
		teamReqDto.setTeamName(teamName);
		teamRepository.save(teamReqDto.toTeamEntity());
	}
	
	@Transactional(readOnly = true)
	public List<Team> teamList() {
		List<Team> teamList = teamRepository.findAll();
		
		return teamList;
	}
	
	@Transactional
	public void Team삭제하기(int id) {
		int result = teamRepository.Team삭제하기(id);
	}
	
	@Transactional
	public List<Team> TeamId찾기(String teamName) {
		List<Team> selectTeam = teamRepository.입력된팀찾기(teamName);
		
		return selectTeam;
	}
}
