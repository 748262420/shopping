package com.lanou.mapper;

import org.springframework.stereotype.Repository;

import com.lanou.bean.Users;

@Repository
public interface UsersMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Users record);

	int insertSelective(Users record);

	Users selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Users record);

	int updateByPrimaryKey(Users record);

	Users selectOne(Users user);
}