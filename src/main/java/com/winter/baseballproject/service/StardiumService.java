package com.winter.baseballproject.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.winter.baseballproject.domain.stardium.Stardium;
import com.winter.baseballproject.domain.stardium.StardiumRepository;
import com.winter.baseballproject.web.dto.stardium.StardiumReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class StardiumService {
	
	private final StardiumRepository stardiumRepository;

	@Transactional
	public void Stardium저장(StardiumReqDto stardiumReqDto) {
		System.out.println("StardiumService 입력 들어옴");
		System.out.println("StardiumService : Stardium저장 :::"+stardiumReqDto);
		String place = stardiumReqDto.getPlace();
		stardiumReqDto.setPlace(place);
		stardiumRepository.save(stardiumReqDto.toStardiumEntity());
	}
	
	@Transactional(readOnly = true)
	public List<Stardium> stardiumList(){
		List<Stardium> stardiumList = stardiumRepository.findAll();
		
		return stardiumList;
	}
	
	@Transactional
	public void Stardium삭제하기(int id) {
		int result = stardiumRepository.Stardium삭제하기(id);

	}
}
