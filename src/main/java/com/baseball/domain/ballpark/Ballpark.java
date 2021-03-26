package com.baseball.domain.ballpark;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

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
public class Ballpark {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;
	
	private String name;
	@OneToOne(mappedBy = "ballpark", cascade = CascadeType.REMOVE)
	private Team team;

}
