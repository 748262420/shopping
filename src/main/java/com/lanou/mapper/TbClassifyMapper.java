package com.lanou.mapper;

import java.util.List;

import com.lanou.bean.TbClassify;

public interface TbClassifyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbClassify record);

    int insertSelective(TbClassify record);

    TbClassify selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbClassify record);

    int updateByPrimaryKey(TbClassify record);
    
    List<TbClassify> findClassInformation();
}