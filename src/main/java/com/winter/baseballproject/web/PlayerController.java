package com.winter.baseballproject.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		
		model.addAttribute("playerList", playerService.playerList())
		.addAttribute("player", playerService.모든플레이어찾기());
		
		return "player";
	}
	
	@DeleteMapping("/player/delete/{id}")
	public ResponseEntity<?> teamDelete(@PathVariable int id){
		System.out.println("PlayerController : 삭제하기 ::: "+id);
		playerService.Player삭제하기(id);
		
		return new ResponseEntity<String>("OK", HttpStatus.OK);
	}
}
