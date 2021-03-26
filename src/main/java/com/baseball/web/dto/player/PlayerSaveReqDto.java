package com.baseball.web.dto.player;

import com.baseball.domain.player.Player;

import lombok.Data;

@Data
public class PlayerSaveReqDto {
	private String name;
	private String position;
	private Integer teamId;
	
	public Player toEntity() {
		return Player.builder()
				.name(name)
				.position(position)
				.build();
	}
}
