package com.detective.mark1.util;

import java.util.List;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import com.detective.mark1.entity.User;
import com.detective.mark1.service.PermissionService;
import com.detective.mark1.service.Permissions2UsersService;
import com.detective.mark1.service.UserService;

/**
 * @author 石天楠
 * @since 2018/5/4
 * <p>
 * 实现自己的Realm继承与Realm的子类AuthorizingRealm
 * 重写当中的两个方法doGetAuthenticationInfo(认证)
 * doGetAuthorizationInfo(授权)
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Autowired
    private Permissions2UsersService permissions2UsersService;

    @Autowired
    private PermissionService permissionService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 通过凭证拿到登录的用户名
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        // 通过用户名查询权限
        User user = userService.getUserByUsername(username);
        List<Long> permIds = permissions2UsersService.getPermissionIds(user.getId());
        List<String> perms = permissionService.getPermissions(permIds);
        // 给用户添加权限
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(perms);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 获取登录者的账户名
        String username = (String) token.getPrincipal();
        // 查询改账户是否存在
        User user = userService.getUserByUsername(username);
        if (user == null) {
            throw new UnknownAccountException("该账号不存在");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(),getName());
        return info;
    }
}
