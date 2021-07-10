package com.devcdper.challenge.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.devcdper.challenge.domain.Challenge;
import com.devcdper.challenge.domain.ChallengeCategory;
import com.devcdper.challenge.domain.ChallengeCertification;
import com.devcdper.challenge.service.ChallengeService;

@Controller
public class ChallengeController {

	// 의존성 주입 (생성자 메서드 방식)
	private final ChallengeService challengeService;

	public ChallengeController(ChallengeService challengeService) {
		this.challengeService = challengeService;
	}

	@PostConstruct
	public void ChallengeControllerInit() {
		// log.info("========================================");
		// log.info("ChallengeControllerInit.java 객체 생성");
		// log.info("========================================");
		System.out.println("========================================");
		System.out.println("ChallengeController.java 객체 생성");
		System.out.println("========================================");
	}

	@GetMapping("/challengeExploration")
	public String challengeExploration(Model model) {
		List<Challenge> challengeExplorationList = challengeService.getChallengeExplorationList();

		model.addAttribute("title", "챌린지 탐색하기");
		model.addAttribute("radioCheck", "challengeExploration");
		model.addAttribute("challengeExplorationList", challengeExplorationList);
		return "challenge/user/challengeExploration";
	}

	@PostMapping(value = "/byCategory")
	public @ResponseBody List<Challenge> byCategory(@RequestParam Map<String, Object> categoryVal) {
		
		
		//map.put(categoryVal, categoryVal);
		List<Challenge> BycategoryList = challengeService.getChallengeByCategoryExplorationList(categoryVal);
		System.out.println("BycategoryList>>" + BycategoryList);
		
		return BycategoryList;

		/*
		 * Map<String, Object> cateMap = new HashMap<String, Object>();
		 * cateMap.put("categoryVal", categoryVal); List<Challenge>
		 * challengeByCategoryExplorationList =
		 * challengeService.getChallengeByCategoryExplorationList(cateMap);
		 * System.out.println("challengeByCategoryExplorationList" +
		 * challengeByCategoryExplorationList);
		 * 
		 * return challengeByCategoryExplorationList;
		 */

		/*
		 * Map<String, Object> cateMap = (Map<String, Object>)
		 * challengeService.getChallengeByCategoryExplorationList(categoryVal);
		 * ModelAndView categoryAjaxList = new ModelAndView();
		 * categoryAjaxList.setViewName("challengeExploation");
		 * categoryAjaxList.addObject("cateMap", cateMap.get(cateMap));
		 * 
		 * return categoryAjaxList;
		 */

		/*
		 * System.out.println("categoryVal>>>"+ categoryVal); Map<String, Object>
		 * cateMap = new HashMap<String, Object>(); cateMap.put("categoryVal",
		 * categoryVal);
		 * 
		 * List<Challenge> challengeByCategoryExplorationList =
		 * challengeService.getChallengeByCategoryExplorationList(cateMap);
		 * System.out.println("challengeByCategoryExplorationList >>>"+
		 * challengeByCategoryExplorationList);
		 * 
		 * model.addAttribute("categoryVal", categoryVal);
		 * model.addAttribute("challengeByCategoryExplorationList",
		 * challengeByCategoryExplorationList);
		 * 
		 * categoryAjaxList.setViewName("challengeExploation");
		 * categoryAjaxList.addObject("categoryVal", categoryVal);
		 * categoryAjaxList.addObject("challengeByCategoryExplorationList",
		 * challengeByCategoryExplorationList);
		 * 
		 * System.out.println("========================================");
		 * //System.out.println("challengeByCategoryExplorationList 카테고리별 챌린지 리스트: " +
		 * challengeByCategoryExplorationList.toString());
		 * System.out.println("ModelAndView categoryAjaxList: " + model.toString());
		 * System.out.println("============================================");
		 * 
		 * return challengeByCategoryExplorationList;
		 */

	}

	@GetMapping("/challengeInsert")
	public String challengeInsert(Model model) {
		model.addAttribute("title", "챌린지 개설하기");
		model.addAttribute("radioCheck", "challengeInsert");
		return "challenge/user/challengeInsert";
	}

	@PostMapping("/challengeInsert")
	public String challengeInsert(Challenge challenge) {

		System.out.println("============================================");
		System.out.println("화면에 입력 받은 값(챌린지 개설): " + challenge.toString());
		System.out.println("============================================");

		challengeService.addChallenge(challenge);

		return "challenge/user/myChallenge";
	}
	
	
	
	
	

	@GetMapping("/challengeParticipation")
	public String challengeParticipation(@RequestParam(name = "challengeName", required = false) String challengeName, Model model) {
		
		System.out.println("============================================");
		System.out.println("화면에 입력 받은 값(챌린지 참여하기 : 상세정보): " + challengeName.toString());
		System.out.println("============================================");
		
		Challenge challenge = challengeService.getChallengeExplorationDetailInfoByChallengeName(challengeName);
		
		model.addAttribute("challenge", challenge);
		model.addAttribute("title", "챌린지 참여하기");
		model.addAttribute("radioCheck", "challengeParticipation");
		return "challenge/user/challengeParticipation";
	}

