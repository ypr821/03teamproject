package com.devcdper.plan.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.devcdper.coaching.service.CoachingService;
import com.devcdper.plan.domain.PlanDto;
import com.devcdper.plan.service.PlanService;


@Controller
public class PlanCommonController {
	
	public final PlanService planService;
	public final CoachingService coachingService;
	
	public PlanCommonController(PlanService planService, CoachingService coachingService) {
		this.planService = planService;
		this.coachingService = coachingService;
	}
	
	
	/*------------------------------------------------통합계획등록 Start-----------------------------------------------------*/
	@GetMapping("/addTotalPlan")
	public String addTotalPlan(Model model
							 , @RequestParam(name="planName")String planName) {
		System.out.println(planName + " <<- planName : /addTotalPlan GetMapping");
		
		
		/* 계획 등록 */
		if(planName.equals("totalPlan") && planName != null && !"".equals(planName)) {
			model.addAttribute("title", "통합계획");
		}else if(planName.equals("planEducationalHistory") && planName != null && !"".equals(planName)) {
			model.addAttribute("title", "학력계획");
		}else if(planName.equals("planProject") && planName != null && !"".equals(planName)) {
			model.addAttribute("title", "프로젝트계획");
		}else if(planName.equals("planCertificate") && planName != null && !"".equals(planName)) {
			model.addAttribute("title", "자격증계획");
		}else if(planName.equals("planCertifiedLanguage") && planName != null && !"".equals(planName)) {
			model.addAttribute("title", "공인어학계획");
		}else if(planName.equals("planTechnologyStack") && planName != null && !"".equals(planName)) {
			model.addAttribute("title", "기술스택계획");
		}else if(planName.equals("planJobTraining") && planName != null && !"".equals(planName)) {
			model.addAttribute("title", "직종전문교육과정계획");
		}else if(planName.equals("planInternship") && planName != null && !"".equals(planName)) {
			model.addAttribute("title", "인턴십계획");
		}else if(planName.equals("planContest") && planName != null && !"".equals(planName)) {
			model.addAttribute("title", "공모전계획");
		}else if(planName.equals("planCareer") && planName != null && !"".equals(planName)) {
			model.addAttribute("title", "경력계획");
		}
		
		
		/* 상세계획 등록 */
		if(planName.equals("planEducationalHistoryDetail") && planName != null && !"".equals(planName)) {
			model.addAttribute("title", "학력상세계획");
		}else if(planName.equals("planProjectDetail") && planName != null && !"".equals(planName)) {
			model.addAttribute("title", "프로젝트상세계획");
		}else if(planName.equals("planCertificateDetail") && planName != null && !"".equals(planName)) {
			model.addAttribute("title", "자격증상세계획");
		}else if(planName.equals("planCertifiedLanguageDetail") && planName != null && !"".equals(planName)) {
			model.addAttribute("title", "공인어학상세계획");
		}else if(planName.equals("planTechnologyStackDetail") && planName != null && !"".equals(planName)) {
			model.addAttribute("title", "기술스택상세계획");
		}else if(planName.equals("planJobTrainingDetail") && planName != null && !"".equals(planName)) {
			model.addAttribute("title", "직종전문교육과정상세계획");
		}else if(planName.equals("planInternshipDetail") && planName != null && !"".equals(planName)) {
			model.addAttribute("title", "인턴십상세계획");
		}else if(planName.equals("planContestDetail") && planName != null && !"".equals(planName)) {
			model.addAttribute("title", "공모전상세계획");
		}else if(planName.equals("planCareerDetail") && planName != null && !"".equals(planName)) {
			model.addAttribute("title", "경력상세계획");
		}
		
		/* 계획실천 등록 */
		if(planName.equals("actionEducationalHistory") && planName != null && !"".equals(planName)) {
			model.addAttribute("title", "학력계획실천");
		}else if(planName.equals("actionProject") && planName != null && !"".equals(planName)) {
			model.addAttribute("title", "프로젝트계획");
		}else if(planName.equals("actionCertificate") && planName != null && !"".equals(planName)) {
			model.addAttribute("title", "자격증계획실천");
		}else if(planName.equals("actionCertifiedLanguage") && planName != null && !"".equals(planName)) {
			model.addAttribute("title", "공인어학계획실천");
		}else if(planName.equals("actionTechnologyStack") && planName != null && !"".equals(planName)) {
			model.addAttribute("title", "기술스택계획실천");
		}else if(planName.equals("actionJobTraining") && planName != null && !"".equals(planName)) {
			model.addAttribute("title", "직종전문교육과정계획실천");
		}else if(planName.equals("actionInternship") && planName != null && !"".equals(planName)) {
			model.addAttribute("title", "인턴십계획실천");
		}else if(planName.equals("actionContest") && planName != null && !"".equals(planName)) {
			model.addAttribute("title", "공모전계획실천");
		}else if(planName.equals("actionCareer") && planName != null && !"".equals(planName)) {
			model.addAttribute("title", "경력계획실천");
		}
		model.addAttribute("planName", planName);
		model.addAttribute("function", "none");
		return "fragments/plan/addTotalPlan";
	}
	
