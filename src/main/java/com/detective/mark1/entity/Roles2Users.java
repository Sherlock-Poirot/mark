package com.detective.mark1.entity;

import java.util.Date;
import lombok.Data;

@Data
public class Roles2Users {
    private Long id;

    private Date insertTime;

    private Date updateTime;

    private Boolean delFlag;

    private Long roleId;

    private Long userId;
}