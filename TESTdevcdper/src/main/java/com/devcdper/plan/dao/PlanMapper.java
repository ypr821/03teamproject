package com.devcdper.plan.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.devcdper.plan.domain.PlanDto;


@Mapper
public interface PlanMapper {
	// 통합계획 등록
	public int addTotalPlan(PlanDto planDto);
	
	// 학력계획 등록
	public int addEducationalHistoryPlan(PlanDto planDto, String totalPlanCode);
	
	// 한명회원 통합계획 조회
	public List<PlanDto> getTotalPlan(String searchKey, String searchValue);
	
	// 한명회원 학력계획 조회
	public List<PlanDto> getEducationalHistoryPlan(String searchKey, String searchValue);
	
	// 한명회원 프로젝트계획 조회
	public List<PlanDto> getProjectPlan(String searchKey, String searchValue);
	
	// 한명회원 자격증 조회
	public List<PlanDto> getCertificatePlan(String searchKey, String searchValue);
	
	// 한명회원 공인어학 조회
	public List<PlanDto> getCertifiedLanguagePlan(String searchKey, String searchValue);
	
	// 한명회원 기술스택 조회
	public List<PlanDto> getTechnologyStackPlan(String searchKey, String searchValue);
	
	// 한명회원 직종전문교육과정 조회
	public List<PlanDto> getJobTrainingPlan(String searchKey, String searchValue);
	
	// 한명회원 인턴십 조회
	public List<PlanDto> getInternshipPlan(String searchKey, String searchValue);
	
	// 한명회원 공모전 조회
	public List<PlanDto> getContestPlan(String searchKey, String searchValue);
	
	// 한명회원 경력 조회
	public List<PlanDto> getCareerPlan(String searchKey, String searchValue);
	
}