package com.winter.baseballproject.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.winter.baseballproject.service.PlayerService;

import lombok.RequiredArgsConstructor;

@Controller
@CrossOrigin(origins = "/*")
@RequestMapping("baseball") 
@RequiredArgsConstructor
public class PlayerController {
	
	private final PlayerService playerService;

	@GetMapping("/player")
	public String player(Model model) {
		
		model.addAttribute("playerList", playerService.playerList());
		
		return "player";
	}
}
