package com.devcdper.plan.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.devcdper.plan.domain.DetailPlanDto;
import com.devcdper.plan.domain.PlanDto;

@Mapper
public interface DetailPlanMapper {
	
	/* 회원의 상세 계획 조회 리스트*/
	//학력 상세 계획  리스트
	//public List<DetailPlanDto> getDetailPlanList(String paramList);//String totalPlanCode,String planCode
	public List<DetailPlanDto> getEducationalHistoryDetailPlanList(String totalPlanCode,String planCode);//
	
	
	//프로젝트 상세 계획 리스트
	//public List<DetailPlanDto> getProjectDetailPlanList(String paramList);
	public List<DetailPlanDto> getProjectDetailPlanList(String totalPlanCode,String planCode);
	
	//자격증 상세 계획 리스트
	public List<DetailPlanDto> getCertificateDetailPlanList(String totalPlanCode,String planCode);
	//공인어학 상세 계획 리스트
	public List<DetailPlanDto> getCertifiedLanguageDetailPlanList(String totalPlanCode,String planCode);
	//기술스택 상세 계획 리스트
	public List<DetailPlanDto> getTechnologyStackDetailPlanList(String totalPlanCode,String planCode);
	//직종전문교육과정 상세 계획 리스트
	public List<DetailPlanDto> getJobTrainingDetailPlanList(String totalPlanCode,String planCode);
	//인턴십 상세 계획 리스트
	public List<DetailPlanDto> getInternshipDetailPlanList(String totalPlanCode,String planCode);
	//공모전 상세 계획 리스트
	public List<DetailPlanDto> getContestDetailPlanList(String totalPlanCode,String planCode);
	//경력 상세 계획 리스트
	public List<DetailPlanDto> getCareerDetailPlanList(String totalPlanCode,String planCode);
	
	
	//타이틀 서치 (통합계획 선택)
	//학력 상세 계획 타이틀 서치
	public List<PlanDto> getEducationalHistoryTotalTitleSearch(String stotalPlanCode);
	
	//프로젝트 상세 계획 타이틀 서치
	public List<PlanDto> getProjectTotalTitleSearch(String stotalPlanCode);
	
	//자격증 상세 계획 타이틀 서치  
	public List<PlanDto> getCertificateTotalTitleSearch(String stotalPlanCode);
	
	//공인어학 상세 계획 타이틀 서치 
	public List<PlanDto> getCertifiedLanguageTotalTitleSearch(String stotalPlanCode);
	//기술스택 상세 계획 타이틀 서치
	public List<PlanDto> getTechnologyStackTotalTitleSearch(String stotalPlanCode);
	//직종전문교육과정 상세 타이틀 서치
	public List<PlanDto> getJobTrainingTotalTitleSearch(String stotalPlanCode);
	//인턴십 상세 계획 타이틀 서치
	public List<PlanDto> getInternshipTotalTitleSearch(String stotalPlanCode);
	
	//공모전 상세 계획 타이틀 서치
	public List<PlanDto> getContestTotalTitleSearch(String stotalPlanCode);
	//경력 상세 계획 타이틀 서치
	public List<PlanDto> getCareerTotalTitleSearch(String stotalPlanCode);
	
	
	
	
	
	
	
}
