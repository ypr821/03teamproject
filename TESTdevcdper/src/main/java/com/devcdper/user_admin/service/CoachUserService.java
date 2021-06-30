package com.devcdper.user_admin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devcdper.user_admin.dao.CoachUserMapper;
import com.devcdper.user_admin.domain.CoachUser;

@Service
public class CoachUserService {
	
	@Autowired
	private CoachUserMapper coachUserMapper;
	
	@PostConstruct
	public void normalUserServiceInit() {
		System.out.println("========================================");
		System.out.println("CoachUserService 객체 생성");
		System.out.println("========================================");
	}
	
	public Map<String, Object> loginCoachUser(String coachEmail, String coachPassword){
		
		boolean loginCheck = false;
		System.out.println(coachEmail + coachPassword);
		Map<String, Object> coachUserInfoMap = new HashMap<String, Object>();
		
		CoachUser coachUser = coachUserMapper.getCoachInfoById(coachEmail);
		if(coachEmail != null && coachPassword.equals(coachUser.getCoachPassword() )) {
			loginCheck = true;
			coachUserInfoMap.put("loginCoachUser", coachUser);
		}
		coachUserInfoMap.put("loginCheck", loginCheck);
		
		return coachUserInfoMap;
	}
	
	//코치 리스트
	public List<CoachUser> getCoachList(){
		
		return coachUserMapper.getCoachList();
	}
	//회원가입
	public int addCoachUser(CoachUser coachUser) {
		
		return coachUserMapper.addCoachUser(coachUser);
	}
	//회원정보수정폼 까지
	public CoachUser getCoachInfoById(String coachUserEmail) {
		
		return coachUserMapper.getCoachInfoById(coachUserEmail);
	}
	//회원 수정
	public int modifyCoachUser(CoachUser coachUser) {
		
		return coachUserMapper.modifyCoachUser(coachUser);
	}

}
