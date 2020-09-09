package com.winter.baseballproject.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.winter.baseballproject.domain.stardium.Stardium;
import com.winter.baseballproject.domain.team.Team;
import com.winter.baseballproject.service.PlayerService;
import com.winter.baseballproject.service.StardiumService;
import com.winter.baseballproject.service.TeamService;
import com.winter.baseballproject.web.dto.player.PlayerReqDto;
import com.winter.baseballproject.web.dto.stardium.StardiumReqDto;
import com.winter.baseballproject.web.dto.team.TeamReqDto;

import lombok.RequiredArgsConstructor;

@Controller
@CrossOrigin(origins = "/*")
@RequestMapping("baseball") 
@RequiredArgsConstructor
public class IndexController { 

	// 첫 페이지 & 등록화면 
	
	private final StardiumService stardiumService;
	private final TeamService teamService;
	private final PlayerService playerService;
	
	@GetMapping("/")
	public String home() {
		
		return "saveForm";
	}
	
	@PostMapping("/stardiumSave")
	public String stardirumSave(StardiumReqDto stardiumReqDto) {
		stardiumService.Stardium저장(stardiumReqDto);
		return "saveForm";
	}
	
	@PostMapping("/teamSave")
	public String teamSave(TeamReqDto teamReqDto) {
		teamService.Team저장(teamReqDto);
		return "saveForm";
	}
	
	@PostMapping("/playerSave")
	public String playerSave(PlayerReqDto playerReqDto) {
		
		playerService.Player저장(playerReqDto);
		
		return "saveForm";
	}
	
}
