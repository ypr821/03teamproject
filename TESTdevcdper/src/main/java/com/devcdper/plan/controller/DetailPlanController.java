package com.devcdper.plan.controller;

import javax.annotation.PostConstruct;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


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
	
	
	
	
	/*----------------------------------------- 상세 계획 한눈에보기 Start----------------------------*/
	//상세 계획 관리 화면 (카테고리 9가지 간단하게 담기-> 상세한건 따로 페이지 이동)
	@GetMapping("/detailPlan")
	public String detailPlan(Model model) {
		//log.info("==============================================");
		//log.info("detailPlan 메서드 실행");
		//log.info("==============================================");
		System.out.println("==============================================");
		System.out.println("detailPlan 메서드 실행");
		System.out.println("==============================================");
		model.addAttribute("title","상세계획 관리 화면");
		model.addAttribute("function", "plan");			//기능별 left 메뉴노출
		model.addAttribute("radioCheck", "detailPlan");
		return "plan/detailPlan/detailPlan";
	}
	/*----------------------------------------- 상세 계획 한눈에보기 End----------------------------*/
	
	/*--------------------------------------::: 학력 상세 계획 관리 Start :::-------------------------*/
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
		model.addAttribute("function", "plan");			//기능별 left 메뉴노출
		model.addAttribute("radioCheck", "planEducationalHistoryDetail");
		return "plan/detailPlan/planEducationalHistoryDetail";
	}
		
	/*----------------------------------------- 학력 상세 계획 관리 등록 Start----------------------------*/
	@GetMapping("/addPlanEducationalHistoryDetail")
	public String addPlanEducationalHistoryDetail(Model model) {
		model.addAttribute("title", "학력 상세계획 등록");
		model.addAttribute("function", "none");
		return "plan/detailPlan/addPlanEducationalHistoryDetail";
	}
	@PostMapping("/addPlanEducationalHistoryDetail")
	public String addPlanEducationalHistoryDetail() {
		return "redirect:/planEducationalHistoryDetail";
	}
	/*----------------------------------------- 학력 상세 계획 관리 등록 End------------------------------*/
	/*----------------------------------------- 학력 상세 계획 관리 수정 Start----------------------------*/
	@GetMapping("/modifyPlanEducationalHistoryDetail")
	public String modifyPlanEducationalHistoryDetail(Model model){
		model.addAttribute("title", "학력 상세계획 수정");
		model.addAttribute("function", "none");
		return "plan/detailPlan/modifyPlanEducationalHistoryDetail";
	}
	
	@PostMapping("/modifyPlanEducationalHistoryDetail")
	public String modifyPlanEducationalHistoryDetail() {
		return "redirect:/planEducationalHistoryDetail";
	}
	/*----------------------------------------- 학력 상세 계획 관리 수정 End------------------------------*/
	/*----------------------------------------- 학력 상세 계획 관리 삭제 Start----------------------------*/
	/**삭제 form을 만들어서 할지, modal? popup창을 띄워서  확인 후 삭제 처리 할지 고민중...*/
	 
	
	/*----------------------------------------- 학력 상세 계획 관리 삭제 End------------------------------*/
	/*--------------------------------------::: 학력 상세 계획 관리 End :::-------------------------*/
	

	
	/*--------------------------------------::: 프로젝트 상세 계획 관리 Start :::----------------------------*/
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
		model.addAttribute("function", "plan");			//기능별 left 메뉴노출
		model.addAttribute("radioCheck", "planProjectDetail");
		return "plan/detailPlan/planProjectDetail";
	}
	/*----------------------------------------- 프로젝트 상세 계획 관리 등록Start -------------------------------*/
	@GetMapping("/addPlanProjectDetail")
	public String addPlanProjectDetail(Model model) {
		model.addAttribute("title", "학력 상세계획 등록");
		model.addAttribute("function", "none");
		return "plan/detailPlan/addPlanProjectDetail";
	}
	@PostMapping("/addPlanProjectDetail")
	public String addPlanProjectDetail() {
		return "redirect:/planProjectDetail";
	}
	/*----------------------------------------- 프로젝트 상세 계획 관리 등록End -------------------------------*/
	/*----------------------------------------- 프로젝트 상세 계획 관리 수정Start -------------------------------*/
	@GetMapping("/modifyPlanProjectDetail")
	public String modifyPlanProjectDetail(Model model){
		model.addAttribute("title", "학력 상세계획 수정");
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
	public String planCertificateDetail(Model model) {
		//log.info("==============================================");
		//log.info("planCertificateDetail 메서드 실행");
		//log.info("==============================================");
		System.out.println("==============================================");
		System.out.println("planCertificateDetail 메서드 실행");
		System.out.println("==============================================");
		model.addAttribute("title", "자격증 상세 계획");
		model.addAttribute("function", "plan");			//기능별 left 메뉴노출
		model.addAttribute("radioCheck", "planCertificateDetail");
		return "plan/detailPlan/planCertificateDetail";
	}
	/*----------------------------------------- 자격증 상세 계획 관리 등록 Start ----------------------------*/
	@GetMapping("/addPlanCertificateDetail")
	public String addPlanCertificateDetail(Model model) {
		model.addAttribute("title", "학력 상세계획 등록");
		model.addAttribute("function", "none");
		return "plan/detailPlan/addPlanCertificateDetail";
	}
	@PostMapping("/addPlanCertificateDetail")
	public String addPlanCertificateDetail() {
		return "redirect:/planCertificateDetail";
	}
	/*----------------------------------------- 자격증 상세 계획 관리 등록 End ----------------------------*/
	/*----------------------------------------- 자격증 상세 계획 관리 수정 Start ----------------------------*/
	@GetMapping("/modifyPlanCertificateDetail")
	public String modifyPlanCertificateDetail(Model model){
		model.addAttribute("title", "학력 상세계획 수정");
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
	public String planCertifiedLanguageDetail(Model model) {
		//log.info("==============================================");
		//log.info("planCertifiedLanguageDetail 메서드 실행");
		//log.info("==============================================");
		System.out.println("==============================================");
		System.out.println("planCertifiedLanguageDetail 메서드 실행");
		System.out.println("==============================================");
		model.addAttribute("title", "공인어학 상세 계획");
		model.addAttribute("function", "plan");			//기능별 left 메뉴노출
		model.addAttribute("radioCheck", "planCertifiedLanguageDetail");
		return "plan/detailPlan/planCertifiedLanguageDetail";
	}
	/*----------------------------------------- 공인어학 상세 계획 관리 등록 Start ----------------------------*/
	@GetMapping("/addPlanCertifiedLanguageDetail")
	public String addPlanCertifiedLanguageDetail(Model model) {
		model.addAttribute("title", "학력 상세계획 등록");
		model.addAttribute("function", "none");
		return "plan/detailPlan/addPlanCertifiedLanguageDetail";
	}
	@PostMapping("/addPlanCertifiedLanguageDetail")
	public String addPlanCertifiedLanguageDetail() {
		return "redirect:/planCertifiedLanguageDetail";
	}
	/*----------------------------------------- 공인어학 상세 계획 관리 등록 End ----------------------------*/
	/*----------------------------------------- 공인어학 상세 계획 관리 수정 Start ----------------------------*/
	@GetMapping("/modifyPlanCertifiedLanguageDetail")
	public String modifyPlanCertifiedLanguageDetail(Model model){
		model.addAttribute("title", "학력 상세계획 수정");
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
	public String planTechnologyStackDetail(Model model) {
		//log.info("==============================================");
		//log.info("planTechnologyStackDetail 메서드 실행");
		//log.info("==============================================");
		System.out.println("==============================================");
		System.out.println("planTechnologyStackDetail 메서드 실행");
		System.out.println("==============================================");
		model.addAttribute("title", "기술스택 상세 계획");
		model.addAttribute("function", "plan");			//기능별 left 메뉴노출
		model.addAttribute("radioCheck", "planTechnologyStackDetail");
		return "plan/detailPlan/planTechnologyStackDetail";
	}
	/*----------------------------------------- 기술스택 상세 계획 관리 등록 Start ---------------------------*/
	@GetMapping("/addPlanTechnologyStackDetail")
	public String addPlanTechnologyStackDetail(Model model) {
		model.addAttribute("title", "학력 상세계획 등록");
		model.addAttribute("function", "none");
		return "plan/detailPlan/addPlanTechnologyStackDetail";
	}
	@PostMapping("/addPlanTechnologyStackDetail")
	public String addPlanTechnologyStackDetail() {
		return "redirect:/planTechnologyStackDetail";
	}
	/*----------------------------------------- 기술스택 상세 계획 관리 등록 End ---------------------------*/
	/*----------------------------------------- 기술스택 상세 계획 관리 수정 Start ---------------------------*/
	@GetMapping("/modifyPlanTechnologyStackDetail")
	public String modifyPlanTechnologyStackDetail(Model model){
		model.addAttribute("title", "학력 상세계획 수정");
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
	public String planJobTrainingDetail(Model model) {
		//log.info("==============================================");
		//log.info("planJobTrainingDetail 메서드 실행");
		//log.info("==============================================");
		System.out.println("==============================================");
		System.out.println("planJobTrainingDetail 메서드 실행");
		System.out.println("==============================================");
		model.addAttribute("title", "직종전문교육과정 상세 계획");
		model.addAttribute("function", "plan");			//기능별 left 메뉴노출
		model.addAttribute("radioCheck", "planJobTrainingDetail");
		return "plan/detailPlan/planJobTrainingDetail";
	}
	/*----------------------------------------- 직종전문교육과정 상세 계획 관리 등록 Start ----------------------------*/
	@GetMapping("/addPlanJobTrainingDetail")
	public String addPlanJobTrainingDetail(Model model) {
		model.addAttribute("title", "학력 상세계획 등록");
		model.addAttribute("function", "none");
		return "plan/detailPlan/addPlanJobTrainingDetail";
	}
	@PostMapping("/addPlanJobTrainingDetail")
	public String addPlanJobTrainingDetail() {
		return "redirect:/planJobTrainingDetail";
	}
	/*----------------------------------------- 직종전문교육과정 상세 계획 관리 등록 End ----------------------------*/
	/*----------------------------------------- 직종전문교육과정 상세 계획 관리 수정 Start ----------------------------*/
	@GetMapping("/modifyPlanJobTrainingDetail")
	public String modifyPlanJobTrainingDetail(Model model){
		model.addAttribute("title", "학력 상세계획 수정");
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
	public String planInternshipDetail(Model model) {
		//log.info("==============================================");
		//log.info("planInternshipDetail 메서드 실행");
		//log.info("==============================================");
		System.out.println("==============================================");
		System.out.println("planInternshipDetail 메서드 실행");
		System.out.println("==============================================");
		model.addAttribute("title", "인턴십 상세 계획");
		model.addAttribute("function", "plan");			//기능별 left 메뉴노출
		model.addAttribute("radioCheck", "planInternshipDetail");
		return "plan/detailPlan/planInternshipDetail";
	}
	/*----------------------------------------- 인턴십 상세 계획 관리 등록 Start ---------------------------*/
	@GetMapping("/addPlanInternshipDetail")
	public String addPlanInternshipDetail(Model model) {
		model.addAttribute("title", "학력 상세계획 등록");
		model.addAttribute("function", "none");
		return "plan/detailPlan/addPlanInternshipDetail";
	}
	@PostMapping("/addPlanInternshipDetail")
	public String addPlanInternshipDetail() {
		return "redirect:/planInternshipDetail";
	}
	/*----------------------------------------- 인턴십 상세 계획 관리 등록 End ---------------------------*/
	/*----------------------------------------- 인턴십 상세 계획 관리 수정 Start ---------------------------*/
	@GetMapping("/modifyPlanInternshipDetail")
	public String modifyPlanInternshipDetail(Model model){
		model.addAttribute("title", "학력 상세계획 수정");
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
	public String planContestDetail(Model model) {
		//log.info("==============================================");
		//log.info("planContestDetail 메서드 실행");
		//log.info("==============================================");
		System.out.println("==============================================");
		System.out.println("planContestDetail 메서드 실행");
		System.out.println("==============================================");
		model.addAttribute("title", "공모전 상세 계획");
		model.addAttribute("function", "plan");			//기능별 left 메뉴노출
		model.addAttribute("radioCheck", "planContestDetail");
		return "plan/detailPlan/planContestDetail";
	}
	/*----------------------------------------- 공모전 상세 계획 관리 등록 Start ---------------------------*/
	@GetMapping("/addPlanContestDetail")
	public String addPlanContestDetail(Model model) {
		model.addAttribute("title", "학력 상세계획 등록");
		model.addAttribute("function", "none");
		return "plan/detailPlan/addPlanContestDetail";
	}
	@PostMapping("/addPlanContestDetail")
	public String addPlanContestDetail() {
		return "redirect:/planContestDetail";
	}
	/*----------------------------------------- 공모전 상세 계획 관리 등록 End ---------------------------*/
	/*----------------------------------------- 공모전 상세 계획 관리 수정 Start ---------------------------*/
	@GetMapping("/modifyPlanContestDetail")
	public String modifyPlanContestDetail(Model model){
		model.addAttribute("title", "학력 상세계획 수정");
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
	public String planCareerDetail(Model model) {
		//log.info("==============================================");
		//log.info("planCareerDetail 메서드 실행");
		//log.info("==============================================");
		System.out.println("==============================================");
		System.out.println("planCareerDetail 메서드 실행");
		System.out.println("==============================================");
		model.addAttribute("title", "경력 상세 계획");
		model.addAttribute("function", "plan");			//기능별 left 메뉴노출
		model.addAttribute("radioCheck", "planCareerDetail");
		return "plan/detailPlan/planCareerDetail";
	}
	/*----------------------------------------- 경력 상세 계획 관리 등록 Start ----------------------------*/
	@GetMapping("/addPlanCareerDetail")
	public String addPlanCareerDetail(Model model) {
		model.addAttribute("title", "학력 상세계획 등록");
		model.addAttribute("function", "none");
		return "plan/detailPlan/addPlanCareerDetail";
	}
	@PostMapping("/addPlanCareerDetail")
	public String addPlanCareerDetail() {
		return "redirect:/planCareerDetail";
	}
	/*----------------------------------------- 경력 상세 계획 관리 등록 End ----------------------------*/
	/*----------------------------------------- 경력 상세 계획 관리 수정 Start ----------------------------*/
	@GetMapping("/modifyPlanCareerDetail")
	public String modifyPlanCareerDetail(Model model){
		model.addAttribute("title", "학력 상세계획 수정");
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