	@GetMapping("/challengeCertification")
	public String challengeCertification(Model model) {

		List<ChallengeCertification> verifiableChallengeList = challengeService.getVerifiableChallengeList();

		model.addAttribute("title", "챌린지 인증하기");
		model.addAttribute("radioCheck", "challengeCertification");
		model.addAttribute("verifiableChallengeList", verifiableChallengeList);
		return "challenge/user/challengeCertification";
	}

	@GetMapping("/challengeCertificationInsert")
	public String challengeCertificationInsert(@RequestParam(name = "challengeName", required = false) String challengeName, 
					Model model) {
		
		System.out.println("============================================");
		System.out.println("화면에 입력 받은 값(챌린지 인증 등록): " + challengeName.toString());
		System.out.println("============================================");
		
		Challenge challenge = challengeService.getChallengeCertificationInfoByChallengeName(challengeName);
		
		model.addAttribute("challenge", challenge);
		model.addAttribute("title", "챌린지 인증 등록");
		model.addAttribute("radioCheck", "challengeCertificationInsert");
		return "challenge/user/challengeCertificationInsert";
	}

	@PostMapping("/challengeCertificationInsert")
	public String challengeCertificationInsert(ChallengeCertification challengeCertification) {

		System.out.println("============================================");
		System.out.println("화면에 입력 받은 값(챌린지 인증하기): " + challengeCertification.toString());
		System.out.println("============================================");

		challengeService.addChallengeCertification(challengeCertification);

		return "challenge/user/challengeCertificationBoard";
	}

	@GetMapping("/challengeCertificationBoard")
	public String challengeCertificationBoard(Model model) {
		model.addAttribute("title", "챌린지 인증 게시판");
		model.addAttribute("radioCheck", "challengeCertificationBoard");
		return "challenge/user/challengeCertificationBoard";
	}

	@GetMapping("/challengeCertificationBoardView")
	public String challengeCertificationBoardView(Model model) {
		model.addAttribute("title", "챌린지 인증 게시판");
		model.addAttribute("radioCheck", "challengeCertificationBoardView");
		return "challenge/user/challengeCertificationBoardView";
	}

	@GetMapping("/myChallenge")
	public String myChallenge(Model model) {
		model.addAttribute("title", "나의 챌린지");
		model.addAttribute("radioCheck", "myChallenge");
		return "challenge/user/myChallenge";
	}

	@GetMapping("/challengeExplorationDetailInfo")
	public String challengeExplorationDetailInfo(
			@RequestParam(name = "challengeName", required = false) String challengeName, Model model) {

		System.out.println("============================================");
		System.out.println("화면에 입력 받은 값(챌린지 탐색 : 상세정보): " + challengeName.toString());
		System.out.println("============================================");

		Challenge challenge = challengeService.getChallengeExplorationDetailInfoByChallengeName(challengeName);

		model.addAttribute("challenge", challenge);
		model.addAttribute("title", "챌린지 상세 정보");
		model.addAttribute("radioCheck", "challengeExplorationDetailInfo");
		return "challenge/user/challengeExplorationDetailInfo";
	}

	@GetMapping("/myChallengeDetailInfo")
	public String myChallengeDetailInfo(Model model) {
		model.addAttribute("title", "챌린지 상세 정보");
		model.addAttribute("radioCheck", "myChallengeDetailInfo");
		return "challenge/user/myChallengeDetailInfo";
	}

	@GetMapping("/myChallengeInsertList")
	public String myChallengeInsertList(Model model) {
		model.addAttribute("title", "개설한 챌린지 목록");
		model.addAttribute("radioCheck", "myChallengeInsertList");
		return "challenge/user/myChallengeInsertList";
	}

	@GetMapping("/myChallengeParticipationList")
	public String myChallengeParticipationList(Model model) {
		model.addAttribute("title", "참여중인 챌린지 목록");
		model.addAttribute("radioCheck", "myChallengeParticipationList");
		return "challenge/user/myChallengeParticipationList";
	}

	@GetMapping("/myChallengeCompleteList")
	public String myChallengeCompleteList(Model model) {
		model.addAttribute("title", "완료된 챌린지 목록");
		model.addAttribute("radioCheck", "myChallengeCompleteList");
		return "challenge/user/myChallengeCompleteList";
	}

	@GetMapping("/myChallengeEdit")
	public String myChallengeEdit(Model model) {
		model.addAttribute("title", "챌린지 설정");
		model.addAttribute("radioCheck", "myChallengeEdit");
		return "challenge/user/myChallengeEdit";
	}

	@GetMapping("/payment")
	public String payment(Model model) {
		model.addAttribute("title", "챌린지 결제 관리");
		return "paymentRefund/payment";
	}

	@GetMapping("/refund")
	public String refund(Model model) {
		model.addAttribute("title", "챌린지 환불 관리");
		return "paymentRefund/refund";
	}

}
