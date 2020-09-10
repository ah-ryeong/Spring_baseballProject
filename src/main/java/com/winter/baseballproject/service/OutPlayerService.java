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

	private final OutPlayerRepository outPlayerRepository;
	
	@Transactional
	public void 저장(int playerId, String reason) {
		System.out.println("OutPlayerService : ID ::: " + playerId);
		System.out.println("OutPlayerService : ID ::: " + reason);
		
		
		OutPlayer outPlayerSave = OutPlayer.builder()
				.playerId(playerId)
				.reason(reason)
				.build();
		
		System.out.println("OutPlayerService : 저장 ::: " + outPlayerSave);
		outPlayerRepository.save(outPlayerSave);
	}
}
