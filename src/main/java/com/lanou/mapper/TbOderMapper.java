package com.lanou.mapper;

import com.lanou.bean.TbOder;

public interface TbOderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbOder record);

    int insertSelective(TbOder record);

    TbOder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbOder record);

    int updateByPrimaryKey(TbOder record);
}