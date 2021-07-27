package com.devcdper.user_admin.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommonMapper {
	public String getNewCode(String tableName);
	
	public String getNewCode2(String tableName);
}
