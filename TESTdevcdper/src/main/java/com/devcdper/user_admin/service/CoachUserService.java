package com.devcdper.user_admin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devcdper.user_admin.dao.CoachUserMapper;
import com.devcdper.user_admin.domain.CoachUser;


@Service
public class CoachUserService {
	
	@Autowired
	private CoachUserMapper coachUserMapper;
	
	public Map<String, Object> loginCoachUser(String coachEmail, String coachPasswrod){
		
		boolean loginCheck = false;
		
		Map<String, Object> nomalUserInfoMap = new HashMap<String, Object>();
		
		CoachUser coachUser = coachUserMapper.getCoachInfoById(coachEmail);
				
		if(coachEmail != null && coachPasswrod.equals(coachUser.getCoachPassword() )) {
			loginCheck = true;
			nomalUserInfoMap.put("loginCoachUser", coachUser);
		}
		nomalUserInfoMap.put("loginCheck", loginCheck);
		
		return nomalUserInfoMap;
	}
	
	public List<CoachUser> getCoachList(){
		
		return coachUserMapper.getCoachList();
	}
	public int addCoahUser(CoachUser coachUser) {
		
		return coachUserMapper.addCoachUser(coachUser);
	}
	public CoachUser getCoachInfoById(String coachUserEmail) {
		
		return coachUserMapper.getCoachInfoById(coachUserEmail);
	}
//	public

}
