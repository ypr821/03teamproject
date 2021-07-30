package com.devcdper.user_admin.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.devcdper.user_admin.domain.AdminUser;

@Mapper
public interface AdminUserMapper {
	
	//adminFindPassword				
	
	public Map<String, Object> adminFindEmail(String adminName, String adminMobile);
	
	//관리자 수정
	public int modifyAdminUser(AdminUser adminUser);
	
	//관리자 수정폼까지
	public AdminUser getAdminInfoById(String adminEmail);
	
	//관리자 회원가입
	public int addAdminUser(AdminUser adminUser);
	
	//관리자 전체리스트
	public List<AdminUser> getAdminUserList();

	public AdminUser adminForgotEmail(String adminName, String adminMobile);

	public AdminUser adminForgotPassword(String adminEmail, String adminPasswordAnswer);
}
