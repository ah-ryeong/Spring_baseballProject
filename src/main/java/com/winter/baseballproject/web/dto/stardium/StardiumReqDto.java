package com.winter.baseballproject.web.dto.stardium;

import com.winter.baseballproject.domain.stardium.Stardium;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StardiumReqDto {

	private int id;
	private String place;
	
	// ﻿toEntity를 호출하면 Stardium이 만들어져서 리턴됨 -> 안 하면 하나씩 set해줘야해서 불편하다.
	public Stardium toStardiumEntity() {
		return Stardium.builder()
				.place(place)
				.build();
	}
}
