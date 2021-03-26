package com.baseball.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PositionRespDto {
	private String position;
	private String nc;
	private String lotte;
	private String kia;
}
