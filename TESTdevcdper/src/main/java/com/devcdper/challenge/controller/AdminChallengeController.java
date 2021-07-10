package com.devcdper.challenge.controller;


import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.devcdper.challenge.domain.Challenge;
import com.devcdper.challenge.service.ChallengeService;


@Controller
public class AdminChallengeController {
	
	
	//의존성 주입 (생성자 메서드 방식)
	private final ChallengeService challengeService;
	
	public AdminChallengeController(ChallengeService challengeService){
		this.challengeService = challengeService;
	}
	
	

	@PostConstruct
	public void AdminChallengeControllerInit() {

		/*
		 * log.info("========================================");
		 * log.info("AdminChallengeController.java 객체 생성");
		 * log.info("========================================");
		 */

		
		 System.out.println("========================================");
		 System.out.println("AdminChallengeController.java 객체 생성");
		 System.out.println("========================================");
		 
	}

	@GetMapping("/mainChallenge")
	public String mainChallenge(Model model) {
		
		List<Challenge> challengeExplorationList = challengeService.getChallengeExplorationList();
		
		model.addAttribute("title", "두배러 챌린지 메인");
		model.addAttribute("radioCheck", "mainChallenge");
		model.addAttribute("challengeExplorationList", challengeExplorationList);
		return "challenge/mainChallenge";
	}

	@GetMapping("/adminChallenge")
	public String adminChallenge(Model model, @RequestParam(value="currentPage", required = false, defaultValue = "1") int currentPage) {
		
		Map<String, Object> resultMap = challengeService.getChallengeList(currentPage);
		
		model.addAttribute("title", "챌린지 개설 관리");
		model.addAttribute("currentPage", 					currentPage);
		model.addAttribute("lastPage", 						resultMap.get("lastPage"));
		model.addAttribute("pageStartNum", 					resultMap.get("pageStartNum"));
		model.addAttribute("pageEndNum", 					resultMap.get("pageEndNum"));
		model.addAttribute("challengeList", 				resultMap.get("challengeList"));
		model.addAttribute("radioCheck", "adminChallenge");
		return "challenge/admin/adminChallenge";
	}

	@GetMapping("/adminChallengeParticipation")
	public String adminChallengeParticipation(Model model, @RequestParam(value="currentPage", required = false, defaultValue = "1") int currentPage) {
		
		Map<String, Object> resultMap = challengeService.getChallengeParticipationList(currentPage);
		
		model.addAttribute("title", "챌린지 참여 관리");
		model.addAttribute("currentPage", 					currentPage);
		model.addAttribute("lastPage", 						resultMap.get("lastPage"));
		model.addAttribute("pageStartNum", 					resultMap.get("pageStartNum"));
		model.addAttribute("pageEndNum", 					resultMap.get("pageEndNum"));
		model.addAttribute("challengeParticipationList", 	resultMap.get("challengeParticipationList"));
		model.addAttribute("radioCheck", "adminChallengeParticipation");
		return "challenge/admin/adminChallengeParticipation";
	}

	@GetMapping("/adminChallengeReport")
	public String adminChallengeReport(Model model) {
		model.addAttribute("title", "챌린지 신고 관리");
		model.addAttribute("radioCheck", "adminChallengeReport");
		return "challenge/admin/adminChallengeReport";
	}

	@GetMapping("/adminChallengeAchievement")
	public String adminChallengeAchievement(Model model, @RequestParam(value="currentPage", required = false, defaultValue = "1") int currentPage) {
		
		Map<String, Object> resultMap = challengeService.getChallengeAchievementRateList(currentPage);
		
		model.addAttribute("title", "챌린지 달성율 관리");
		model.addAttribute("currentPage", 					currentPage);
		model.addAttribute("lastPage", 						resultMap.get("lastPage"));
		model.addAttribute("pageStartNum", 					resultMap.get("pageStartNum"));
		model.addAttribute("pageEndNum", 					resultMap.get("pageEndNum"));
		model.addAttribute("challengeAchievementRateList", 	resultMap.get("challengeAchievementRateList"));
		model.addAttribute("radioCheck", "adminChallengeAchievement");
		return "challenge/admin/adminChallengeAchievement";
	}

	@GetMapping("/adminChallengeRanking")
	public String adminChallengeRanking(Model model) {
		model.addAttribute("title", "챌린지 최종순위 관리");
		model.addAttribute("radioCheck", "adminChallengeRanking");
		return "challenge/admin/adminChallengeRanking";
	}

	@GetMapping("/adminChallengeCompensation")
	public String challengeCompensation(Model model) {
		model.addAttribute("title", "챌린지 보상지급 관리");
		model.addAttribute("radioCheck", "adminChallengeCompensation");
		return "challenge/admin/adminChallengeCompensation";
	}

}
