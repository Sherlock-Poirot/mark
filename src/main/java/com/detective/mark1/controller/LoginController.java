package com.detective.mark1.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.detective.mark1.dto.LoginDTO;
import com.detective.mark1.entity.User;
import com.detective.mark1.service.UserService;

/**
 * @author 石天楠
 * @since 2018/5/4
 */
@RestController
@RequestMapping("door")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("login")
    public String login(@RequestBody LoginDTO dto){
        User user = userService.getUserByUsername(dto.getUsername());
        if(user == null){
            return "用户不存在";
        }
        if(!dto.getPassword().equals(user.getPassword())){
            return "密码不正确";
        }
        UsernamePasswordToken token = new UsernamePasswordToken(dto.getUsername(),dto.getPassword());
        SecurityUtils.getSubject().login(token);
        return "登录成功";
    }

}
