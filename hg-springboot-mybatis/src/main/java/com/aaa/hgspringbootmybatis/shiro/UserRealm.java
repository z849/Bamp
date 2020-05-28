package com.aaa.hgspringbootmybatis.shiro;

import com.aaa.hgspringbootmybatis.entity.UserInfo;
import com.aaa.hgspringbootmybatis.service.UserBiz;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserBiz userBiz;
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("授权开始了");
        return null;
    }
    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("认证开始了");
        //开始校验用户名和密码
        UsernamePasswordToken usernamePasswordToken=(UsernamePasswordToken) token;
        //取出令牌
        UserInfo userInfo=userBiz.findUserByName(usernamePasswordToken.getUsername());
        //登录验证分两个步骤：一：查询用户是否存在
        if(userInfo==null){
            return null;
        }
        //二：查询密码是否正确

        String sqlpassword=userInfo.getPassword();
        SimpleAuthenticationInfo simpleAuthenticationInfo=new SimpleAuthenticationInfo("",sqlpassword,"");
        return simpleAuthenticationInfo;

    }
}
