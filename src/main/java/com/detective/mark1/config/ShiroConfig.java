package com.detective.mark1.config;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.Filter;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.detective.mark1.util.MyCredentialsMatcher;
import com.detective.mark1.util.MyRealm;

/**
 * @author 石天楠
 * @since 2018/5/4
 * shiro的配置类,配置各种bean
 * 当中配置shiroFilter(url过滤器)相当于MVC中的DispatcherServlet
 * MyRealm自定义的Realm
 * securityManager  权限管理，这个类组合了登陆，登出，权限，session的处理，
 * 是个比较重要的类。这个bean是所有的安全相关的所有操作都交由securityManager来处理
 */
@Configuration
public class ShiroConfig {

//    @Bean("hashedCredentialsMatcher")
//    public HashedCredentialsMatcher hashedCredentialsMatcher(){
//        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
//        // 指定加密方式MD5
//        credentialsMatcher.setHashAlgorithmName("MD5");
//        // 加密次数
//        credentialsMatcher.setHashIterations(1024);
//        credentialsMatcher.setStoredCredentialsHexEncoded(true);
//        return credentialsMatcher;
//    }

    @Bean("ShiroFilter")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 将securityManager设置到ShiroFilter的bean中
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //以下是过滤链，按顺序过滤，所以/**需要放最后
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        // TODO 等待权限的完善
        shiroFilterFactoryBean.setLoginUrl("/login.html");
        shiroFilterFactoryBean.setSuccessUrl("/index.html");
//        filterChainDefinitionMap.put("/test/**","authc,perms[perm1]");
//        filterChainDefinitionMap.put("/login.html","anon");
//        filterChainDefinitionMap.put("/door/login","anon");
        filterChainDefinitionMap.put("/**","anon");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myRealm());
        return securityManager;
    }

    @Bean
    public MyRealm myRealm() {
        MyRealm myRealm = new MyRealm();
        myRealm.setCredentialsMatcher(new MyCredentialsMatcher());
        return myRealm;
    }

}
