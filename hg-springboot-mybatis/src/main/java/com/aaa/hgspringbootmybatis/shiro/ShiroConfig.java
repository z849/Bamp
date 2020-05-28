package com.aaa.hgspringbootmybatis.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

//配置类
@Configuration
public class ShiroConfig {
    /**
     * realm
     */
    @Bean
    public UserRealm personRealm(){
        return new UserRealm();
    }
    /**
     *securityManager
     */
    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager()
    {
        DefaultWebSecurityManager defaultWebSecurityManager=new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(personRealm());
        return defaultWebSecurityManager;
    }
    /**
     * shrioFilterFactorybean
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(){
        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager());
        /**
         * 认证过滤器的分类
         * anon:无需认证
         * authc:必须认证才能到达
         * user:使用rememberme的时候才用
         * perms：访问的资源需要某个权限才能到达
         * roles:访问的资源需要某个角色才能到达
         */
        Map<String,String> map=new LinkedHashMap<>();
        map.put("/login","anon");
        //过滤所有请求
        map.put("/*","authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        //修改登录页面，所有没认证的请求要先去认证
        shiroFilterFactoryBean.setLoginUrl("/toLogin");
        return shiroFilterFactoryBean;

    }
}
