package com.devcdper.coaching.controller;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CoachingController {
	
	//private static final Logger log = LoggerFactory.getLogger(CoachingController.class);
	@PostConstruct
	public void coachingControllerInit() {
		//log.info("========================================");
		//log.info("CoachingController.java 객체 생성");
		//log.info("========================================");
		System.out.println("========================================");
		System.out.println("CoachingController.java 객체 생성");
		System.out.println("========================================");
		
	}
	
	//코칭 관리자 화면
	@GetMapping("/coachingAdminPage")
	public String coachingAdminPage(Model model) {
		System.out.println("=========================================");
		System.out.println("======coachingAdminPage 메서드 실행==========");
		//log.info("========================================");
		//log.info("=======myCoachingCoach 메서드 실행=================");
		model.addAttribute("title", "코칭관리자페이지 ");
		return "coaching/coachingAdminPage";
	}
	//코치  프로필 화면
	@GetMapping("/coachProfile")
	public String coachProfile(Model model) {
		System.out.println("=========================================");
		System.out.println("======coachProfile 메서드 실행==========");
		//log.info("========================================");
		//log.info("=======myCoachingCoach 메서드 실행=================");
		model.addAttribute("title", "코치  프로필 ");
		return "coaching/coachProfile";
	}
	//나의 코칭(코치) 화면
	@GetMapping("/myCoachingCoach")
	public String myCoaching(Model model) {
		System.out.println("=========================================");
		System.out.println("======myCoachingCoach 메서드 실행==========");
		//log.info("========================================");
		//log.info("=======myCoachingCoach 메서드 실행=================");
		model.addAttribute("title", "나의 코칭 화면");
		return "coaching/myCoachingCoach";
	}
	//코칭서비스 사용자 페이지 화면
	@GetMapping("/myCoachingClient")
	public String myCoachingClient(Model model) {
		System.out.println("=========================================");
		System.out.println("======myCoachingClient 메서드 실행==========");
		//log.info("========================================");
		//log.info("=======myCoachingClient 메서드 실행=================");
		model.addAttribute("title", "나의 코칭 화면");
		return "coaching/myCoachingClient";
	}
	//코칭 견적결과 등록 화면
	@GetMapping("/coachingRFQResult")
	public String coachingRFQResult(Model model) {
		System.out.println("=========================================");
		System.out.println("======coachingRFQResult 메서드 실행==========");
		//log.info("========================================");
		//log.info("=======coachingRFQ 메서드 실행=================");
		model.addAttribute("title", "코칭 견적결과 화면");
		return "coaching/coachingRFQResult";
	}
	
	
	//코칭 견적요청화면
	@GetMapping("/coachingRFQ")
	public String coachingRFQ(Model model) {
		System.out.println("=========================================");
		System.out.println("======coachingRFQ 메서드 실행==========");
		//log.info("========================================");
		//log.info("=======coachingRFQ 메서드 실행=================");
		model.addAttribute("title", "멘토링 관리 화면");
		return "coaching/coachingRFQ";
	}
	
	//멘토링 관리화면 연결
	@GetMapping("/mentoring")
	public String mentoring(Model model) {
		System.out.println("=========================================");
		System.out.println("======mentoring 메서드 실행==========");
		//log.info("========================================");
		//log.info("=======coachAdmin 메서드 실행=================");
		model.addAttribute("title", "멘토링 관리 화면");
		return "coaching/mentoring";
	}
	
	//컨설팅 관리화면 연결
	@GetMapping("/consulting")
	public String consulting(Model model) {
		System.out.println("=========================================");
		System.out.println("======consulting 메서드 실행==========");
		//log.info("========================================");
		//log.info("=======coachAdmin 메서드 실행=================");
		model.addAttribute("title", "컨설팅 관리 화면");
		return "coaching/consulting";
	}
	
	//코치 관리화면 연결
	@GetMapping("/coachAdmin")
	public String coachAdmin(Model model) {
		System.out.println("=========================================");
		System.out.println("======coachAdmin 메서드 실행==========");
		//log.info("========================================");
		//log.info("=======coachAdmin 메서드 실행=================");
		model.addAttribute("title", "코치 관리 화면");
		return "coaching/coachAdmin";
	}
	
	//코칭 리뷰 화면
	@GetMapping("/coachingReview")
	public String coachingReview(Model model) {
		System.out.println("=========================================");
		System.out.println("======coachingReview 메서드 실행==========");
		//log.info("========================================");
		//log.info("=======coachingReview 메서드 실행=================");
		model.addAttribute("title", "코칭 리뷰 화면");
		return "coaching/coachingReview";
	}
	
	//메인코칭 화면 연결
	@GetMapping("/mainCoaching")
	public String mainCoaching(Model model) {
		System.out.println("=========================================");
		System.out.println("======mainCoaching 메서드 실행==========");
		//log.info("========================================");
		//log.info("=======getmainCoaching 메서드 실행=================");
		model.addAttribute("title", "코칭 메인 화면");
		return "coaching/mainCoaching";
	}
}
