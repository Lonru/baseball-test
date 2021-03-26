package com.baseball.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baseball.domain.ballpark.Ballpark;
import com.baseball.domain.team.Team;
import com.baseball.service.BallparkService;
import com.baseball.service.TeamService;
import com.baseball.web.dto.CMRespDto;
import com.baseball.web.dto.team.TeamSaveReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class TeamController {
	private final TeamService teamService;
	private final BallparkService ballparkService;

	@GetMapping("/team/saveForm")
	public String saveForm(Model model) {
		List<Ballpark> ballparks = ballparkService.야구장리스트();
		model.addAttribute("ballparks", ballparks);
		return "team/saveForm";
	}
	
	@PostMapping("/team/save")
	public String save(Team team) {
		teamService.팀등록(team);
		return "redirect:/team/list";
	}
	
	@GetMapping("/team/list")
	public String list(Model model) {
		List<Team> teams = teamService.팀리스트();
		model.addAttribute("teams", teams);
		return "/team/list";
	}

	
	@DeleteMapping("/team/{id}")
	public @ResponseBody CMRespDto<?> deleteById(@PathVariable int id) {
		teamService.팀삭제(id);
		return new CMRespDto<>(1, null);
	}
	
}
