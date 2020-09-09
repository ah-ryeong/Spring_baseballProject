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

import com.winter.baseballproject.service.TeamService;

import lombok.RequiredArgsConstructor;

@Controller
@CrossOrigin(origins = "/*")
@RequestMapping("baseball") 
@RequiredArgsConstructor
public class TeamController {
	
	private final TeamService teamService;
	
	

	@GetMapping("/team")
	public String team(Model model) {
		
		model.addAttribute("teamList", teamService.teamList());
		
		return "team";
	}
	
	@DeleteMapping("/team/delete/{id}")
	public ResponseEntity<?> teamDelete(@PathVariable int id){
		System.out.println("TeamController : 삭제하기 ::: "+id);
		teamService.Team삭제하기(id);
		
		return new ResponseEntity<String>("OK", HttpStatus.OK);
	}
}
