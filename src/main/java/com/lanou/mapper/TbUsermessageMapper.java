package com.lanou.mapper;

import com.lanou.bean.TbUsermessage;

public interface TbUsermessageMapper {
	int deleteByPrimaryKey(Long id);

	int insert(TbUsermessage record);

	int insertSelective(TbUsermessage record);

	TbUsermessage selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(TbUsermessage record);

	int updateByPrimaryKey(TbUsermessage record);

	TbUsermessage selectone(Integer userId);
}