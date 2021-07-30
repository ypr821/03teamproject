package com.devcdper.plan.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.devcdper.plan.domain.DetailPlanDto;
import com.devcdper.plan.domain.PlanDto;
import com.devcdper.plan.service.DetailPlanService;
import com.devcdper.plan.service.PlanService;


@Controller
public class DetailPlanController {

	//private static final Logger log = LoggerFactory.getLogger(DetailPlanController.class);
	
	
		//생성자 메소드 주입방식
		private final DetailPlanService detailPlanService;
		private final PlanService planService;
		
		//spring framework 4.3이후부터 @Autowired 생략가능
		//@Autowired
		
		
		public DetailPlanController(DetailPlanService detailPlanService, PlanService planService) {
			this.detailPlanService=detailPlanService;
			this.planService=planService;
			
		}
	
	
	
	
	@PostConstruct
	public void detailPlanControllerInit() {
		//log.info("==========================================");
		//log.info("detailPlanController 객체 생성");
		//log.info("==========================================");
		System.out.println("======================================");
		System.out.println("detailPlanController 객체 생성");
		System.out.println("======================================");
	}
	
	
	
	
	
	
	/*--------------------------------------::: 학력 상세 계획 관리  조회 Start :::-------------------------*/
	//학력 상세 계획 관리
	@GetMapping("/planEducationalHistoryDetail")
	public String planEducationalHistoryDetail(Model model) { //, String paramList
															
		//log.info("==============================================");
		//log.info("planEducationalHistoryDetail 메서드 실행");
		//log.info("==============================================");
		
		
		// userEmail = (String) session.getAttribute("UEMAIL");
		//DetailPlanDto dto = new DetailPlanDto();
		//dto.setPlanDetailCode(userEmail);
		
		//서비스등록 Start
		//Map<String, Object> paramMap = new HashMap<String, Object>();
		//paramMap.put("searchKey", searchKey);
		//paramMap.put("searchValue", searchValue);
		
		//List<DetailPlanDto> detailPlanList = detailPlanService.getDetailPlanList(paramList);
		
		
		//totalSelect 사용하기 위한 통합계획 서비스등록
		String userEmail= "park01@hanmail.net";
		String searchKey="user_email";
		String searchValue=userEmail;
		List<PlanDto> totalPlanList = planService.getTotalPlan(searchKey, searchValue);
		
		//서비스등록 End
		
		
		System.out.println("==============================================");
		System.out.println("planEducationalHistoryDetail 메서드 실행"+totalPlanList);
		System.out.println("==============================================");

		
		model.addAttribute("title", "학력 상세 계획 ");
		model.addAttribute("function", "plan");			//기능별 left 메뉴노출
		model.addAttribute("totalPlanList",totalPlanList); //모델 추가 안해서 안됐던거
		//model.addAttribute("detailPlanList",detailPlanList);
		
		
		return "plan/detailPlan/planEducationalHistoryDetail";
	}
		
	
	/*----------------------------------------- 학력 상세 계획 관리 수정 Start----------------------------*/
	@GetMapping("/modifyPlanEducationalHistoryDetail")
	public String modifyPlanEducationalHistoryDetail(Model model){
		model.addAttribute("title", "학력 상세계획 ");
		model.addAttribute("function", "none");
		return "plan/detailPlan/modifyPlanEducationalHistoryDetail";
	}
	
