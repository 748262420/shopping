package com.lanou.mapper;

import com.lanou.bean.TbUserproduct;

public interface TbUserproductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbUserproduct record);

    int insertSelective(TbUserproduct record);

    TbUserproduct selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbUserproduct record);

    int updateByPrimaryKey(TbUserproduct record);
}