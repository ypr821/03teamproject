package com.devcdper.plan.controller;

import javax.annotation.PostConstruct;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class DetailPlanController {

	//private static final Logger log = LoggerFactory.getLogger(DetailPlanController.class);
	
	@PostConstruct
	public void detailPlanControllerInit() {
		//log.info("==========================================");
		//log.info("detailPlanController 객체 생성");
		//log.info("==========================================");
		System.out.println("======================================");
		System.out.println("detailPlanController 객체 생성");
		System.out.println("======================================");
	}
	
	
	//header에 경력계획관리를 누르면-> left메뉴에서 계획관리 토글이 내려가면서 보여지게끔 해야됨.(?)
	//그런데 계획 관리가 두개네...메인메뉴랑 서브메뉴이름이 같네? 흐음...
	
	
	//상세 계획 관리 화면 (카테고리 9가지 간단하게 담기-> 상세한건 따로 페이지 이동)
	@GetMapping("/detailPlan")
	public String detailPlan(Model model) {
		//log.info("==============================================");
		//log.info("detailPlan 메서드 실행");
		//log.info("==============================================");
		System.out.println("==============================================");
		System.out.println("detailPlan 메서드 실행");
		System.out.println("==============================================");
		model.addAttribute("title","상사계획 관리 화면");
		return "plan/detailPlan/detailPlan";
	}
	//학력 상세 계획 관리
	@GetMapping("/planEducationalHistoryDetail")
	public String planEducationalHistoryDetail(Model model) {
		//log.info("==============================================");
		//log.info("planEducationalHistoryDetail 메서드 실행");
		//log.info("==============================================");
		System.out.println("==============================================");
		System.out.println("planEducationalHistoryDetail 메서드 실행");
		System.out.println("==============================================");
		model.addAttribute("title", "학력 상세 계획 관리");
		return "plan/detailPlan/planEducationalHistoryDetail";
	}
	//프로젝트 상세 계획 관리
	@GetMapping("/planProjectDetail")
	public String planProjectDetail(Model model) {
		//log.info("==============================================");
		//log.info("planProjectDetail 메서드 실행");
		//log.info("==============================================");
		System.out.println("==============================================");
		System.out.println("planProjectDetail 메서드 실행");
		System.out.println("==============================================");
		model.addAttribute("title", "프로젝트 상세 계획");
		return "plan/detailPlan/planProjectDetail";
	}
	//자격증 상세 계획 관리
	@GetMapping("/planCertificateDetail")
	public String planCertificateDetail(Model model) {
		//log.info("==============================================");
		//log.info("planCertificateDetail 메서드 실행");
		//log.info("==============================================");
		System.out.println("==============================================");
		System.out.println("planCertificateDetail 메서드 실행");
		System.out.println("==============================================");
		model.addAttribute("title", "자격증 상세 계획");
		return "plan/detailPlan/planCertificateDetail";
	}
	//공인어학 상세 계획 관리
	@GetMapping("/planCertifiedLanguageDetail")
	public String planCertifiedLanguageDetail(Model model) {
		//log.info("==============================================");
		//log.info("planCertifiedLanguageDetail 메서드 실행");
		//log.info("==============================================");
		System.out.println("==============================================");
		System.out.println("planCertifiedLanguageDetail 메서드 실행");
		System.out.println("==============================================");
		model.addAttribute("title", "공인어학 상세 계획");
		return "plan/detailPlan/planCertifiedLanguageDetail";
	}
	//기술스택 상세 계획 관리
	@GetMapping("/planTechnologyStackDetail")
	public String planTechnologyStackDetail(Model model) {
		//log.info("==============================================");
		//log.info("planTechnologyStackDetail 메서드 실행");
		//log.info("==============================================");
		System.out.println("==============================================");
		System.out.println("planTechnologyStackDetail 메서드 실행");
		System.out.println("==============================================");
		model.addAttribute("title", "기술스택 상세 계획");
		return "plan/detailPlan/planTechnologyStackDetail";
	}
	//직종전문교육과정 상세 계획 관리
	@GetMapping("/planJobTrainingDetail")
	public String planJobTrainingDetail(Model model) {
		//log.info("==============================================");
		//log.info("planJobTrainingDetail 메서드 실행");
		//log.info("==============================================");
		System.out.println("==============================================");
		System.out.println("planJobTrainingDetail 메서드 실행");
		System.out.println("==============================================");
		model.addAttribute("title", "직종전문교육과정 상세 계획");
		return "plan/detailPlan/planJobTrainingDetail";
	}
	//인턴십 상세 계획 관리
	@GetMapping("/planInternshipDetail")
	public String planInternshipDetail(Model model) {
		//log.info("==============================================");
		//log.info("planInternshipDetail 메서드 실행");
		//log.info("==============================================");
		System.out.println("==============================================");
		System.out.println("planInternshipDetail 메서드 실행");
		System.out.println("==============================================");
		model.addAttribute("title", "인턴십 상세 계획");
		return "plan/detailPlan/planInternshipDetail";
	}
	//공모전 상세 계획 관리
	@GetMapping("/planContestDetail")
	public String planContestDetail(Model model) {
		//log.info("==============================================");
		//log.info("planContestDetail 메서드 실행");
		//log.info("==============================================");
		System.out.println("==============================================");
		System.out.println("planContestDetail 메서드 실행");
		System.out.println("==============================================");
		model.addAttribute("title", "공모전 상세 계획");
		return "plan/detailPlan/planContestDetail";
	}
	//경력 상세 계획 관리
	@GetMapping("/planCareerDetail")
	public String planCareerDetail(Model model) {
		//log.info("==============================================");
		//log.info("planCareerDetail 메서드 실행");
		//log.info("==============================================");
		System.out.println("==============================================");
		System.out.println("planCareerDetail 메서드 실행");
		System.out.println("==============================================");
//		model.addAttribute("title", "경력 상세 계획");
		return "plan/detailPlan/planCareerDetail";
	}
	
	
	
	
}
