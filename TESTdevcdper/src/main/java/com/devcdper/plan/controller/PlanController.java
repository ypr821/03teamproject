package com.devcdper.plan.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.devcdper.plan.domain.PlanDto;
import com.devcdper.plan.service.PlanService;

@Controller
public class PlanController {
	
	private final PlanService planService;
	
	public PlanController(PlanService planService) {
		this.planService = planService;
	}

	/*---------------------------------------------:::: 통합계획 Start ::::-----------------------------------------------------*/
	/* 통합계획 조회 */
	@GetMapping("/totalPlan")
	public String totalPlan(Model model, HttpSession session, @RequestParam(name="userEmail", required = false)String userEmail) {
		
		String sessionEmail = (String) session.getAttribute("UEMAIL");
		System.out.println("sessionEmailCheck : " + sessionEmail);
		
		// 추후에 관리자가 화면에서 입력한 이메일을 넣을예정
		userEmail = "park01@hanmail.net";
		System.out.println(sessionEmail + " <<- sessionEmail : /totalPlan GetMapping ( 사용자 session에 등록되어있는 UEMAIL확인  )");
		System.out.println(userEmail + " <<- userEmail : /totalPlan GetMapping ( 관리자가 화면에서 입력한 회원이메일 )");
		
		/* 관리자가 특정 회원이메일로 조회할 때 (특정 입력값 필요) */
		if(userEmail != null && !"".equals(userEmail)) {
			
			String searchKey = "user_email";
			String searchValue = userEmail;
			List<PlanDto> totalPlanList = planService.getTotalPlan(searchKey, searchValue);
			model.addAttribute("totalPlanList", totalPlanList);
		
		/* 일반 사용자가 자기 통합계획 조회할 때 session 이용 */
		}else if(sessionEmail != null && !"".equals(sessionEmail)) {
			
			String searchKey = "user_email";
			String searchValue = sessionEmail;
			List<PlanDto> totalPlanList = planService.getTotalPlan(searchKey, searchValue);
			model.addAttribute("totalPlanList", totalPlanList);
		}
		
		model.addAttribute("title", "통합계획");
		model.addAttribute("function", "plan");			//기능별 left 메뉴노출
		return "plan/totalPlan/totalPlan";
	};
	/*--------------------------------------------:::: 통합계획 End ::::-----------------------------------------------------*/
	
	
	/*--------------------------------------------:::: 계획 Start ::::-----------------------------------------------*/
	/*------------------------------------------------나의 계획 한눈에 보기 Start-----------------------------------------------------*/
	@GetMapping("/mainPlan")
	public String mainPlan(Model model, HttpSession session) {
//		String sessionEmail = (String) session.getAttribute("UEMAIL");
		String sessionEmail = "park01@hanmail.net";
		if(sessionEmail != null && !"".equals(sessionEmail)) {
			
			String searchKey = "user_email";
			String searchValue = sessionEmail;
			List<PlanDto> planDto = planService.getTotalPlan(searchKey, searchValue); 
			model.addAttribute("totalPlanList", planDto);
		}
		
		model.addAttribute("title", "나의 계획 한눈에 보기");
		model.addAttribute("function", "plan");
		return "plan/mainPlan";
	}
	
	
	/* 나의 계획 한눈에 보기 AJAX 통합계획 하위 계획 전체 조회*/
	@RequestMapping(value="/totalPlanSelect", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> totalPlanSelect(@RequestParam(value = "totalPlanCodeValue" , required = true)String totalPlanCodeValue) {
			
		Map<String, Object> planMap = new HashMap<String, Object>();
		
		
		System.out.println(totalPlanCodeValue + " <<- selectedTotalPlanCode : /totalPlanSelect PostMapping ( 사용자가 select한 totalPlanCode )");
		if(totalPlanCodeValue != null && !"".equals(totalPlanCodeValue)) {
			String searchKey = "total_plan_code";
			String searchValue = totalPlanCodeValue;
			planMap.put("getEducationalHistoryPlan", planService.getEducationalHistoryPlan(searchKey, searchValue));
			planMap.put("getProjectPlan", planService.getProjectPlan(searchKey, searchValue));
			planMap.put("getCertificatePlan", planService.getCertificatePlan(searchKey, searchValue));
			planMap.put("getCertifiedLanguagePlan", planService.getCertifiedLanguagePlan(searchKey, searchValue));
			planMap.put("getTechnologyStackPlan", planService.getTechnologyStackPlan(searchKey, searchValue));
			planMap.put("getJobTrainingPlan", planService.getJobTrainingPlan(searchKey, searchValue));
			planMap.put("getInternshipPlan", planService.getInternshipPlan(searchKey, searchValue));
			planMap.put("getContestPlan", planService.getContestPlan(searchKey, searchValue));
			planMap.put("getCareerPlan", planService.getCareerPlan(searchKey, searchValue));
		}
		return planMap;
	}
	
	/* 나의 계획 한눈에 보기 AJAX 통합계획 하위 계획 카테고리별 조회 */
	@RequestMapping(value="/planCateSelect", method=RequestMethod.POST)
	@ResponseBody
	public List<PlanDto> planCateSelect(@RequestParam(value = "totalPlanCodeValue" , required = true)String totalPlanCodeValue
									  , @RequestParam(value = "planCateSelect" , required = false)String planCateSelect) {
		List<PlanDto> planDto = null;
		String searchKey = "total_plan_code";
		String searchValue = totalPlanCodeValue;
		System.out.println("planController/planCateSelect : -> "+totalPlanCodeValue);
		System.out.println("planController/planCateSelect : -> "+planCateSelect);
		if(totalPlanCodeValue != null && !"".equals(totalPlanCodeValue) && planCateSelect != null && !"".equals(planCateSelect)) {
			if(planCateSelect.equals("getEducationalHistoryPlan"))planDto = planService.getEducationalHistoryPlan(searchKey, searchValue);
			if(planCateSelect.equals("getProjectPlan"))planDto = planService.getProjectPlan(searchKey, searchValue);
			if(planCateSelect.equals("getCertificatePlan"))planDto = planService.getCertificatePlan(searchKey, searchValue);
			if(planCateSelect.equals("getCertifiedLanguagePlan"))planDto = planService.getCertifiedLanguagePlan(searchKey, searchValue);
			if(planCateSelect.equals("getTechnologyStackPlan"))planDto = planService.getTechnologyStackPlan(searchKey, searchValue);
			if(planCateSelect.equals("getJobTrainingPlan"))planDto = planService.getJobTrainingPlan(searchKey, searchValue);
			if(planCateSelect.equals("getInternshipPlan"))planDto = planService.getInternshipPlan(searchKey, searchValue);
			if(planCateSelect.equals("getContestPlan"))planDto = planService.getContestPlan(searchKey, searchValue);
			if(planCateSelect.equals("getCareerPlan"))planDto = planService.getCareerPlan(searchKey, searchValue);
			return planDto;
		};
		return planDto;
	}
	
	
	/* mainCdp로 잘못된 경로 요청시 */
	@GetMapping("/mainCdp")
	public String mainCdp(Model model) {
		model.addAttribute("title", "나의 계획 한눈에 보기");
		model.addAttribute("mainCdp", "mainCdp");
		return "plan/mainPlan";
	}
	/*------------------------------------------------나의 계획 한눈에 보기 End-----------------------------------------------------*/
	/*------------------------------------------------addPlan Start-----------------------------------------------------*/
	@GetMapping("/addPlan")
	public String addPlan(Model model) {
		model.addAttribute("title", "계획등록");
		model.addAttribute("function", "none");
		return "plan/plan/addPlan";
	}
	@PostMapping("/addPlan")
	public String addPlan() {
		
		return "redirect:/mainPlan";
	}
	/*------------------------------------------------addPlan End-----------------------------------------------------*/
	/*------------------------------------------------modifyPlan Start-----------------------------------------------------*/
	@GetMapping("/modifyPlan")
	public String modifyPlan(Model model) {
		model.addAttribute("title", "계획수정");
		model.addAttribute("function", "none");
		return"plan/plan/modifyPlan";
	}
	
	@PostMapping("/modifyPlan")
	public String modifyPlan() {
		
		return"redirect:/mainPlan";
	}
	/*------------------------------------------------modifyPlan End-----------------------------------------------------*/
	/*------------------------------------------------deleteTotalPlan Start-----------------------------------------------------*/
	@GetMapping("/deletePlan")
	public String deletePlan() {
		return"redirect:/mainPlan";
	}
	/*------------------------------------------------deleteTotalPlan End-----------------------------------------------------*/
	/*------------------------------------------------학력 계획 관리 Start-----------------------------------------------------*/
	@GetMapping("/planEducationalHistory")
	public String planEducationalHistory(Model model) {
	System.out.println("==============================================");
	System.out.println("planEducationalHistory 메서드 실행");
	System.out.println("==============================================");
	model.addAttribute("title", "학력 계획 관리");
	model.addAttribute("function", "plan");
	return "plan/plan/planEducationalHistory";
	}
	
	/*
	@ResponseBody
	@PostMapping("/planEducationalHistory")
	public String planEducationalHistory(@RequestParam(name="firstSelect", required = false)String firstSelect, RedirectAttributes reAttr) {
		 Map<String,Object> map = new HashMap<String,Object>();
		
		
		 if(firstSelect != null && firstSelect.equals("계획")){
		 System.out.println("계획 조건문통과"); map.put("planEducationalHistory",
		 "planEducationalHistory"); }else if(firstSelect != null &&
		 firstSelect.equals("상세계획")){ System.out.println("상세계획 조건문통과"); }else
		 if(firstSelect != null && firstSelect.equals("실천계획")){
		 System.out.println("실천계획 조건문통과"); };
		 reAttr.addAttribute("planMap", map); 
		return "redirect:/planEducationalHistory";
	}*/
	/*------------------------------------------------학력 계획 관리 End-----------------------------------------------------*/
	/*------------------------------------------------프로젝트 계획 관리 Start-----------------------------------------------------*/
	@GetMapping("/planProject")
	public String planProject(Model model) {
	System.out.println("==============================================");
	System.out.println("planProject 메서드 실행");
	System.out.println("==============================================");
	model.addAttribute("title", "프로젝트 계획");
	model.addAttribute("function", "plan");
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
	model.addAttribute("function", "plan");
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
		model.addAttribute("function", "plan");
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
		model.addAttribute("function", "plan");
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
		model.addAttribute("function", "plan");
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
		model.addAttribute("function", "plan");
		return "plan/plan/planInternship";
	}
	/*------------------------------------------------인턴십 계획 관리 End-----------------------------------------------------*/
	/*------------------------------------------------공모전 계획 관리 Start-----------------------------------------------------*/
	@GetMapping("/planContest")
	public String planContest(Model model) {
		System.out.println("==============================================");
		System.out.println("planContest 메서드 실행");
		System.out.println("==============================================");
		model.addAttribute("title", "공모전 계획");
		model.addAttribute("function", "plan");
		return "plan/plan/planContest";
	}
	/*------------------------------------------------공모전 계획 관리 End-----------------------------------------------------*/
	/*------------------------------------------------경력 계획 관리 Start-----------------------------------------------------*/
	@GetMapping("/planCareer")
	public String planCareer(Model model) {
		System.out.println("==============================================");
		System.out.println("planCareer 메서드 실행");
		System.out.println("==============================================");
		model.addAttribute("title", "경력 계획");
		model.addAttribute("function", "plan");
		return "plan/plan/planCareer";
	}
	/*------------------------------------------------경력 계획 관리 End-----------------------------------------------------*/

	/*----------------------------------------------:::: 계획 관리 End ::::------------------------------------------------*/
	
}
