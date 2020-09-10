package com.winter.baseballproject.web.dto.player;

import com.winter.baseballproject.domain.player.Player;
import com.winter.baseballproject.domain.team.Team;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayerReqDto {

	private int id;
	private int playerNo;
	private int teamId;
	private String name;
	private String position;
	private String teamName;
	private String kt;
	private String kia;
	private String nc;
	
	// ﻿toEntity를 호출하면 Player가 만들어져서 리턴됨 -> 안 하면 하나씩 set해줘야해서 불편하다.
		public Player toPlayerEntity() {
			
			return Player.builder()
					.teamId(teamId)
					.playerNo(playerNo)
					.name(name)
					.position(position)
					.build();
		}
}
