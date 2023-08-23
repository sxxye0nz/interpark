package com.green.nowon.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.green.nowon.dto.MyRoleSaveDTO;

@Mapper
public interface MyRoleMapper {

	void save(MyRoleSaveDTO dto);

}
