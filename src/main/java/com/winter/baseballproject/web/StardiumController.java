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

import com.winter.baseballproject.service.StardiumService;

import lombok.RequiredArgsConstructor;

@Controller
@CrossOrigin(origins = "/*")
@RequestMapping("baseball") 
@RequiredArgsConstructor
public class StardiumController {
	
	private final StardiumService stardiumService;

	@GetMapping("/stardium")
	public String stardium(Model model) {
		
		model.addAttribute("stardiumList", stardiumService.stardiumList());
		
		return "stardium";
	}
	
	@DeleteMapping("/stardium/delete/{id}")
	public ResponseEntity<?> stardiumDelete(@PathVariable int id){
		System.out.println("StardiumController : 삭제하기 ::: "+id);
		stardiumService.Stardium삭제하기(id);
		
		return new ResponseEntity<String>("OK", HttpStatus.OK);
	}
}