	@PostMapping("/addTotalPlan")
	public String addTotalPlan(PlanDto planDto, HttpSession session, RedirectAttributes reAttr, @RequestParam(name="planName", required = true)String planName) {
		
		System.out.println(planName + " <<- planName : PlanCommonController / addTotalPlan - PostMapping");
		
//		String userSessionId = (String) session.getAttribute("UEMAIL");
		String userSessionId = "park01@hanmail.net";
		String redirect = "redirect:/"+planName;
		String newCode = null;
		
		if(userSessionId != null && !"".equals(userSessionId)) {
			if(planDto.getPlanTitle() != null && !"".equals(planDto.getPlanTitle())) {
				System.out.println("접근성공");
				newCode = coachingService.getNewCode2("total_plan");
				
				System.out.println("생성된 new 코드 : " + newCode);
				planDto.setUserEmail(userSessionId);
				planDto.setPlanCode(newCode);
				/* ( sessionId null체크 및 planDto의 userEmail에 sessionId를 대입 ) */
				System.out.println(planDto + " <<- planDto : PlanCommonController / addTotalPlan - PostMapping");
				planService.addTotalPlan(planDto ,planName);
				
				reAttr.addAttribute("userEmail", userSessionId);
				
				return redirect;
			}
		}
		
		reAttr.addAttribute("fail", "상품등록실패");
		return "redirect:/addTotalPlan";
	}
	/*------------------------------------------------통합계획등록 End-----------------------------------------------------*/
	/*------------------------------------------------통합계획수정 Start-----------------------------------------------------*/
	@GetMapping("/modifyTotalPlan")
	public String modifyTotalPlan(Model model, @RequestParam(name="planName", required = true)String planName
								, @RequestParam(name="planCode", required = true)String planCode) {
		List<PlanDto> planDto = null;
		String searchKey = "total_plan_code";
		String searchValue = planCode;
		
		System.out.println("searchKey"+searchKey);
		System.out.println("searchValue"+searchValue);
		/* 계획 수정 */
		if(planName.equals("totalPlan") && planName != null && !"".equals(planName)) {
			model.addAttribute("title", "통합계획");
			planDto = planService.getTotalPlan(searchKey, searchValue);
		}else if(planName.equals("planEducationalHistory") && planName != null && !"".equals(planName)) {
			model.addAttribute("title", "학력계획");
			planDto = planService.getEducationalHistoryPlan(searchKey, searchValue);
		}else if(planName.equals("planProject") && planName != null && !"".equals(planName)) {
			model.addAttribute("title", "프로젝트계획");
			planDto = planService.getProjectPlan(searchKey, searchValue);
		}else if(planName.equals("planCertificate") && planName != null && !"".equals(planName)) {
			model.addAttribute("title", "자격증계획");
			planDto = planService.getCertificatePlan(searchKey, searchValue);
		}else if(planName.equals("planCertifiedLanguage") && planName != null && !"".equals(planName)) {
			model.addAttribute("title", "공인어학계획");
			planDto = planService.getCertifiedLanguagePlan(searchKey, searchValue);
		}else if(planName.equals("planTechnologyStack") && planName != null && !"".equals(planName)) {
			model.addAttribute("title", "기술스택계획");
			planDto = planService.getTechnologyStackPlan(searchKey, searchValue);
		}else if(planName.equals("planJobTraining") && planName != null && !"".equals(planName)) {
			model.addAttribute("title", "직종전문교육과정계획");
			planDto = planService.getJobTrainingPlan(searchKey, searchValue);
		}else if(planName.equals("planInternship") && planName != null && !"".equals(planName)) {
			model.addAttribute("title", "인턴십계획");
			planDto = planService.getInternshipPlan(searchKey, searchValue);
		}else if(planName.equals("planContest") && planName != null && !"".equals(planName)) {
			model.addAttribute("title", "공모전계획");
			planDto = planService.getContestPlan(searchKey, searchValue);
		}else if(planName.equals("planCareer") && planName != null && !"".equals(planName)) {
			model.addAttribute("title", "경력계획");
			planDto = planService.getCareerPlan(searchKey, searchValue);
		}
		
		
		/* 상세계획 등록 */
		if(planName.equals("planEducationalHistoryDetail") && planName != null && !"".equals(planName)) {
			model.addAttribute("title", "학력상세계획");
		}else if(planName.equals("planProjectDetail") && planName != null && !"".equals(planName)) {
			model.addAttribute("title", "프로젝트상세계획");
		}else if(planName.equals("planCertificateDetail") && planName != null && !"".equals(planName)) {
			model.addAttribute("title", "자격증상세계획");
		}else if(planName.equals("planCertifiedLanguageDetail") && planName != null && !"".equals(planName)) {
			model.addAttribute("title", "공인어학상세계획");
		}else if(planName.equals("planTechnologyStackDetail") && planName != null && !"".equals(planName)) {
			model.addAttribute("title", "기술스택상세계획");
		}else if(planName.equals("planJobTrainingDetail") && planName != null && !"".equals(planName)) {
			model.addAttribute("title", "직종전문교육과정상세계획");
		}else if(planName.equals("planInternshipDetail") && planName != null && !"".equals(planName)) {
			model.addAttribute("title", "인턴십상세계획");
		}else if(planName.equals("planContestDetail") && planName != null && !"".equals(planName)) {
			model.addAttribute("title", "공모전상세계획");
		}else if(planName.equals("planCareerDetail") && planName != null && !"".equals(planName)) {
			model.addAttribute("title", "경력상세계획");
		}
		
		/* 계획실천 등록 */
		if(planName.equals("actionEducationalHistory") && planName != null && !"".equals(planName)) {
			model.addAttribute("title", "학력계획실천");
		}else if(planName.equals("actionProject") && planName != null && !"".equals(planName)) {
			model.addAttribute("title", "프로젝트계획");
		}else if(planName.equals("actionCertificate") && planName != null && !"".equals(planName)) {
			model.addAttribute("title", "자격증계획실천");
		}else if(planName.equals("actionCertifiedLanguage") && planName != null && !"".equals(planName)) {
			model.addAttribute("title", "공인어학계획실천");
		}else if(planName.equals("actionTechnologyStack") && planName != null && !"".equals(planName)) {
			model.addAttribute("title", "기술스택계획실천");
		}else if(planName.equals("actionJobTraining") && planName != null && !"".equals(planName)) {
			model.addAttribute("title", "직종전문교육과정계획실천");
		}else if(planName.equals("actionInternship") && planName != null && !"".equals(planName)) {
			model.addAttribute("title", "인턴십계획실천");
		}else if(planName.equals("actionContest") && planName != null && !"".equals(planName)) {
			model.addAttribute("title", "공모전계획실천");
		}else if(planName.equals("actionCareer") && planName != null && !"".equals(planName)) {
			model.addAttribute("title", "경력계획실천");
		}
		
		System.out.println("PlanCommonController / planDto : " + planDto);
		model.addAttribute("planName", planName);
		model.addAttribute("function", "none");
		model.addAttribute("totalPlanList", planDto);
		return"fragments/plan/modifyTotalPlan";
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
}