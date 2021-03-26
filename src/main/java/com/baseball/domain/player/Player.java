package com.baseball.domain.player;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.baseball.domain.team.Team;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Player {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;
	
	private String name;
	private String position;
	@Transient
	private int teamId;

	@JoinColumn(name = "teamId")
	@ManyToOne
	private Team team;

}
