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
	public CoachUser getCoachInfoById(String coachEmail);
	//코치 수정
	public int modifyCoachUser(CoachUser coachUser);
	//코치 이메일 찾기
	public CoachUser coachForgotEmail(String coachName, String coachMobile);
	//코치 패스워드 찾기
	public CoachUser coachForgotPassword(String coachEmail, String coachPasswordAnswer);
	//코치 프로필 수정
	public int modifyProfilePicture(Object coachEmail,String coachProfilePicture);
}
