package com.devcdper.plan.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devcdper.plan.dao.PlanMapper;
import com.devcdper.plan.domain.PlanDto;

@Service
@Transactional
public class PlanService {
	
	private final PlanMapper planMapper;
	
	public PlanService(PlanMapper planMapper) {
		this.planMapper = planMapper;
	};
	
	// 통합계획 등록
	public int addTotalPlan(PlanDto planDto, String planName) {
		int result = 0;
		
		System.out.println(planDto.getUserEmail() + " <<- planDto.getUserEmail() : PlanService / addTotalPlan()");
		System.out.println(planName + " <<- planName : PlanService / addTotalPlan()");
		
		if(planName != null && !"".equals(planName) && planName.equals("totalPlan")) result = planMapper.addTotalPlan(planDto);
		
		return result;
	};
	
	// 한명회원 통합계획 조회
	public List<PlanDto> getTotalPlan(String searchKey, String searchValue){
		List<PlanDto> planDto = null;
		if(searchKey != null && !"".equals(searchKey)) {
			System.out.println(searchKey + " <<- searchKey : PlanService / getTotalPlan()");
			if(searchValue != null && !"".equals(searchValue)) {
				System.out.println(searchValue + " <<- searchValue : PlanService / getTotalPlan()");
				planDto = planMapper.getTotalPlan(searchKey, searchValue);
			};
		};
		return planDto;
	};
	
	// 한명회원 학력계획 조회
	public List<PlanDto> getEducationalHistoryPlan(String searchKey, String searchValue){
		List<PlanDto> planDto = null;
		if(searchKey != null && !"".equals(searchKey)) {
			System.out.println(searchKey + " <<- searchKey : PlanService / getEducationalHistoryPlan()");
			if(searchValue != null && !"".equals(searchValue)) {
				System.out.println(searchValue + " <<- searchValue : PlanService / getEducationalHistoryPlan()");
				planDto = planMapper.getEducationalHistoryPlan(searchKey, searchValue);
				return planDto;
			};
		};
		return planDto;
	};
	
	// 한명회원 프로젝트계획 조회
	public List<PlanDto> getProjectPlan(String searchKey, String searchValue){
		List<PlanDto> planDto = null;
		if(searchKey != null && !"".equals(searchKey)) {
			System.out.println(searchKey + " <<- searchKey : PlanService / getProjectPlan()");
			if(searchValue != null && !"".equals(searchValue)) {
				System.out.println(searchValue + " <<- searchValue : PlanService / getProjectPlan()");
				planDto = planMapper.getProjectPlan(searchKey, searchValue);
				return planDto;
			};
		};
		return planDto;
	};
	
	// 한명회원 자격증 조회
	public List<PlanDto> getCertificatePlan(String searchKey, String searchValue){
		List<PlanDto> planDto = null;
		if(searchKey != null && !"".equals(searchKey)) {
			System.out.println(searchKey + " <<- searchKey : PlanService / getCertificatePlan()");
			if(searchValue != null && !"".equals(searchValue)) {
				System.out.println(searchValue + " <<- searchValue : PlanService / getCertificatePlan()");
				planDto = planMapper.getCertificatePlan(searchKey, searchValue);
				return planDto;
			};
		};
		return planDto;
	};
	
	// 한명회원 공인어학 조회
	public List<PlanDto> getCertifiedLanguagePlan(String searchKey, String searchValue){
		List<PlanDto> planDto = null;
		if(searchKey != null && !"".equals(searchKey)) {
			System.out.println(searchKey + " <<- searchKey : PlanService / getCertifiedLanguagePlan()");
			if(searchValue != null && !"".equals(searchValue)) {
				System.out.println(searchValue + " <<- searchValue : PlanService / getCertifiedLanguagePlan()");
				planDto = planMapper.getCertifiedLanguagePlan(searchKey, searchValue);
				return planDto;
			};
		};
		return planDto;
	};
	
	// 한명회원 기술스택 조회
	public List<PlanDto> getTechnologyStackPlan(String searchKey, String searchValue){
		List<PlanDto> planDto = null;
		if(searchKey != null && !"".equals(searchKey)) {
			System.out.println(searchKey + " <<- searchKey : PlanService / getTechnologyStackPlan()");
			if(searchValue != null && !"".equals(searchValue)) {
				System.out.println(searchValue + " <<- searchValue : PlanService / getTechnologyStackPlan()");
				planDto = planMapper.getTechnologyStackPlan(searchKey, searchValue);
				return planDto;
			};
		};
		return planDto;
	};
	
	// 한명회원 직종전문교육과정 조회
	public List<PlanDto> getJobTrainingPlan(String searchKey, String searchValue){
		List<PlanDto> planDto = null;
		if(searchKey != null && !"".equals(searchKey)) {
			System.out.println(searchKey + " <<- searchKey : PlanService / getJobTrainingPlan()");
			if(searchValue != null && !"".equals(searchValue)) {
				System.out.println(searchValue + " <<- searchValue : PlanService / getJobTrainingPlan()");
				planDto = planMapper.getJobTrainingPlan(searchKey, searchValue);
				return planDto;
			};
		};
		return planDto;
	};
	
	// 한명회원 인턴십 조회
	public List<PlanDto> getInternshipPlan(String searchKey, String searchValue){
		List<PlanDto> planDto = null;
		if(searchKey != null && !"".equals(searchKey)) {
			System.out.println(searchKey + " <<- searchKey : PlanService / getInternshipPlan()");
			if(searchValue != null && !"".equals(searchValue)) {
				System.out.println(searchValue + " <<- searchValue : PlanService / getInternshipPlan()");
				planDto = planMapper.getInternshipPlan(searchKey, searchValue);
				return planDto;
			};
		};
		return planDto;
	};
	
	// 한명회원 공모전 조회
	public List<PlanDto> getContestPlan(String searchKey, String searchValue){
		List<PlanDto> planDto = null;
		if(searchKey != null && !"".equals(searchKey)) {
			System.out.println(searchKey + " <<- searchKey : PlanService / getContestPlan()");
			if(searchValue != null && !"".equals(searchValue)) {
				System.out.println(searchValue + " <<- searchValue : PlanService / getContestPlan()");
				planDto = planMapper.getContestPlan(searchKey, searchValue);
				return planDto;
			};
		};
		return planDto;
	};
	
	// 한명회원 경력 조회
	public List<PlanDto> getCareerPlan(String searchKey, String searchValue){
		List<PlanDto> planDto = null;
		if(searchKey != null && !"".equals(searchKey)) {
			System.out.println(searchKey + " <<- searchKey : PlanService / getCareerPlan()");
			if(searchValue != null && !"".equals(searchValue)) {
				System.out.println(searchValue + " <<- searchValue : PlanService / getCareerPlan()");
				planDto = planMapper.getCareerPlan(searchKey, searchValue);
				return planDto;
			};
		};
		return planDto;
	};
};
