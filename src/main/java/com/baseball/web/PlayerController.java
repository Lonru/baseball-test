package com.baseball.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baseball.domain.player.Player;
import com.baseball.domain.team.Team;
import com.baseball.service.PlayerService;
import com.baseball.service.TeamService;
import com.baseball.web.dto.CMRespDto;
import com.baseball.web.dto.PositionRespDto;
import com.baseball.web.dto.player.PlayerSaveReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class PlayerController {
	
	private final PlayerService playerService;
	private final TeamService teamService;
	
	@GetMapping("/player/saveForm")
	public String saveForm(Model model) {
		
		List<Team> teams = teamService.팀리스트();
		model.addAttribute("teams", teams);
		return "player/saveForm";
	}
	
	@PostMapping("/player/save")
	public String save(Player player) {
		playerService.선수등록(player);
		return "redirect:/player/list";
	}
	
	@GetMapping("/player/list")
	public String list(Model model) {
		List<Player> players = playerService.선수리스트();
		model.addAttribute("players", players);
		return "player/list";
	}
	
	@GetMapping("/player/positionList")
	public String positionList(Model model) {
		List<PositionRespDto> dtos = playerService.포지션별선수리스트();
		model.addAttribute("dtos", dtos);
		return "player/positionList";
	}

	
	@DeleteMapping("/player/{id}")
	public @ResponseBody CMRespDto<?> deleteById(@PathVariable int id) {
		playerService.선수삭제(id);
		return new CMRespDto<>(1, null);
	}
	
}
