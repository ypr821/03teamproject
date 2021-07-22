package com.devcdper.challenge.controller;


import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.devcdper.challenge.domain.Challenge;
import com.devcdper.challenge.domain.ChallengeCategory;
import com.devcdper.challenge.service.ChallengeService;


@Controller
public class AdminChallengeController {
	
	
	//의존성 주입 (생성자 메서드 방식)
	private final ChallengeService challengeService;
	
	public AdminChallengeController(ChallengeService challengeService){
		this.challengeService = challengeService;
	}
	
	
	/*-------------------------------------AdminChallengeControllerInit 메서드 시작----------------------------------------*/
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
	/*-------------------------------------AdminChallengeControllerInit 메서드 끝----------------------------------------*/
	

	/*------------------------------------------------챌린지 관리 시작-----------------------------------------------------*/
	@GetMapping("/adminChallenge")
	public String adminChallenge(Model model, @RequestParam(value="currentPage", required = false, defaultValue = "1") int currentPage, 
											  String challengeName) {
		
		
		List<Challenge> challengeList = challengeService.getChallengeList(currentPage, challengeName);
		List<ChallengeCategory> challengeCategoryList = challengeService.getChallengeCategoryList();
		
		System.out.println("challengeList : "+ challengeList);
		System.out.println("challengeCategoryList : "+ challengeCategoryList);

		/*
			model.addAttribute("currentPage", 					currentPage);
		 * model.addAttribute("lastPage", resultMap.get("lastPage"));
		 * model.addAttribute("pageStartNum", resultMap.get("pageStartNum"));
		 * model.addAttribute("pageEndNum", resultMap.get("pageEndNum"));
		 */
		model.addAttribute("title", "챌린지 개설 관리");
		model.addAttribute("challengeList", challengeList);
		model.addAttribute("challengeCategoryList", challengeCategoryList);
		model.addAttribute("radioCheck", "adminChallenge");
		return "challenge/admin/adminChallenge";
	}
	
	
	@PostMapping("/adminChallenge")
	@ResponseBody
	public String adminChallenge(@RequestParam(name = "challengeCategoryCode", required = false) String challengeCategoryCode, ChallengeCategory challengeCategory) {
	
		
		int modifyChallengeCategoryName = challengeService.modifyChallengeCategoryName(challengeCategory);
		System.out.println("챌린지 카테고리 이름 변경 처리 완료 [modifyChallengeCategoryName] : " + modifyChallengeCategoryName);
		
		//int addChallengeCategory = challengeService.addChallengeCategory(challengeCategory);
		//System.out.println("챌린지 카테고리 추가 처리 완료 [addChallengeCategory] : " + addChallengeCategory);
		
		return "challenge/admin/adminChallenge";
	
	}
	
	@GetMapping("/challengeModalInsertDetail")
	public String challengeModalInsertDetail(Model model) {
		
		model.addAttribute("title", "챌린지 모달");
		model.addAttribute("radioCheck", "challengeModalInsertDetail");
		return "challengeModal/adminChallengeModal/challengeModalInsertDetail";
	}
	/*------------------------------------------------챌린지 관리 끝-----------------------------------------------------*/
	
	
	
	
	/*------------------------------------------------챌린지 참여 관리 시작-----------------------------------------------------*/
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
	/*------------------------------------------------챌린지 참여 관리 끝-----------------------------------------------------*/
	
	
	
	
	/*------------------------------------------------챌린지 신고 관리 시작-----------------------------------------------------*/
	@GetMapping("/adminChallengeReport")
	public String adminChallengeReport(Model model) {
		model.addAttribute("title", "챌린지 신고 관리");
		model.addAttribute("radioCheck", "adminChallengeReport");
		return "challenge/admin/adminChallengeReport";
	}
	/*------------------------------------------------챌린지 신고 관리 끝-----------------------------------------------------*/

	
	
	/*------------------------------------------------챌린지 달성율 관리 시작-----------------------------------------------------*/
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
	/*------------------------------------------------챌린지 달성율 관리 끝-----------------------------------------------------*/
	
	
	/*------------------------------------------------챌린지 최종순위 리스트 시작-----------------------------------------------------*/
	@GetMapping("/adminChallengeRanking")
	public String adminChallengeRanking(Model model) {
		model.addAttribute("title", "챌린지 최종순위 관리");
		model.addAttribute("radioCheck", "adminChallengeRanking");
		return "challenge/admin/adminChallengeRanking";
	}
	/*------------------------------------------------챌린지 최종순위 리스트 끝-----------------------------------------------------*/

	
	/*------------------------------------------------챌린지 보상지급 관리 시작-----------------------------------------------------*/
	@GetMapping("/adminChallengeCompensation")
	public String challengeCompensation(Model model) {
		model.addAttribute("title", "챌린지 보상지급 관리");
		model.addAttribute("radioCheck", "adminChallengeCompensation");
		return "challenge/admin/adminChallengeCompensation";
	}
	/*------------------------------------------------챌린지 보상지급 관리 끝-----------------------------------------------------*/
}
