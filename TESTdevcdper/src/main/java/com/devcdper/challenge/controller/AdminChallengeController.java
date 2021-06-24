package com.devcdper.challenge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminChallengeController {
	
	@GetMapping("/mainChallenge")
	public String mainChallenge(Model model) {
		model.addAttribute("title", "두배러 챌린지 메인");
		return "challenge/mainChallenge";
		
	}
	
	@GetMapping("/adminChallenge")
	public String adminChallenge(Model model) {
		model.addAttribute("title", "챌린지 관리");
		return "challenge/adminChallenge";
		
	}
	
	@GetMapping("/adminChallengeCategory")
	public String adminChallengeCategory(Model model) {
		model.addAttribute("title", "챌린지 카테고리 관리");
		return "challenge/adminChallengeCategory";
		
	}
	
	@GetMapping("/adminChallengeParticipation")
	public String adminChallengeParticipation(Model model) {
		model.addAttribute("title", "챌린지 참여 관리");
		return "challenge/adminChallengeParticipation";
		
	}
	
	@GetMapping("/adminChallengeCertification")
	public String adminChallengeCertification(Model model) {
		model.addAttribute("title", "챌린지 인증 관리");
		return "challenge/adminChallengeCertification";
		
	}
	
	@GetMapping("/adminChallengeReport")
	public String adminChallengeReport(Model model) {
		model.addAttribute("title", "챌린지 신고 관리");
		return "challenge/adminChallengeReport";
		
	}
	
	@GetMapping("/adminChallengeAchievement")
	public String adminChallengeAchievement(Model model) {
		model.addAttribute("title", "챌린지 달성율 관리");
		return "challenge/adminChallengeAchievement";
		
	}
	
	@GetMapping("/adminChallengeCompensation")
	public String challengeCompensation(Model model) {
		model.addAttribute("title", "챌린지 보상지급 관리");
		return "challenge/adminChallengeCompensation";
		
	}

}