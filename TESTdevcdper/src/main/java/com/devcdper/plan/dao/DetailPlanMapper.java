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
	public List<DetailPlanDto> getProjectDetailPlanList(String paramList);
	
	//자격증 상세 계획 리스트
	public List<DetailPlanDto> getCertificateDetailPlanList(String paramList);
	//공인어학 상세 계획 리스트
	public List<DetailPlanDto> getCertifiedLanguageDetailPlanList(String paramList);
	//기술스택 상세 계획 리스트
	public List<DetailPlanDto> getTechnologyStackDetailPlanList(String paramList);
	//직종전문교육과정 상세 계획 리스트
	public List<DetailPlanDto> getJobTrainingDetailPlanList(String paramList);
	//인턴십 상세 계획 리스트
	public List<DetailPlanDto> getInternshipDetailPlanList(String paramList);
	//공모전 상세 계획 리스트
	public List<DetailPlanDto> getContestDetailPlanList(String paramList);
	//경력 상세 계획 리스트
	public List<DetailPlanDto> getCareerDetailPlanList(String paramList);
	
	
	//타이틀 서치 (통합계획 선택)
	//학력 상세 계획 타이틀 서치
	public List<PlanDto> getEduTotalTitleSearch(String stotalPlanCode);
	
	//프로젝트 상세 계획 타이틀 서치
	public List<PlanDto> getProjTotalTitleSearch(String stotalPlanCode);
}
