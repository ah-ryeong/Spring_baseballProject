package com.winter.baseballproject.web.dto.team;

import com.winter.baseballproject.domain.stardium.Stardium;
import com.winter.baseballproject.domain.team.Team;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeamReqDto {
	
	private int id;
	private int no;
	private String teamName;
	
	// ﻿toEntity를 호출하면 Team이 만들어져서 리턴됨 -> 안 하면 하나씩 set해줘야해서 불편하다.
	public Team toTeamEntity() {
		return Team.builder()
				.teamName(teamName)
				.build();
	}
}
