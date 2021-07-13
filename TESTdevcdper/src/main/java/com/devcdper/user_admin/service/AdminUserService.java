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
	
	public Map<String, Object> loginAdminUser(String adminEmail, String adminPassword){
		
		boolean loginCheck = false;
		System.out.println(adminEmail + adminPassword);
		Map<String, Object> AdminUserInfoMap = new HashMap<String, Object>();
		
		AdminUser AdminUser = adminUserMapper.getAdminInfoById(adminEmail);
//		System.out.println(nomalUser);
		if(AdminUser != null && adminPassword.equals(AdminUser.getAdminPassword())) {
			System.out.println("hi@");
			loginCheck = true;
			AdminUserInfoMap.put("loginAdminUser", AdminUser);
		}
		AdminUserInfoMap.put("loginCheck", loginCheck);
		
		return AdminUserInfoMap;
	}
	
	
	public int modifyAdminUser(AdminUser adminUser) {
		
		
		
		
		int result = adminUserMapper.modifyAdminUser(adminUser);
				
		return result;
	}
	
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
