package com.detective.mark1.service;

import java.util.List; /**
 * @author 石天楠
 * @since 2018/5/4
 */
public interface PermissionService {

    List<String> getPermissions(List<Long> permIds);
}
