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
		System.out.println("MemberService 객체 생성");
		System.out.println("========================================");
	}
	
	public Map<String, Object> loginNomalUser(String userEmail, String userPasswrod){
		
		boolean loginCheck = false;
		
		Map<String, Object> nomalUserInfoMap = new HashMap<String, Object>();
		
		NormalUser nomalUser = normalUserMapper.getNormalInfoById(userEmail);
		
		if(nomalUser != null && userPasswrod.equals(nomalUser.getUserPasswrod())) {
			loginCheck = true;
			nomalUserInfoMap.put("loginNomalUser", nomalUser);
		}
		nomalUserInfoMap.put("loginCheck", loginCheck);
		
		return nomalUserInfoMap;
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
}
