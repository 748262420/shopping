package com.lanou.mapper;

import com.lanou.bean.TbShopdata;

public interface TbShopdataMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbShopdata record);

    int insertSelective(TbShopdata record);

    TbShopdata selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbShopdata record);

    int updateByPrimaryKey(TbShopdata record);
}