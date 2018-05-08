package com.detective.mark1.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.detective.mark1.entity.Permission;

public interface PermissionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

    List<String> getPermissions(@Param("ids") List<Long> permIds);
}