package com.devcdper.plan.service;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devcdper.plan.dao.DetailPlanMapper;
import com.devcdper.plan.domain.DetailPlanDto;
import com.devcdper.plan.domain.PlanDto;


@Service
public class DetailPlanService {
	
	private final DetailPlanMapper detailPlanMapper;
	
	public DetailPlanService(DetailPlanMapper detailPlanMapper) {
		this.detailPlanMapper = detailPlanMapper;
	}
	
	@PostConstruct
	public void detailPlanServiceInit() {
		//log.info("========================================");
		//log.info("MemberService 객체 생성");
		//log.info("========================================");
		System.out.println("====================================");
		System.out.println("DetailPlanService 객체 생성");
		System.out.println("====================================");
	}
	
	//상세 계획 별(?) 리스트
//	public List<DetailPlanDto> getDetailPlanList(String paramList){// String totalPlanCode,String planCode
//		List<DetailPlanDto> detailPlanList = detailPlanMapper.getDetailPlanList(paramList);
//		System.out.println("@@@@@@@ : "+detailPlanList.get(0).getPlanDetailContents());
//		
//		return detailPlanList;
//
//	}
	
	//상세 계획 별(?)리스트 // 학력 상세 계획 
	public List<DetailPlanDto> getDetailPlanList(String totalPlanCode,String planCode){// String totalPlanCode,String planCode                  
		//if(request.){}
		List<DetailPlanDto> detailPlanList = detailPlanMapper.getEducationalHistoryDetailPlanList(totalPlanCode, planCode);                   
		System.out.println(totalPlanCode+" <- AJAX2 service");
		System.out.println(planCode+" <- AJAX2 service");
		return detailPlanList;

	}
	
	//프로젝트 상세 계획
	public List<DetailPlanDto> getProjectDetailPlanList(String paramList){
		List<DetailPlanDto> detailProjectPlanList = detailPlanMapper.getProjectDetailPlanList(paramList);
		return detailProjectPlanList;
	}
	//자격증 상세 계획
	public List<DetailPlanDto> getCertificateDetailPlanList(String paramList){
		List<DetailPlanDto> detailCertificatePlanList=detailPlanMapper.getCertificateDetailPlanList(paramList);
		return detailCertificatePlanList;
	}
	//공인어학 상세 계획
	public List<DetailPlanDto> getCertifiedLanguageDetailPlanList(String paramList){
		List<DetailPlanDto> detailCertifiedLanguagePlanList=detailPlanMapper.getCertifiedLanguageDetailPlanList(paramList);
		return detailCertifiedLanguagePlanList;
	}
	//기술스택 상세 계획
	public List<DetailPlanDto> getTechnologyStackDetailPlanList(String paramList){
		List<DetailPlanDto> detailTechnologyStackPlanList=detailPlanMapper.getTechnologyStackDetailPlanList(paramList);
		return detailTechnologyStackPlanList;
	}
	//직종전문교육과정 상세 계획
	public List<DetailPlanDto> getJobTrainingDetailPlanList(String paramList){
		List<DetailPlanDto> detailJobTrainingPlanList=detailPlanMapper.getJobTrainingDetailPlanList(paramList);
		return detailJobTrainingPlanList;
	}
	//인턴십 상세 계획
	public List<DetailPlanDto> getInternshipDetailPlanList(String paramList){
		List<DetailPlanDto> detailInternshipPlanList=detailPlanMapper.getInternshipDetailPlanList(paramList);
		return detailInternshipPlanList;
	}
	//공모전 상세 계획
	public List<DetailPlanDto> getContestDetailPlanList(String paramList){
		List<DetailPlanDto> detailContestPlanList=detailPlanMapper.getContestDetailPlanList(paramList);
		return detailContestPlanList;
	}
	//경력 상세 계획
	public List<DetailPlanDto> getCareerDetailPlanList(String paramList){
		List<DetailPlanDto> detailCareerPlanList=detailPlanMapper.getCareerDetailPlanList(paramList);
		return detailCareerPlanList;
	}
	
	
	
	
	
	
	//통합계획 선택 서비스
	//학력 상세 계획
	public List<PlanDto> getEduTotalTitleSearch(String stotalPlanCode){
		return detailPlanMapper.getEduTotalTitleSearch(stotalPlanCode);
	}
	
	//프로젝트 상세 계획
	public List<PlanDto> getProjTotalTitleSearch(String stotalPlanCode){
		return detailPlanMapper.getProjTotalTitleSearch(stotalPlanCode);
	}
	
	
	
}
