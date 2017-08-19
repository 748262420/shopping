package com.lanou.mapper;

import com.lanou.bean.TbUser;

public interface TbUserMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(TbUser record);

	int insertSelective(TbUser record);

	TbUser selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(TbUser record);

	int updateByPrimaryKey(TbUser record);

	TbUser selectOne(TbUser user);

	TbUser selectId(TbUser user);
}