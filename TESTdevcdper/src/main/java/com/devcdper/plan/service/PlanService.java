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
	
	// 한명회원 통합계획 전체조회
	public List<PlanDto> getTotalPlan(String searchKey, String searchValue){
		List<PlanDto> planDto = null;
		if(searchKey != null && !"".equals(searchKey)) {
			System.out.println(searchKey + " <<- searchKey : PlanService / getTotalPlan()");
			if(searchValue != null && !"".equals(searchValue)) {
				System.out.println(searchValue + " <<- searchValue : PlanService / getTotalPlan()");
				planDto = planMapper.getTotalPlan(searchKey, searchValue);
			}
		}
		return planDto;
	};
	
	
	
};
