package com.winter.baseballproject.domain.player;

import java.util.List;

import com.winter.baseballproject.web.dto.player.PlayerReqDto;

public interface PlayerMapper {

	List<PlayerReqDto> findPlayer();
}