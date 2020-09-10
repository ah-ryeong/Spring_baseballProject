package com.winter.baseballproject.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.winter.baseballproject.domain.outplayer.OutPlayer;
import com.winter.baseballproject.domain.outplayer.OutPlayerRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OutPlayerService {

	private OutPlayerRepository outPlayerRepository;
	
	@Transactional
	public void 저장(int id, String reason) {
		System.out.println("OutPlayerService : ID ::: " + id);
		System.out.println("OutPlayerService : ID ::: " + reason);
		
		Timestamp Date = new Timestamp(id);
		
		OutPlayer outPlayerSave = OutPlayer.builder()
				.playerId(id)
				.reason(reason)
				.build();
		
		outPlayerRepository.save(outPlayerSave);
	}
}