	@PostMapping("/modifyPlanEducationalHistoryDetail")
	public String modifyPlanEducationalHistoryDetail() {
		return "redirect:/planEducationalHistoryDetail";
	}
	/*----------------------------------------- 학력 상세 계획 관리 수정 End------------------------------*/
	/*--------------------------------------::: 학력 상세 계획 관리 End :::-------------------------*/
	

	
	//AJAX1 통합계획 선택시//
	@RequestMapping(value = "/totalPlanSelected", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> totalPlanSelected(@RequestParam(value="stotalPlanCode",required=true)String stotalPlanCode
										  ,@RequestParam(value="planName",required = true)String planName){
		System.out.println(stotalPlanCode+" <- AJAX1 controller");
		//String result = totalPlanCode+ "AJAX return 성공";
		System.out.println(planName+"  palnNameController");
		Map<String, Object> detailPlanMap = new HashMap<String, Object>();
		
		
		if(planName.equals("planEducationalHistoryDetail") && planName != null && !"".equals(planName)) {
			System.out.println("planEducationalHistoryDetail 컨트롤러1 접근성공");
			detailPlanMap.put("planEducationalHistoryDetail", detailPlanService.getEducationalHistoryTotalTitleSearch(stotalPlanCode));
			
		}else if(planName.equals("planProjectDetail")&& planName != null && !"".equals(planName)){
			System.out.println("planProjectDetail 컨트롤러1 접근성공");
			detailPlanMap.put("planProjectDetail",detailPlanService.getProjectTotalTitleSearch(stotalPlanCode));
			
		}else if(planName.equals("planCertificateDetail")&& planName != null && !"".equals(planName)) {
			System.out.println("자격증 컨트롤러 ajax접근성공");
			detailPlanMap.put("planCertificateDetail",detailPlanService.getCertificateTotalTitleSearch(stotalPlanCode));
			
		}else if(planName.equals("planCertifiedLanguageDetail")&& planName != null && !"".equals(planName)) {
			detailPlanMap.put("planCertifiedLanguageDetail",detailPlanService.getCertifiedLanguageTotalTitleSearch(stotalPlanCode));
			
		}else if(planName.equals("planTechnologyStackDetail")&& planName != null && !"".equals(planName)) {
			detailPlanMap.put("planTechnologyStackDetail",detailPlanService.getTechnologyStackTotalTitleSearch(stotalPlanCode));
			
		}else if(planName.equals("planJobTrainingDetail")&& planName != null && !"".equals(planName)) {
			detailPlanMap.put("planJobTrainingDetail",detailPlanService.getJobTrainingTotalTitleSearch(stotalPlanCode));
			
		}else if(planName.equals("planInternshipDetail")&& planName != null && !"".equals(planName)) {
			detailPlanMap.put("planInternshipDetail",detailPlanService.getInternshipTotalTitleSearch(stotalPlanCode));
			
		}else if(planName.equals("planContestDetail")&& planName != null && !"".equals(planName)) {
			detailPlanMap.put("planContestDetail",detailPlanService.getContestTotalTitleSearch(stotalPlanCode));
			
		}else if(planName.equals("planCareerDetail")&& planName != null && !"".equals(planName)) {
			detailPlanMap.put("planCareerDetail",detailPlanService.getCareerTotalTitleSearch(stotalPlanCode));
			
		}
		//okay 임의의 Email값 넘겨(각 화면의 컨트롤러) totalPlan의 모든 값중 Code와 Title가져오면된다.
		//List<PlanDto> getProjTitleSearch = detailPlanService.getProjTotalTitleSearch(stotalPlanCode);
		
		return  detailPlanMap;
	}
	
	
	//AJAX2 계획 선택후 검색 클릭시//
	@RequestMapping(value = "/totalAndPlanSelected", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> totalAndPlanSelected(@RequestParam(value="totalPlanCode",required=true)String totalPlanCode
											 ,@RequestParam(value="planCode",required =true )String planCode
											 ,@RequestParam(value="planName",required = true)String planName){
		System.out.println(totalPlanCode+" <- AJAX2 controller");
		System.out.println(planCode+" <- AJAX2 controller");
		System.out.println(planName+"palnNameAJAX2Controller");
		Map<String, Object> detailPlanMap = new HashMap<String, Object>();
		
		if(planName.equals("planEducationalHistoryDetail")&& planName != null && !"".equals(planName)) {
			System.out.println("planEducationalHistoryDetail AJAX2 컨트롤러 접근성공");
			detailPlanMap.put("planEducationalHistoryDetail",detailPlanService.getEducationalHistoryDetailPlanList(totalPlanCode,planCode));
			
		}else if(planName.equals("planProjectDetail")&& planName != null && !"".equals(planName)) {
			detailPlanMap.put("planProjectDetail",detailPlanService.getProjectDetailPlanList(totalPlanCode, planCode));
			
		}else if(planName.equals("planCertificateDetail")&& planName != null && !"".equals(planName)) {
			detailPlanMap.put("planCertificateDetail",detailPlanService.getCertificateDetailPlanList(totalPlanCode, planCode));
			
		}else if(planName.equals("planCertifiedLanguageDetail")&& planName != null && !"".equals(planName)) {
			detailPlanMap.put("planCertifiedLanguageDetail",detailPlanService.getCertifiedLanguageDetailPlanList(totalPlanCode, planCode));
			
		}else if(planName.equals("planTechnologyStackDetail")&& planName != null && !"".equals(planName)) {
			detailPlanMap.put("planTechnologyStackDetail",detailPlanService.getTechnologyStackDetailPlanList(totalPlanCode, planCode));
			
		}else if(planName.equals("planJobTrainingDetail")&& planName != null && !"".equals(planName)) {
			detailPlanMap.put("planJobTrainingDetail",detailPlanService.getJobTrainingDetailPlanList(totalPlanCode, planCode));
			
		}else if(planName.equals("planInternshipDetail")&& planName != null && !"".equals(planName)) {
			detailPlanMap.put("planInternshipDetail",detailPlanService.getInternshipDetailPlanList(totalPlanCode, planCode));
			
		}else if(planName.equals("planContestDetail")&& planName != null && !"".equals(planName)) {
			detailPlanMap.put("planContestDetail",detailPlanService.getContestDetailPlanList(totalPlanCode, planCode));
			
		}else if(planName.equals("planCareerDetail")&& planName != null && !"".equals(planName)) {
			detailPlanMap.put("planCareerDetail",detailPlanService.getCareerDetailPlanList(totalPlanCode, planCode));
			
		}
		
		//List<DetailPlanDto> detailPlanList = detailPlanService.getDetailPlanList(totalPlanCode,planCode);
		
		return detailPlanMap;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	/*--------------------------------------::: 프로젝트 상세 계획 관리 Start :::----------------------------*/
	//프로젝트 상세 계획 관리
	@GetMapping("/planProjectDetail")
	public String planProjectDetail(Model model) {//, String paramList
		//log.info("==============================================");
		//log.info("planProjectDetail 메서드 실행");
		//log.info("==============================================");
		System.out.println("==============================================");
		System.out.println("planProjectDetail 메서드 실행");
		System.out.println("==============================================");
		//List<DetailPlanDto> detailProjectjPlanList = detailPlanService.getProjectDetailPlanList(paramList);
		
		
		String userEmail= "park01@hanmail.net";
		String searchKey="user_email";
		String searchValue=userEmail;
		List<PlanDto> totalPlanList = planService.getTotalPlan(searchKey, searchValue);
		
		
		model.addAttribute("title", "프로젝트 상세 계획");
		model.addAttribute("function", "plan");			//기능별 left 메뉴노출
		model.addAttribute("totalPlanList",totalPlanList);
		//model.addAttribute("detailProjectjPlanList",detailProjectjPlanList);
		
		return "plan/detailPlan/planProjectDetail";
	}
	
	/*----------------------------------------- 프로젝트 상세 계획 관리 수정Start -------------------------------*/
	@GetMapping("/modifyPlanProjectDetail")
	public String modifyPlanProjectDetail(Model model){
		model.addAttribute("title", "프로젝트 상세 계획 ");
		model.addAttribute("function", "none");
		return "plan/detailPlan/modifyPlanProjectDetail";
	}
	
	@PostMapping("/modifyPlanProjectDetail")
	public String modifyPlanProjectDetail() {
		return "redirect:/planProjectDetail";
	}
	/*----------------------------------------- 프로젝트 상세 계획 관리 수정End -------------------------------*/
	/*----------------------------------------- 프로젝트 상세 계획 관리 삭제Start -------------------------------*/
	
	/*----------------------------------------- 프로젝트 상세 계획 관리 삭제End -------------------------------*/
	/*--------------------------------------::: 프로젝트 상세 계획 관리 End :::-------------------------*/
	
	
	
	
	
	
	/*--------------------------------------::: 자격증 상세 계획 관리 Start :::-------------------------*/
	//자격증 상세 계획 관리
	@GetMapping("/planCertificateDetail")
	public String planCertificateDetail(Model model) {//, String paramList
		//log.info("==============================================");
		//log.info("planCertificateDetail 메서드 실행");
		//log.info("==============================================");
		System.out.println("==============================================");
		System.out.println("planCertificateDetail 메서드 실행");
		System.out.println("==============================================");
		//List<DetailPlanDto> detailCertificatePlanList = detailPlanService.getCertificateDetailPlanList(paramList);
		
		String userEmail= "park01@hanmail.net";
		String searchKey="user_email";
		String searchValue=userEmail;
		List<PlanDto> totalPlanList = planService.getTotalPlan(searchKey, searchValue);
		
		
		model.addAttribute("title", "프로젝트 상세 계획");
		model.addAttribute("function", "plan");			//기능별 left 메뉴노출
		model.addAttribute("totalPlanList",totalPlanList);
		//model.addAttribute("detailCertificatePlanList",detailCertificatePlanList);
		
		
		return "plan/detailPlan/planCertificateDetail";
	}
	
	/*----------------------------------------- 자격증 상세 계획 관리 수정 Start ----------------------------*/
	@GetMapping("/modifyPlanCertificateDetail")
	public String modifyPlanCertificateDetail(Model model){
		model.addAttribute("title", "자격증 상세 계획 ");
		model.addAttribute("function", "none");
		return "plan/detailPlan/modifyPlanCertificateDetail";
	}
	
	@PostMapping("/modifyPlanCertificateDetail")
	public String modifyPlanCertificateDetail() {
		return "redirect:/planCertificateDetail";
	}
	/*----------------------------------------- 자격증 상세 계획 관리 수정 End ----------------------------*/
	/*----------------------------------------- 자격증 상세 계획 관리 삭제 Start ----------------------------*/
	
	/*----------------------------------------- 자격증 상세 계획 관리 삭제 End ----------------------------*/
	/*--------------------------------------::: 자격증 상세 계획 관리 End :::-------------------------*/
	
	
	
	/*--------------------------------------::: 공인어학 상세 계획 관리Start :::-------------------------*/
	//공인어학 상세 계획 관리
	@GetMapping("/planCertifiedLanguageDetail")
	public String planCertifiedLanguageDetail(Model model) {//, String paramList
		//log.info("==============================================");
		//log.info("planCertifiedLanguageDetail 메서드 실행");
		//log.info("==============================================");
		System.out.println("==============================================");
		System.out.println("planCertifiedLanguageDetail 메서드 실행");
		System.out.println("==============================================");
		//List<DetailPlanDto> detailCertifiedLanguagePlanList=detailPlanService.getCertifiedLanguageDetailPlanList(paramList);
		
		String userEmail= "park01@hanmail.net";
		String searchKey="user_email";
		String searchValue=userEmail;
		List<PlanDto> totalPlanList = planService.getTotalPlan(searchKey, searchValue);
		
		
		model.addAttribute("title", "프로젝트 상세 계획");
		model.addAttribute("function", "plan");			//기능별 left 메뉴노출
		model.addAttribute("totalPlanList",totalPlanList);
		//model.addAttribute("detailCertifiedLanguagePlanList",detailCertifiedLanguagePlanList);
		
		return "plan/detailPlan/planCertifiedLanguageDetail";
	}
	
	/*----------------------------------------- 공인어학 상세 계획 관리 수정 Start ----------------------------*/
	@GetMapping("/modifyPlanCertifiedLanguageDetail")
	public String modifyPlanCertifiedLanguageDetail(Model model){
		model.addAttribute("title", "공인어학 상세 계획 ");
		model.addAttribute("function", "none");
		return "plan/detailPlan/modifyPlanCertifiedLanguageDetail";
	}
	
	@PostMapping("/modifyPlanCertifiedLanguageDetail")
	public String modifyPlanCertifiedLanguageDetail() {
		return "redirect:/planCertifiedLanguageDetail";
	}
	/*----------------------------------------- 공인어학 상세 계획 관리 수정 End ----------------------------*/
	/*----------------------------------------- 공인어학 상세 계획 관리 삭제 Start ----------------------------*/
	
	/*----------------------------------------- 공인어학 상세 계획 관리 삭제 End ----------------------------*/
	/*--------------------------------------::: 공인어학 상세 계획 관리 End :::-------------------------*/
	
	
	
	/*--------------------------------------::: 기술스택 상세 계획 관리 Start :::------------------------*/
	//기술스택 상세 계획 관리
	@GetMapping("/planTechnologyStackDetail")
	public String planTechnologyStackDetail(Model model) {//, String paramList
		//log.info("==============================================");
		//log.info("planTechnologyStackDetail 메서드 실행");
		//log.info("==============================================");
		System.out.println("==============================================");
		System.out.println("planTechnologyStackDetail 메서드 실행");
		System.out.println("==============================================");
		//List<DetailPlanDto> detailTechnologyStackPlanList=detailPlanService.getTechnologyStackDetailPlanList(paramList);
		
		String userEmail= "park01@hanmail.net";
		String searchKey="user_email";
		String searchValue=userEmail;
		List<PlanDto> totalPlanList = planService.getTotalPlan(searchKey, searchValue);
		
		
		model.addAttribute("title", "프로젝트 상세 계획");
		model.addAttribute("function", "plan");			//기능별 left 메뉴노출
		model.addAttribute("totalPlanList",totalPlanList);
		//model.addAttribute("detailTechnologyStackPlanList",detailTechnologyStackPlanList);
		
		
		return "plan/detailPlan/planTechnologyStackDetail";
	}
	
	/*----------------------------------------- 기술스택 상세 계획 관리 수정 Start ---------------------------*/
	@GetMapping("/modifyPlanTechnologyStackDetail")
	public String modifyPlanTechnologyStackDetail(Model model){
		model.addAttribute("title", "기술스택 상세 계획 ");
		model.addAttribute("function", "none");
		return "plan/detailPlan/modifyPlanTechnologyStackDetail";
	}
	
	@PostMapping("/modifyPlanTechnologyStackDetail")
	public String modifyPlanTechnologyStackDetail() {
		return "redirect:/planTechnologyStackDetail";
	}
	/*----------------------------------------- 기술스택 상세 계획 관리 수정 End ---------------------------*/
	/*----------------------------------------- 기술스택 상세 계획 관리 삭제 Start ---------------------------*/
	
	/*----------------------------------------- 기술스택 상세 계획 관리 삭제 End ---------------------------*/
	/*--------------------------------------::: 기술스택 상세 계획 관리 End :::-------------------------*/
	
	
	/*--------------------------------------::: 직종전문교육과정 상세 계획 관리 Start :::-------------------------*/
	//직종전문교육과정 상세 계획 관리
	@GetMapping("/planJobTrainingDetail")
	public String planJobTrainingDetail(Model model) {//, String paramList
		//log.info("==============================================");
		//log.info("planJobTrainingDetail 메서드 실행");
		//log.info("==============================================");
		System.out.println("==============================================");
		System.out.println("planJobTrainingDetail 메서드 실행");
		System.out.println("==============================================");
		//List<DetailPlanDto> detailJobTrainingPlanList=detailPlanService.getJobTrainingDetailPlanList(paramList);
		
		String userEmail= "park01@hanmail.net";
		String searchKey="user_email";
		String searchValue=userEmail;
		List<PlanDto> totalPlanList = planService.getTotalPlan(searchKey, searchValue);
		
		
		model.addAttribute("title", "프로젝트 상세 계획");
		model.addAttribute("function", "plan");			//기능별 left 메뉴노출
		model.addAttribute("totalPlanList",totalPlanList);
		//model.addAttribute("detailJobTrainingPlanList", detailJobTrainingPlanList);
		
		
		return "plan/detailPlan/planJobTrainingDetail";
	}
	
	/*----------------------------------------- 직종전문교육과정 상세 계획 관리 수정 Start ----------------------------*/
	@GetMapping("/modifyPlanJobTrainingDetail")
	public String modifyPlanJobTrainingDetail(Model model){
		model.addAttribute("title", "직종전문교육과정 상세 계획 ");
		model.addAttribute("function", "none");
		return "plan/detailPlan/modifyPlanJobTrainingDetail";
	}
	
	@PostMapping("/modifyPlanJobTrainingDetail")
	public String modifyPlanJobTrainingDetail() {
		return "redirect:/planJobTrainingDetail";
	}
	/*----------------------------------------- 직종전문교육과정 상세 계획 관리 수정 End ----------------------------*/
	/*----------------------------------------- 직종전문교육과정 상세 계획 관리 삭제 Start ----------------------------*/
	
	/*----------------------------------------- 직종전문교육과정 상세 계획 관리 삭제 End ----------------------------*/
	/*--------------------------------------::: 직종전문교육과정 상세 계획 관리 End :::-------------------------*/
		
	
	
	/*--------------------------------------::: 인턴십 상세 계획 관리 Start :::------------------------*/
	//인턴십 상세 계획 관리
	@GetMapping("/planInternshipDetail")
	public String planInternshipDetail(Model model) {//, String paramList
		//log.info("==============================================");
		//log.info("planInternshipDetail 메서드 실행");
		//log.info("==============================================");
		System.out.println("==============================================");
		System.out.println("planInternshipDetail 메서드 실행");
		System.out.println("==============================================");
		//List<DetailPlanDto> detailInternshipPlanList=detailPlanService.getInternshipDetailPlanList(paramList);
		
		String userEmail= "park01@hanmail.net";
		String searchKey="user_email";
		String searchValue=userEmail;
		List<PlanDto> totalPlanList = planService.getTotalPlan(searchKey, searchValue);
		
		
		model.addAttribute("title", "프로젝트 상세 계획");
		model.addAttribute("function", "plan");			//기능별 left 메뉴노출
		model.addAttribute("totalPlanList",totalPlanList);
		//model.addAttribute("detailInternshipPlanList", detailInternshipPlanList);
		
		
		return "plan/detailPlan/planInternshipDetail";
	}
	
	/*----------------------------------------- 인턴십 상세 계획 관리 수정 Start ---------------------------*/
	@GetMapping("/modifyPlanInternshipDetail")
	public String modifyPlanInternshipDetail(Model model){
		model.addAttribute("title", "인턴십 상세 계획 ");
		model.addAttribute("function", "none");
		return "plan/detailPlan/modifyPlanInternshipDetail";
	}
	
	@PostMapping("/modifyPlanInternshipDetail")
	public String modifyPlanInternshipDetail() {
		return "redirect:/planInternshipDetail";
	}
	/*----------------------------------------- 인턴십 상세 계획 관리 수정 End ---------------------------*/
	/*----------------------------------------- 인턴십 상세 계획 관리 삭제 Start ---------------------------*/
	
	/*----------------------------------------- 인턴십 상세 계획 관리 삭제 End ---------------------------*/
	/*--------------------------------------::: 인턴십 상세 계획 관리 End :::-------------------------*/
	
	
	
	/*--------------------------------------::: 공모전 상세 계획 관리 Start :::------------------------*/
	//공모전 상세 계획 관리
	@GetMapping("/planContestDetail")
	public String planContestDetail(Model model) {//, String paramList
		//log.info("==============================================");
		//log.info("planContestDetail 메서드 실행");
		//log.info("==============================================");
		System.out.println("==============================================");
		System.out.println("planContestDetail 메서드 실행");
		System.out.println("==============================================");
		//List<DetailPlanDto> detailContestPlanList=detailPlanService.getContestDetailPlanList(paramList);
		
		String userEmail= "park01@hanmail.net";
		String searchKey="user_email";
		String searchValue=userEmail;
		List<PlanDto> totalPlanList = planService.getTotalPlan(searchKey, searchValue);
		
		
		model.addAttribute("title", "프로젝트 상세 계획");
		model.addAttribute("function", "plan");			//기능별 left 메뉴노출
		model.addAttribute("totalPlanList",totalPlanList);
		//model.addAttribute("detailContestPlanList", detailContestPlanList);
		
		return "plan/detailPlan/planContestDetail";
	}
	
	/*----------------------------------------- 공모전 상세 계획 관리 수정 Start ---------------------------*/
	@GetMapping("/modifyPlanContestDetail")
	public String modifyPlanContestDetail(Model model){
		model.addAttribute("title", "공모전 상세 계획 ");
		model.addAttribute("function", "none");
		return "plan/detailPlan/modifyPlanContestDetail";
	}
	
	@PostMapping("/modifyPlanContestDetail")
	public String modifyPlanContestDetail() {
		return "redirect:/planContestDetail";
	}
	/*----------------------------------------- 공모전 상세 계획 관리 수정 End ---------------------------*/
	/*----------------------------------------- 공모전 상세 계획 관리 삭제 Start ---------------------------*/
	
	/*----------------------------------------- 공모전 상세 계획 관리 삭제 End ---------------------------*/
	/*--------------------------------------::: 공모전 상세 계획 관리 End :::-------------------------*/
	
	
	
	/*--------------------------------------::: 경력 상세 계획 관리 Start :::-------------------------*/
	//경력 상세 계획 관리
	@GetMapping("/planCareerDetail")
	public String planCareerDetail(Model model) {//, String paramList
		//log.info("==============================================");
		//log.info("planCareerDetail 메서드 실행");
		//log.info("==============================================");
		System.out.println("==============================================");
		System.out.println("planCareerDetail 메서드 실행");
		System.out.println("==============================================");
		//List<DetailPlanDto> detailCareerPlanList=detailPlanService.getCareerDetailPlanList(paramList);
		
		String userEmail= "park01@hanmail.net";
		String searchKey="user_email";
		String searchValue=userEmail;
		List<PlanDto> totalPlanList = planService.getTotalPlan(searchKey, searchValue);
		
		
		model.addAttribute("title", "프로젝트 상세 계획");
		model.addAttribute("function", "plan");			//기능별 left 메뉴노출
		model.addAttribute("totalPlanList",totalPlanList);
		//model.addAttribute("detailCareerPlanList", detailCareerPlanList);
		
		return "plan/detailPlan/planCareerDetail";
	}
	
	/*----------------------------------------- 경력 상세 계획 관리 수정 Start ----------------------------*/
	@GetMapping("/modifyPlanCareerDetail")
	public String modifyPlanCareerDetail(Model model){
		model.addAttribute("title", "경력 상세 계획 ");
		model.addAttribute("function", "none");
		return "plan/detailPlan/modifyPlanCareerDetail";
	}
	
	@PostMapping("/modifyPlanCareerDetail")
	public String modifyPlanCareerDetail() {
		return "redirect:/planCareerDetail";
	}
	/*----------------------------------------- 경력 상세 계획 관리 수정 End ----------------------------*/
	/*----------------------------------------- 경력 상세 계획 관리 삭제 Start ----------------------------*/
	
	/*----------------------------------------- 경력 상세 계획 관리 삭제 End ----------------------------*/
	/*--------------------------------------::: 경력 상세 계획 관리 End :::-------------------------*/
	
	
	
}
