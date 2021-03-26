package com.baseball.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baseball.domain.ballpark.Ballpark;
import com.baseball.domain.ballpark.BallparkRepository;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class BallparkService {
	private final BallparkRepository ballparkRepository;
	
	@Transactional
	public void 야구장등록(Ballpark ballpark) {
		ballparkRepository.save(ballpark);
	}
	
	@Transactional(readOnly = true)
	public List<Ballpark> 야구장리스트(){
		return ballparkRepository.findAll();
	}

	@Transactional
	public void 야구장삭제(int id) {
		ballparkRepository.deleteById(id);
	}
	
}
