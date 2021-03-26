package com.baseball.web.dto.team;

import com.baseball.domain.team.Team;

import lombok.Data;

@Data
public class TeamSaveReqDto {
	
	private String name;
	private Integer BallparkId;
	
	public Team toEntity() {
		return Team.builder()
				.name(name)				
				.build();
	}

}
