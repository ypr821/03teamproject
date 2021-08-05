package com.devcdper.plan.service;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devcdper.plan.dao.DetailPlanMapper;
import com.devcdper.plan.domain.DetailPlanDto;
import com.devcdper.plan.domain.PlanDto;


@Service
@Transactional
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
	
	//학력 상세 계획 리스트 
	public List<DetailPlanDto> getEducationalHistoryDetailPlanList(String totalPlanCode,String planCode){// String totalPlanCode,String planCode                  
		//if(request.getRUI...?){}
		
		List<DetailPlanDto> getEducationalHistoryDetailPlanList = detailPlanMapper.getEducationalHistoryDetailPlanList(totalPlanCode, planCode);
		
		System.out.println(totalPlanCode+" <- AJAX2 service");
		System.out.println(planCode+" <- AJAX2 service");
		return getEducationalHistoryDetailPlanList;

	}
	
	//프로젝트 상세 계획
	public List<DetailPlanDto> getProjectDetailPlanList(String totalPlanCode,String planCode){
		List<DetailPlanDto> detailProjectPlanList = detailPlanMapper.getProjectDetailPlanList(totalPlanCode, planCode);
		//System.out.println("프로젝트상세계획 가져오남?");
		return detailProjectPlanList;
	}
	
	//자격증 상세 계획
	public List<DetailPlanDto> getCertificateDetailPlanList(String totalPlanCode,String planCode){
		List<DetailPlanDto> detailCertificatePlanList=detailPlanMapper.getCertificateDetailPlanList(totalPlanCode,planCode);
		return detailCertificatePlanList;
	}
	//공인어학 상세 계획
	public List<DetailPlanDto> getCertifiedLanguageDetailPlanList(String totalPlanCode,String planCode){
		List<DetailPlanDto> detailCertifiedLanguagePlanList=detailPlanMapper.getCertifiedLanguageDetailPlanList(totalPlanCode,planCode);
		return detailCertifiedLanguagePlanList;
	}
	//기술스택 상세 계획
	public List<DetailPlanDto> getTechnologyStackDetailPlanList(String totalPlanCode,String planCode){
		List<DetailPlanDto> detailTechnologyStackPlanList=detailPlanMapper.getTechnologyStackDetailPlanList(totalPlanCode,planCode);
		return detailTechnologyStackPlanList;
	}
	//직종전문교육과정 상세 계획
	public List<DetailPlanDto> getJobTrainingDetailPlanList(String totalPlanCode,String planCode){
		List<DetailPlanDto> detailJobTrainingPlanList=detailPlanMapper.getJobTrainingDetailPlanList(totalPlanCode,planCode);
		return detailJobTrainingPlanList;
	}
	//인턴십 상세 계획
	public List<DetailPlanDto> getInternshipDetailPlanList(String totalPlanCode,String planCode){
		List<DetailPlanDto> detailInternshipPlanList=detailPlanMapper.getInternshipDetailPlanList(totalPlanCode,planCode);
		return detailInternshipPlanList;
	}
	//공모전 상세 계획
	public List<DetailPlanDto> getContestDetailPlanList(String totalPlanCode,String planCode){
		List<DetailPlanDto> detailContestPlanList=detailPlanMapper.getContestDetailPlanList(totalPlanCode,planCode);
		return detailContestPlanList;
	}
	//경력 상세 계획
	public List<DetailPlanDto> getCareerDetailPlanList(String totalPlanCode,String planCode){
		List<DetailPlanDto> detailCareerPlanList=detailPlanMapper.getCareerDetailPlanList(totalPlanCode,planCode);
		return detailCareerPlanList;
	}
	
	
	
	
	
	
	//통합계획 선택 서비스
	//학력 상세 계획
	public List<PlanDto> getEducationalHistoryTotalTitleSearch(String totalPlanCode){
		System.out.println("서비스 서치 접근 성공");
		return detailPlanMapper.getEducationalHistoryTotalTitleSearch(totalPlanCode);
	}
	
	//프로젝트 상세 계획
	public List<PlanDto> getProjectTotalTitleSearch(String totalPlanCode){
		System.out.println("서비스 서치 접근 성공");
		return detailPlanMapper.getProjectTotalTitleSearch(totalPlanCode);
	}
	
	//자격증 상세 계획
	public List<PlanDto> getCertificateTotalTitleSearch(String totalPlanCode){
		System.out.println("자격증 서비스 서치 접근 성공");
		return detailPlanMapper.getCertificateTotalTitleSearch(totalPlanCode);
	}
	//공인어학 상세 계획
	public List<PlanDto> getCertifiedLanguageTotalTitleSearch(String totalPlanCode){
		System.out.println("공인어학 서비스 서치 접근 성공");
		return detailPlanMapper.getCertifiedLanguageTotalTitleSearch(totalPlanCode);
	}
	//기술스택 상세 계획
	public List<PlanDto> getTechnologyStackTotalTitleSearch(String totalPlanCode){
		System.out.println("서비스 서치 접근 성공");
		return detailPlanMapper.getTechnologyStackTotalTitleSearch(totalPlanCode);
	}
	//직종전문교육과정 상세 계획
	public List<PlanDto> getJobTrainingTotalTitleSearch(String totalPlanCode){
		System.out.println("서비스 서치 접근 성공");
		return detailPlanMapper.getJobTrainingTotalTitleSearch(totalPlanCode);
	}
	//인턴십 상세 계획
	public List<PlanDto> getInternshipTotalTitleSearch(String totalPlanCode){
		System.out.println("서비스 서치 접근 성공");
		return detailPlanMapper.getInternshipTotalTitleSearch(totalPlanCode);
	}
	//공모전 상세 계획
	public List<PlanDto> getContestTotalTitleSearch(String totalPlanCode){
		System.out.println("서비스 서치 접근 성공");
		return detailPlanMapper.getContestTotalTitleSearch(totalPlanCode);
	}
	//경력 상세 계획
	public List<PlanDto> getCareerTotalTitleSearch(String totalPlanCode){
		System.out.println("서비스 서치 접근 성공");
		return detailPlanMapper.getCareerTotalTitleSearch(totalPlanCode);
	}
	
}
