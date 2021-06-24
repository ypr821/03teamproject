package com.devcdper.user_admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.devcdper.user_admin.domain.NormalUser;

@Mapper
public interface NormalUserMapper {
	
	
	//회원전체 조회
	public List<NormalUser> getNormalUserList();
	//회원가입
	public int addNormalUser(NormalUser normalUser);
	//회원 수정 조회
	public NormalUser getNormalInfoById(String userEmail);
	//회원 수정
	public int modifyNormalUser(NormalUser normalUser); 
}
