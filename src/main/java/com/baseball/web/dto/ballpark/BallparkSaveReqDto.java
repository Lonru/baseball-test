package com.baseball.web.dto.ballpark;

import com.baseball.domain.ballpark.Ballpark;

import lombok.Data;

@Data
public class BallparkSaveReqDto {
	private String name;
	private int teamId;
	
	public Ballpark toEntity() {
		return Ballpark.builder()
				.name(name)
				.build();
	}
}
