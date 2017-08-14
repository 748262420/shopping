package com.lanou.mapper;

import com.lanou.bean.TbShoppingcar;

public interface TbShoppingcarMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbShoppingcar record);

    int insertSelective(TbShoppingcar record);

    TbShoppingcar selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbShoppingcar record);

    int updateByPrimaryKey(TbShoppingcar record);
}