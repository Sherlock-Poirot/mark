package com.detective.mark1.service.impl;

import java.util.Date;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
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

    @Override
    public void registerUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        ByteSource credentialsSalt = ByteSource.Util.bytes(user.getUsername());
        password = new SimpleHash("MD5", password, credentialsSalt, 1024).toHex();
        user.setPassword(password);
        user.setInsertTime(new Date());
        user.setDelFlag(false);
        user.setNickname("test2222");
        userMapper.insert(user);
    }
}
