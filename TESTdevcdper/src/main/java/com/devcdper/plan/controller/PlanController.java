package com.devcdper.plan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PlanController {
	
	
	/*------------------------------------------------나의 계획 한눈에 보기 Start-----------------------------------------------------*/
	@GetMapping("/mainCdp")
	public String mainCdp(Model model) {
		model.addAttribute("title", "나의 계획 한눈에 보기");
		return "plan/mainCdp";
	}
	/*------------------------------------------------나의 계획 한눈에 보기 End-----------------------------------------------------*/
	/*---------------------------------------------:::: 통합계획 Start ::::-----------------------------------------------------*/
	@GetMapping("/totalPlan")
	public String totalPlan(Model model) {
		model.addAttribute("title", "통합계획");
		return "plan/totalPlan/totalPlan";
	}
	
	/*------------------------------------------------통합계획등록 Start-----------------------------------------------------*/
	@GetMapping("/addTotalPlan")
	public String addTotalPlan(Model model) {
		model.addAttribute("title", "통합계획등록");
		return "plan/totalPlan/addTotalPlan";
	}
	@PostMapping("/addTotalPlan")
	public String addTotalPlan() {
		
		return "redirect:/totalPlan";
	}
	/*------------------------------------------------통합계획등록 End-----------------------------------------------------*/
	/*------------------------------------------------통합계획수정 Start-----------------------------------------------------*/
	@GetMapping("/modifyTotalPlan")
	public String modifyTotalPlan(Model model) {
		model.addAttribute("title", "통합계획수정");
		return"plan/totalPlan/modifyTotalPlan";
	}
	
	@PostMapping("/modifyTotalPlan")
	public String modifyTotalPlan() {
		
		return"redirect:/totalPlan";
	}
	/*------------------------------------------------통합계획수정 End-----------------------------------------------------*/
	/*------------------------------------------------통합계획삭제 Start-----------------------------------------------------*/
	@GetMapping("/deleteTotalPlan")
	public String deleteTotalPlan() {
		return"redirect:/totalPlan";
	}
	/*------------------------------------------------통합계획삭제 End-----------------------------------------------------*/
	/*--------------------------------------------:::: 통합계획 End ::::-----------------------------------------------------*/
	
	/*--------------------------------------------:::: 계획 Start ::::-----------------------------------------------*/
	@GetMapping("/plan")
	public String plan(Model model) {
		model.addAttribute("title", "계획");
		return "plan/plan/plan";
	}
	
	/*------------------------------------------------addPlan Start-----------------------------------------------------*/
	@GetMapping("/addPlan")
	public String addPlan(Model model) {
		model.addAttribute("title", "계획등록");
		return "plan/plan/addPlan";
	}
	@PostMapping("/addPlan")
	public String addPlan() {
		
		return "redirect:/plan";
	}
	/*------------------------------------------------addPlan End-----------------------------------------------------*/
	/*------------------------------------------------modifyPlan Start-----------------------------------------------------*/
	@GetMapping("/modifyPlan")
	public String modifyPlan(Model model) {
		model.addAttribute("title", "계획수정");
		return"plan/plan/modifyPlan";
	}
	
	@PostMapping("/modifyPlan")
	public String modifyPlan() {
		
		return"redirect:/plan";
	}
	/*------------------------------------------------modifyPlan End-----------------------------------------------------*/
	/*------------------------------------------------deleteTotalPlan Start-----------------------------------------------------*/
	@GetMapping("/deletePlan")
	public String deletePlan() {
		return"redirect:/plan";
	}
	/*------------------------------------------------deleteTotalPlan End-----------------------------------------------------*/
	/*------------------------------------------------학력 계획 관리 Start-----------------------------------------------------*/
	@GetMapping("/planEducationalHistory")
	public String planEducationalHistory(Model model) {
	System.out.println("==============================================");
	System.out.println("planEducationalHistory 메서드 실행");
	System.out.println("==============================================");
	model.addAttribute("title", "학력 계획 관리");
	return "plan/plan/planEducationalHistory";
	}
	/*------------------------------------------------학력 계획 관리 End-----------------------------------------------------*/
	/*------------------------------------------------프로젝트 계획 관리 Start-----------------------------------------------------*/
	@GetMapping("/planProject")
	public String planProject(Model model) {
	System.out.println("==============================================");
	System.out.println("planProject 메서드 실행");
	System.out.println("==============================================");
	model.addAttribute("title", "프로젝트 계획");
	return "plan/plan/planProject";
	}
	/*------------------------------------------------프로젝트 계획 관리 End-----------------------------------------------------*/
	/*------------------------------------------------자격증 계획 관리 Start-----------------------------------------------------*/
	@GetMapping("/planCertificate")
	public String planCertificate(Model model) {
	System.out.println("==============================================");
	System.out.println("planCertificate 메서드 실행");
	System.out.println("==============================================");
	model.addAttribute("title", "자격증 계획");
	return "plan/plan/planCertificate";
	}
	/*------------------------------------------------자격증 계획 관리 End-----------------------------------------------------*/
	/*------------------------------------------------공인어학 계획 관리 Start-----------------------------------------------------*/
	@GetMapping("/planCertifiedLanguage")
	public String planCertifiedLanguage(Model model) {
		System.out.println("==============================================");
		System.out.println("planCertifiedLanguage 메서드 실행");
		System.out.println("==============================================");
		model.addAttribute("title", "공인어학 계획");
		return "plan/plan/planCertifiedLanguage";
	}
	/*------------------------------------------------공인어학 계획 관리 End-----------------------------------------------------*/
	/*------------------------------------------------기술스택 계획 관리 Start-----------------------------------------------------*/
	@GetMapping("/planTechnologyStack")
	public String planTechnologyStack(Model model) {
		System.out.println("==============================================");
		System.out.println("planTechnologyStack 메서드 실행");
		System.out.println("==============================================");
		model.addAttribute("title", "기술스택 계획");
	return "plan/plan/planTechnologyStack";
	}
	/*------------------------------------------------기술스택 계획 관리 End-----------------------------------------------------*/
	/*------------------------------------------------직종전문교육과정 계획 관리 Start-----------------------------------------------------*/
	@GetMapping("/planJobTraining")
	public String planJobTraining(Model model) {
		System.out.println("==============================================");
		System.out.println("planJobTraining 메서드 실행");
		System.out.println("==============================================");
		model.addAttribute("title", "직종전문교육과정 계획");
		return "plan/plan/planJobTraining";
	}
	/*------------------------------------------------직종전문교육과정 계획 관리 End-----------------------------------------------------*/
	/*------------------------------------------------인턴십 계획 관리 Start-----------------------------------------------------*/
	@GetMapping("/planInternship")
	public String planInternship(Model model) {
		System.out.println("==============================================");
		System.out.println("planInternship 메서드 실행");
		System.out.println("==============================================");
		model.addAttribute("title", "인턴십 계획");
		return "plan/plan/planInternship";
	}
	/*------------------------------------------------인턴십 계획 관리 End-----------------------------------------------------*/
	/*------------------------------------------------공모전 계획 관리 Start-----------------------------------------------------*/
	@GetMapping("/planContest")
	public String planContest(Model model) {
		System.out.println("==============================================");
		System.out.println("planContest 메서드 실행");
		System.out.println("==============================================");
		model.addAttribute("title", "인턴십 계획");
		return "plan/plan/planContest";
	}
	/*------------------------------------------------공모전 계획 관리 End-----------------------------------------------------*/
	/*------------------------------------------------경력 계획 관리 Start-----------------------------------------------------*/
	@GetMapping("/planCareer")
	public String planCareer(Model model) {
		System.out.println("==============================================");
		System.out.println("planCareer 메서드 실행");
		System.out.println("==============================================");
		model.addAttribute("title", "인턴십 계획");
		return "plan/plan/planCareer";
	}
	/*------------------------------------------------경력 계획 관리 End-----------------------------------------------------*/

	/*----------------------------------------------:::: 계획 관리 End ::::------------------------------------------------*/
	
}
