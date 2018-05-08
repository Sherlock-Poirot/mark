package com.detective.mark1.entity;

import java.util.Date;
import lombok.Data;

@Data
public class Permission {
    private Long id;

    private Date insetTime;

    private Date updateTime;

    private Boolean delFlag;

    private String name;
}