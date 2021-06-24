package com.devcdper.plan.controller;


import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ActionPlanController {
	
	
	/*
	 * private static final Logger log =
	 * LoggerFactory.getLogger(PlanController.class);
	 */	
	
	@PostConstruct
	public void planControllerInit() {
		//log.info("========================================");
		//log.info("PlanController.java 객체 생성");
		//log.info("========================================");
		System.out.println("========================================");
		System.out.println("PlanController.java 객체 생성");
		System.out.println("========================================");		
		}
	
		
	//실천 계획 관리 화면 연결
	@GetMapping("/actionPlan")
		public String actionPlan(Model model) {
			System.out.println("=================================");
			System.out.println("======actionPlan 메서드 실행==========");
			//log.info("========================================");
			//log.info("=======actionPlan 메서드 실행=================");
			model.addAttribute("title", "실천 계획 관리");
			return "plan/actionPlan/actionPlan";
		}
	
	
	//학력 실천 계획 관리 연결
	@GetMapping("/actionEducationalHistory")
		public String actionEducationalHistory (Model model) {
			System.out.println("=================================");
			System.out.println("======actionEducationalHistory 메서드 실행==========");
			//log.info("========================================");
			//log.info("=======actionEducationalHistory 메서드 실행=================");
			model.addAttribute("title", "학력 실천 계획 관리");
			return "plan/actionPlan/actionEducationalHistory";
		}
	
	
	//프로젝트 실천 계획 관리 연결
	@GetMapping("/actionProject")
		public String actionProject (Model model) {
			System.out.println("=================================");
			System.out.println("======actionProject 메서드 실행==========");
			//log.info("========================================");
			//log.info("=======actionProject 메서드 실행=================");
			model.addAttribute("title", "프로젝트 실천 계획 관리");
			return "plan/actionPlan/actionProject";
		}
	
		
	//자격증 실천 계획 관리 연결
	@GetMapping("/actionCertificate")
		public String actionCertificate (Model model) {
			System.out.println("=================================");
			System.out.println("======actionCertificate 메서드 실행==========");
			//log.info("========================================");
			//log.info("=======actionCertificate 메서드 실행=================");
			model.addAttribute("title", "자격증 실천 계획 관리");
			return "plan/actionPlan/actionCertificate";
		}
		
		
	//공인어학 실천 계획 관리 연결
	@GetMapping("/actionCertifiedLanguage")
		public String actionCertifiedLanguage (Model model) {
			System.out.println("=================================");
			System.out.println("======actionCertifiedLanguage 메서드 실행==========");
			//log.info("========================================");
			//log.info("=======actionCertifiedLanguage 메서드 실행=================");
			model.addAttribute("title", "공인어학 실천 계획 관리");
			return "plan/actionPlan/actionCertifiedLanguage";
		}
		
		
	//기술스택 실천 계획 관리 연결
	@GetMapping("/actionTechnologyStack")
		public String actionTechnologyStack (Model model) {
			System.out.println("=================================");
			System.out.println("======actionTechnologyStack 메서드 실행==========");
			//log.info("========================================");
			//log.info("=======actionTechnologyStack 메서드 실행=================");
			model.addAttribute("title", "기술스택 실천 계획 관리");
			return "plan/actionPlan/actionTechnologyStack";
		}	
		
		
	//직종전문교욱과정 실천 계획 관리 연결
	@GetMapping("/actionJobTraining")
		public String actionJobTraining (Model model) {
		System.out.println("=================================");
		System.out.println("======actionJobTraining 메서드 실행==========");
		//log.info("========================================");
		//log.info("=======actionJobTraining 메서드 실행=================");
		model.addAttribute("title", "직종전문교육과정 실천 계획 관리");
		return "plan/actionPlan/actionJobTraining";
		}
	
		
	//인턴십 실천 계획 관리 연결
	@GetMapping("/actionInternship")
		public String actionInternship (Model model) {
		System.out.println("=================================");
		System.out.println("======actionInternship 메서드 실행==========");
		//log.info("========================================");
		//log.info("=======actionInternship 메서드 실행=================");
		model.addAttribute("title", "인턴십 실천 계획 관리");
		return "plan/actionPlan/actionInternship";
		}
	
	
	//공모전 실천 계획 관리 연결
	@GetMapping("/actionContest")
		public String actionContest (Model model) {
		System.out.println("=================================");
		System.out.println("======actionContest 메서드 실행==========");
		//log.info("========================================");
		//log.info("=======actionContest 메서드 실행=================");
		model.addAttribute("title", "공모전 실천 계획 관리");
		return "plan/actionPlan/actionContest";
		}
		
	
	//경력 실천 계획 관리 연결
	@GetMapping("/actionCareer")
		public String actionCareer (Model model) {
		System.out.println("=================================");
		System.out.println("======actionCareer 메서드 실행==========");
		//log.info("========================================");
		//log.info("=======actionCareer 메서드 실행=================");
		model.addAttribute("title", "경력 실천 계획 관리");
		return "plan/actionPlan/actionCareer";
		}	
		
	}
