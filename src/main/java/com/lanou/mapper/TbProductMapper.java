package com.lanou.mapper;

import com.lanou.bean.TbProduct;

public interface TbProductMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(TbProduct record);

	int insertSelective(TbProduct record);

	TbProduct selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(TbProduct record);

	int updateByPrimaryKey(TbProduct record);

	TbProduct selectOne(TbProduct product);
}