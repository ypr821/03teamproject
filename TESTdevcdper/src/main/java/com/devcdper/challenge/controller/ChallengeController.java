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
		model.addAttribute("radioCheck","challengeExploration");
		return "challenge/user/challengeExploration";
	}
	
	@GetMapping("/challengeInsert")
	public String challengeInsert(Model model) {
		model.addAttribute("title", "챌린지 개설하기");
		model.addAttribute("radioCheck","challengeInsert");
		return "challenge/user/challengeInsert";
	}
	
	@GetMapping("/challengeParticipation")
	public String challengeParticipation(Model model) {
		model.addAttribute("title", "챌린지 참여하기");
		model.addAttribute("radioCheck","challengeParticipation");
		return "challenge/user/challengeParticipation";
	}
	
	@GetMapping("/challengeCertification")
	public String challengeCertification(Model model) {
		model.addAttribute("title", "챌린지 인증하기");
		model.addAttribute("radioCheck","challengeCertification");
		return "challenge/user/challengeCertification";
	}
	
	
	@GetMapping("/challengeCertificationInsert")
	public String challengeCertificationInsert(Model model) {
		model.addAttribute("title", "챌린지 인증 등록");
		model.addAttribute("radioCheck","challengeCertificationInsert");
		return "challenge/user/challengeCertificationInsert";
	}
	
	@GetMapping("/challengeDetailInfo")
	public String challengeDetailInfo(Model model) {
		model.addAttribute("title", "챌린지 상세정보");
		model.addAttribute("radioCheck","challengeDetailInfo");
		return "challenge/user/challengeDetailInfo";
	}
	
	@GetMapping("/myChallenge")
	public String myChallenge(Model model) {
		model.addAttribute("title", "나의 챌린지");
		model.addAttribute("radioCheck","myChallenge");
		return "challenge/user/myChallenge";
	}
	
	@GetMapping("/myChallengeInfo")
	public String myChallengeInfo(Model model) {
		model.addAttribute("title", "챌린지 정보 및 인증");
		model.addAttribute("radioCheck","myChallengeInfo");
		return "challenge/user/myChallengeInfo";
	}
	
	@GetMapping("/myChallengeInsertList")
	public String myChallengeInsertList(Model model) {
		model.addAttribute("title", "개설한 챌린지 목록");
		model.addAttribute("radioCheck","myChallengeInsertList");
		return "challenge/user/myChallengeInsertList";
	}
	
	@GetMapping("/myChallengeParticipationList")
	public String myChallengeParticipationList(Model model) {
		model.addAttribute("title", "참여중인 챌린지 목록");
		model.addAttribute("radioCheck","myChallengeParticipationList");
		return "challenge/user/myChallengeParticipationList";
	}
	
	@GetMapping("/myChallengeCompleteList")
	public String myChallengeCompleteList(Model model) {
		model.addAttribute("title", "완료된 챌린지 목록");
		model.addAttribute("radioCheck","myChallengeCompleteList");
		return "challenge/user/myChallengeCompleteList";
	}
	
	@GetMapping("/myChallengeEdit")
	public String myChallengeEdit(Model model) {
		model.addAttribute("title", "챌린지 설정");
		model.addAttribute("radioCheck","myChallengeEdit");
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
