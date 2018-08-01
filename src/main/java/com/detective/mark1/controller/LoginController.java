package com.detective.mark1.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.detective.mark1.dto.LoginDTO;
import com.detective.mark1.entity.User;
import com.detective.mark1.service.UserService;
import lombok.Data;

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
    public Temp login(@RequestBody LoginDTO dto){
        Temp temp = new Temp();
        User user = userService.getUserByUsername(dto.getUsername());
        if(user == null){
            temp.setMessage("用户不存在");
            return temp;
        }
        ByteSource credentialsSalt = ByteSource.Util.bytes(user.getUsername());
        String dtoPassowrd = new SimpleHash("MD5", dto.getPassword(), credentialsSalt, 1024).toHex();
//        if(!dtoPassowrd.equals(user.getPassword())){
//            temp.setMessage("密码不正确");
//            return temp;
//        }
        UsernamePasswordToken token = new UsernamePasswordToken(dto.getUsername(),dto.getPassword());
        SecurityUtils.getSubject().login(token);
        temp.setMessage("登录成功");
        return temp;
    }
    @Data
    class Temp{
        private String message;
    }

    @GetMapping("/register")
    void registerUser(){
        String username = "test2222";
        String password = "123456";
        userService.registerUser(username,password);
    }
}
