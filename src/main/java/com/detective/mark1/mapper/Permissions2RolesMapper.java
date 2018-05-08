package com.detective.mark1.mapper;

import com.detective.mark1.entity.Permissions2Roles;

public interface Permissions2RolesMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Permissions2Roles record);

    int insertSelective(Permissions2Roles record);

    Permissions2Roles selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Permissions2Roles record);

    int updateByPrimaryKey(Permissions2Roles record);
}