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
	
	//adminFindPassword				
	
	//이메일 찾기
	public Map<String, Object> adminFindEmail(String adminName, String adminMobile){
		
		boolean FindEmailcheck = false;
		System.out.println(adminName +"==="+adminMobile);
		Map<String, Object> FindEmailInfoMap = new HashMap<String, Object>();
		
		AdminUser AdminUser = (com.devcdper.user_admin.domain.AdminUser) adminUserMapper.adminFindEmail(adminName, adminMobile);
		System.out.println(AdminUser);
		
		if(AdminUser != null && adminName.equals(AdminUser.getAdminName()) && adminMobile.equals(AdminUser.getAdminMobile())) {
			System.out.println("AdminFindEmail@@@@@@");
			FindEmailcheck = true;
			FindEmailInfoMap.put("AdminFindEmail", AdminUser);
		}
		FindEmailInfoMap.put("FindEmailcheck", FindEmailcheck);
		
		return FindEmailInfoMap;
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
	//수정폼까지
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
