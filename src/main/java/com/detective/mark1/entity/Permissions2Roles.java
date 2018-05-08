package com.detective.mark1.entity;

import java.util.Date;
import lombok.Data;

@Data
public class Permissions2Roles {
    private Long id;

    private Date insertTime;

    private Date updateTime;

    private Boolean delFlag;

    private Long permissionId;

    private Long roleId;
}