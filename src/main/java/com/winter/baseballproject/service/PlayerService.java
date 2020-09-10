package com.winter.baseballproject.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.winter.baseballproject.domain.player.Player;
import com.winter.baseballproject.domain.player.PlayerMapper;
import com.winter.baseballproject.domain.player.PlayerRepository;
import com.winter.baseballproject.domain.team.Team;
import com.winter.baseballproject.web.dto.player.PlayerReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PlayerService {

	private final TeamService teamService;
	private final PlayerRepository playerRepository;
	private final PlayerMapper playerMapper;

	@Transactional
	public void Player저장(PlayerReqDto playerReqDto) {
		System.out.println("StardiumService 입력 들어옴");
		System.out.println("StardiumService : Stardium저장 :::"+playerReqDto);
		
		List<Team> insertTeam = teamService.TeamId찾기(playerReqDto.getTeamName());
		int teamId = insertTeam.get(0).getId();
		playerReqDto.setTeamId(teamId);
		playerReqDto.setPlayerNo(playerReqDto.getPlayerNo());
		playerReqDto.setName(playerReqDto.getName());
		playerReqDto.setPosition(playerReqDto.getPosition());
		
		playerRepository.save(playerReqDto.toPlayerEntity());
	}
	
	@Transactional(readOnly = true)
	public List<PlayerReqDto> playerList() {
		List<PlayerReqDto> playerList = playerMapper.findPlayer();
		
		return playerList;
	}
	
	@Transactional(readOnly = true)
	public List<PlayerReqDto> 모든플레이어찾기() {
		List<PlayerReqDto> AllPlayer = playerMapper.모든플레이어찾기();
		
		return AllPlayer;
	}
	
	@Transactional
	public void Player삭제하기(int id) {
		int result = playerRepository.Player삭제하기(id);
	}
}
