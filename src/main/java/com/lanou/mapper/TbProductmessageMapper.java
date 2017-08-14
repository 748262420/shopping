package com.lanou.mapper;

import com.lanou.bean.TbProductmessage;

public interface TbProductmessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbProductmessage record);

    int insertSelective(TbProductmessage record);

    TbProductmessage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbProductmessage record);

    int updateByPrimaryKey(TbProductmessage record);
}