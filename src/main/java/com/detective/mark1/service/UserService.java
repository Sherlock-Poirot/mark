package com.detective.mark1.service;

import com.detective.mark1.entity.User;

/**
 * @author 石天楠
 * @since 2018/5/4
 */
public interface UserService {
    User getUserByUsername(String username);

    void registerUser(String username,String password);
}
