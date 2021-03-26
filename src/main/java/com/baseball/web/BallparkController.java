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
import com.baseball.service.BallparkService;
import com.baseball.web.dto.CMRespDto;
import com.baseball.web.dto.ballpark.BallparkSaveReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BallparkController {
	private final BallparkService ballparkService;
	
	@GetMapping({"/", "/ballpark/saveForm"})
	public String saveForm() {
		return "ballpark/saveForm";
	}
	
	@PostMapping("/ballpark/save")
	public String save(Ballpark ballpark) {
		ballparkService.야구장등록(ballpark);
		
		return "redirect:/ballpark/list";
	}
	
	@GetMapping("/ballpark/list")
	public String list(Model model) {
		List<Ballpark> ballparks = ballparkService.야구장리스트();
		model.addAttribute("ballparks", ballparks);
		return "/ballpark/list";
	}

	@DeleteMapping("/ballpark/{id}")
	public @ResponseBody CMRespDto<?> delete(@PathVariable int id) {
		ballparkService.야구장삭제(id);
		return new CMRespDto<>(1, null);
	}
}
