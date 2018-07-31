package com.detective.mark1.controller;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.detective.mark1.entity.User;
import com.detective.mark1.mapper.UserMapper;
import lombok.extern.log4j.Log4j2;

/**
 * @author 石天楠
 * @since 2018/5/3
 */
@Log4j2
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private UserMapper mapper;

    @GetMapping("hello")
    public String test(){
        return "hello spring boot";
    }

    @GetMapping("hello/get")
    public User get(){
        return mapper.selectByPrimaryKey(1L);
    }

}
