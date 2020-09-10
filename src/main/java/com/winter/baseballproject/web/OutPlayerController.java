package com.winter.baseballproject.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.winter.baseballproject.service.OutPlayerService;
import com.winter.baseballproject.service.PlayerService;
import com.winter.baseballproject.web.dto.outplayer.OutPlayterReqDto;

import lombok.RequiredArgsConstructor;

@Controller
@CrossOrigin(origins = "/*")
@RequestMapping("baseball") 
@RequiredArgsConstructor
public class OutPlayerController {
	
	private final PlayerService playerService;
	private final OutPlayerService outPlayerService;

	@GetMapping("/outplayer")
	public String outPlayer(Model model) {
		model.addAttribute("playerList", playerService.모든플레이어찾기());
		
		return "outPlayer";
	}
	
	@PostMapping("/outPlayer/save")
	public String outPlayerSave(@RequestBody OutPlayterReqDto data) {
		System.out.println("outplayerController : Save ::: " + data);
		outPlayerService.저장(data.getPlayerId(), data.getReason());
		
		return "저장완료";
	}
}
