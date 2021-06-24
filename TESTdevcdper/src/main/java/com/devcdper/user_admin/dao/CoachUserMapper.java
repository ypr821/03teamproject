package com.devcdper.user_admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.devcdper.user_admin.domain.CoachUser;

@Mapper
public interface CoachUserMapper {
	
	//코치전체리스트
	public List<CoachUser> getCoachList();
	//코치회원가입
	public int addCoachUser(CoachUser coachUser);
	//코치 수정폼
	public CoachUser getCoachInfoById(String coachUserEmail);
	//코치 수정
//	public int get
	
}
