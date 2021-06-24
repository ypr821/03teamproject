package com.devcdper.user_admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devcdper.user_admin.dao.CoachUserMapper;
import com.devcdper.user_admin.domain.CoachUser;


@Service
public class CoachUserService {
	
	@Autowired
	private CoachUserMapper coachUserMapper;
	
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
