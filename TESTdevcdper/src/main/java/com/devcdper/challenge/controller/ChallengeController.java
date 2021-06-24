package com.devcdper.challenge.controller;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChallengeController {
	

	@PostConstruct
	public void ChallengeControllerInit() {
		//log.info("========================================");
		//log.info("ChallengeControllerInit.java 객체 생성");
		//log.info("========================================");
		System.out.println("========================================");
		System.out.println("ChallengeController.java 객체 생성");
		System.out.println("========================================");
	}
	
	
	@GetMapping("/challengeExploration")
	public String challengeExploration(Model model) {
		model.addAttribute("title", "챌린지 탐색하기");
		return "challenge/challengeExploration";
	}
	
	@GetMapping("/challengeInsert")
	public String challengeInsert(Model model) {
		model.addAttribute("title", "챌린지 개설하기");
		return "challenge/challengeInsert";
	}
	
	@GetMapping("/challengeInsertNext")
	public String challengeInsertNext(Model model) {
		model.addAttribute("title", "챌린지 개설하기");
		return "challenge/challengeInsertNext";
	}
	
	@GetMapping("/challengeParticipation")
	public String challengeParticipation(Model model) {
		model.addAttribute("title", "챌린지 참여하기");
		return "challenge/challengeParticipation";
	}
	
	@GetMapping("/challengeCertification")
	public String challengeCertification(Model model) {
		model.addAttribute("title", "챌린지 인증하기");
		return "challenge/challengeCertification";
	}
	
	@GetMapping("/challengeDetailInfo")
	public String challengeDetailInfo(Model model) {
		model.addAttribute("title", "챌린지 상세정보");
		return "challenge/challengeDetailInfo";
	}
	
	
	

}
