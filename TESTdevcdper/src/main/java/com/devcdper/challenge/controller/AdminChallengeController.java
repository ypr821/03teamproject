package com.devcdper.challenge.controller;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminChallengeController {
	
	@PostConstruct
	public void AdminChallengeControllerInit() {
		//log.info("========================================");
		//log.info("AdminChallengeController.java 객체 생성");
		//log.info("========================================");
		System.out.println("========================================");
		System.out.println("AdminChallengeController.java 객체 생성");
		System.out.println("========================================");
	}
	
	
	@GetMapping("/mainChallenge")
	public String mainChallenge(Model model) {
		model.addAttribute("title", "두배러 챌린지 메인");
		model.addAttribute("radioCheck","mainChallenge");
		return "challenge/mainChallenge";
		
	}
	
	@GetMapping("/adminChallenge")
	public String adminChallenge(Model model) {
		model.addAttribute("title", "챌린지 개설 관리");
		model.addAttribute("radioCheck","adminChallenge");
		return "challenge/adminChallenge";
		
	}
	
	
	@GetMapping("/adminChallengeCategory")
	public String adminChallengeCategory(Model model) {
		model.addAttribute("title", "챌린지 카테고리 관리");
		model.addAttribute("radioCheck","adminChallengeCategory");
		return "challenge/adminChallengeCategory";
		
	}
	
	@GetMapping("/adminChallengeParticipation")
	public String adminChallengeParticipation(Model model) {
		model.addAttribute("title", "챌린지 참여 관리");
		model.addAttribute("radioCheck","adminChallengeParticipation");
		return "challenge/adminChallengeParticipation";
		
	}
	
	@GetMapping("/adminChallengeCertification")
	public String adminChallengeCertification(Model model) {
		model.addAttribute("title", "챌린지 인증 관리");
		model.addAttribute("radioCheck","adminChallengeCertification");
		return "challenge/adminChallengeCertification";
		
	}
	
	@GetMapping("/adminChallengeReport")
	public String adminChallengeReport(Model model) {
		model.addAttribute("title", "챌린지 신고 관리");
		model.addAttribute("radioCheck","adminChallengeReport");
		return "challenge/adminChallengeReport";
		
	}
	
	@GetMapping("/adminChallengeAchievement")
	public String adminChallengeAchievement(Model model) {
		model.addAttribute("title", "챌린지 달성율 관리");
		model.addAttribute("radioCheck","adminChallengeAchievement");
		return "challenge/adminChallengeAchievement";
		
	}
	
	@GetMapping("/adminChallengeCompensation")
	public String challengeCompensation(Model model) {
		model.addAttribute("title", "챌린지 보상지급 관리");
		model.addAttribute("radioCheck","adminChallengeCompensation");
		return "challenge/adminChallengeCompensation";
		
	}

}
