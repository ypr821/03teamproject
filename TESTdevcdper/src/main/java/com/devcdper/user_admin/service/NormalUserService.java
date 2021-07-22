package com.devcdper.user_admin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devcdper.user_admin.dao.NormalUserMapper;
import com.devcdper.user_admin.domain.NormalUser;

@Service
public class NormalUserService {
	
	@Autowired
	private NormalUserMapper normalUserMapper;
	
	@PostConstruct
	public void normalUserServiceInit() {
		System.out.println("========================================");
		System.out.println("NormalUserService 객체 생성");
		System.out.println("========================================");
	}
	
	//normalFindEmail				
	//normalFindPassword		
	
	
	public Map<String, Object> loginNomalUser(String userEmail, String userPassword){
		
		boolean loginCheck = false;
		System.out.println(userEmail + userPassword);
		Map<String, Object> normalUserInfoMap = new HashMap<String, Object>();
		
		NormalUser normalUser = normalUserMapper.getNormalInfoById(userEmail);
//		System.out.println(nomalUser);
		if(normalUser != null && userPassword.equals(normalUser.getUserPassword())) {
			System.out.println("hi@");
			loginCheck = true;
			normalUserInfoMap.put("loginNormalUser", normalUser);
		}
		normalUserInfoMap.put("loginCheck", loginCheck);
		
		return normalUserInfoMap;
	}
	
	//회원 리스트
	public List<NormalUser> getNormalUserList(){
		return normalUserMapper.getNormalUserList();
	}
	//회원가입
	public int addNormalUser(NormalUser normalUser) {
		int result = normalUserMapper.addNormalUser(normalUser);
		return result;
	}
	//회원 수정폼까지
	public NormalUser getNormalInfoById(String userEmail) {
		
		return normalUserMapper.getNormalInfoById(userEmail);
	}
	//회원정보수정
	public int modifyNormalUser(NormalUser normalUser) {
		
		return normalUserMapper.modifyNormalUser(normalUser);
	}
	//회원 프로필 수정
	public int modifyProfilePicture(Object userEmail,String userProfilePicture) {
			
		return normalUserMapper.modifyProfilePicture(userEmail ,userProfilePicture);
	}
}
