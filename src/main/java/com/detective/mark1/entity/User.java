package com.detective.mark1.entity;

import java.util.Date;
import lombok.Data;

@Data
public class User {
    private Long id;

    private Date insertTime;

    private Date updateTime;

    private Boolean delFlag;

    private String username;

    private String password;

    private String nickname;
}