package com.devcdper.user_admin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devcdper.user_admin.dao.AdminUserMapper;
import com.devcdper.user_admin.domain.AdminUser;

@Service
public class AdminUserService {
	
	@Autowired
	private AdminUserMapper adminUserMapper;
	
	@PostConstruct
	public void normalUserServiceInit() {
		System.out.println("========================================");
		System.out.println("AdminUserService 객체 생성");
		System.out.println("========================================");
	}
	
	//패스워드 찾기		
	public AdminUser adminForgotPassword(String adminEmail, String adminPasswordAnswer) {
		System.out.println(adminEmail +  adminPasswordAnswer);
		
		AdminUser adminUser = adminUserMapper.adminForgotPassword(adminEmail, adminPasswordAnswer);
		
		return adminUser;
	}
	
	//이메일 찾기
	public AdminUser adminForgotEmail(String adminName, String adminMobile) {
		
		System.out.println(adminName +  adminMobile);
		
		AdminUser adminUser = adminUserMapper.adminForgotEmail(adminName, adminMobile);
		
		return adminUser;
	}
	
	//로그인
	public Map<String, Object> loginAdminUser(String adminEmail, String adminPassword){
		
		boolean loginCheck = false;
		System.out.println(adminEmail + adminPassword);
		Map<String, Object> AdminUserInfoMap = new HashMap<String, Object>();
		
		AdminUser AdminUser = adminUserMapper.getAdminInfoById(adminEmail);
		System.out.println(AdminUser);
		if(AdminUser != null && adminPassword.equals(AdminUser.getAdminPassword())) {
			System.out.println("hi@");
			loginCheck = true;
			AdminUserInfoMap.put("loginAdminUser", AdminUser);
		}
		AdminUserInfoMap.put("loginCheck", loginCheck);
		
		return AdminUserInfoMap;
	}
	
	//수정
	public int modifyAdminUser(AdminUser adminUser) {
		int result = adminUserMapper.modifyAdminUser(adminUser);
				
		return result;
	}
	
	//수정폼까지 //이메일 중복체크
	public AdminUser getAdminInfoById(String adminEmail) {
		
		return adminUserMapper.getAdminInfoById(adminEmail);
	}
	

	//관리자 회원가입
	public int addAdminUser(AdminUser adminUser) {
		
		int result = adminUserMapper.addAdminUser(adminUser);
		
		return result;
	}
	
	//관리자 리스트
	public List<AdminUser> getAdminUserList(){
		return adminUserMapper.getAdminUserList();

	}



}
