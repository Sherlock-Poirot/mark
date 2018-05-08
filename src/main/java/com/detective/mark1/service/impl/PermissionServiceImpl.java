package com.detective.mark1.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.detective.mark1.mapper.PermissionMapper;
import com.detective.mark1.service.PermissionService;

/**
 * @author 石天楠
 * @since 2018/5/4
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<String> getPermissions(List<Long> permIds) {
        return permissionMapper.getPermissions(permIds);
    }
}
