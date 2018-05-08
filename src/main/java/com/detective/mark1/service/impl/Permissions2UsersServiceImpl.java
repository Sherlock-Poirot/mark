package com.detective.mark1.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.detective.mark1.mapper.Permissions2UsersMapper;
import com.detective.mark1.service.Permissions2UsersService;

/**
 * @author 石天楠
 * @since 2018/5/4
 */
@Service
public class Permissions2UsersServiceImpl implements Permissions2UsersService {

    @Autowired
    private Permissions2UsersMapper permissions2UsersMapper;

    @Override
    public List<Long> getPermissionIds(Long userId) {
        return permissions2UsersMapper.getPermIdsByUserId(userId);
    }
}
