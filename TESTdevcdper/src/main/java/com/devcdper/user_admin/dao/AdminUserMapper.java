package com.devcdper.user_admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.devcdper.user_admin.domain.AdminUser;

@Mapper
public interface AdminUserMapper {
	//관리자 전체리스트
	public List<AdminUser> getAdminUserList();
}
