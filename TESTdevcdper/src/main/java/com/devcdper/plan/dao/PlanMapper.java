package com.devcdper.plan.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.devcdper.plan.domain.PlanDto;


@Mapper
public interface PlanMapper {
	// 통합계획 등록
	public int addTotalPlan(PlanDto planDto);
	
	// 한명회원 통합계획 전체조회
	public List<PlanDto> getTotalPlan(String searchKey, String searchValue);
	
}
