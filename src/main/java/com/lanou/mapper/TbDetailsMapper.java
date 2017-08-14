package com.lanou.mapper;

import com.lanou.bean.TbDetails;

public interface TbDetailsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbDetails record);

    int insertSelective(TbDetails record);

    TbDetails selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbDetails record);

    int updateByPrimaryKey(TbDetails record);
}