package com.detective.mark1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.detective.mark1.entity.User;
import com.detective.mark1.mapper.UserMapper;
import com.detective.mark1.service.UserService;

/**
 * @author 石天楠
 * @since 2018/5/4
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }
}
