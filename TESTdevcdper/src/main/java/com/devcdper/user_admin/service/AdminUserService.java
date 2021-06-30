package com.devcdper.user_admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devcdper.user_admin.dao.AdminUserMapper;
import com.devcdper.user_admin.domain.AdminUser;

@Service
public class AdminUserService {
	
	@Autowired
	private AdminUserMapper adminUserMapper;
	
	
	//회원 리스트
	public List<AdminUser> getAdminUserList(){
		return adminUserMapper.getAdminUserList();

	}
}
