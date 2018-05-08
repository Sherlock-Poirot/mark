package com.detective.mark1.mapper;

import java.util.List;
import com.detective.mark1.entity.Permissions2Users;

public interface Permissions2UsersMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Permissions2Users record);

    int insertSelective(Permissions2Users record);

    Permissions2Users selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Permissions2Users record);

    int updateByPrimaryKey(Permissions2Users record);

    List<Long> getPermIdsByUserId(Long userId);
}