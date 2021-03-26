package com.baseball.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baseball.domain.ballpark.Ballpark;
import com.baseball.domain.ballpark.BallparkRepository;
import com.baseball.domain.team.Team;
import com.baseball.domain.team.TeamRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TeamService {

	private final TeamRepository teamRepository;
	private final BallparkRepository ballparkRepository;
	
	@Transactional
	public void 팀등록(Team team) {
		Ballpark ballparkEntity = ballparkRepository.findById(team.getBallparkId()).get();
		team.setBallpark(ballparkEntity);
		teamRepository.save(team);
	}
	
	@Transactional(readOnly = true)
	public List<Team> 팀리스트(){
		return teamRepository.findAll();
	}

	@Transactional
	public void 팀삭제(int id) {
		teamRepository.deleteById(id);
	}
	
}
