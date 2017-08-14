package com.lanou.mapper;

import com.lanou.bean.TbAdmin;

public interface TbAdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbAdmin record);

    int insertSelective(TbAdmin record);

    TbAdmin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbAdmin record);

    int updateByPrimaryKey(TbAdmin record);
}