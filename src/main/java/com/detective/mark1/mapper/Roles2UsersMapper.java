package com.detective.mark1.mapper;

import com.detective.mark1.entity.Roles2Users;

public interface Roles2UsersMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Roles2Users record);

    int insertSelective(Roles2Users record);

    Roles2Users selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Roles2Users record);

    int updateByPrimaryKey(Roles2Users record);
}