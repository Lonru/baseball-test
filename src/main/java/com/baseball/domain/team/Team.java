package com.baseball.domain.team;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.baseball.domain.ballpark.Ballpark;
import com.baseball.domain.player.Player;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Team {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;
	
	private String name;
	@JoinColumn(name = "ballparkId")
	@OneToOne(cascade = CascadeType.DETACH)
	private Ballpark ballpark;
	@Transient // DB에 칼럼을 만들지 않느다.
	private int ballparkId;

	@OneToMany(mappedBy = "team")
	private List<Player> players;

}
