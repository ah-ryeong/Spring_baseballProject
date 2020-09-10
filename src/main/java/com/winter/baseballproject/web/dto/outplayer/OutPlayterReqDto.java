package com.winter.baseballproject.web.dto.outplayer;

import java.sql.Timestamp;

import com.winter.baseballproject.domain.outplayer.OutPlayer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OutPlayterReqDto {
	
	private int playerId;
	private String reason;
	private String teamName;
	
	
	// ﻿toEntity를 호출하면 Player가 만들어져서 리턴됨 -> 안 하면 하나씩 set해줘야해서 불편하다.
			public OutPlayer toOutPlayerEntity() {
				
				return OutPlayer.builder()
						.playerId(playerId)
						.reason(reason)
						.build();
			}
}
