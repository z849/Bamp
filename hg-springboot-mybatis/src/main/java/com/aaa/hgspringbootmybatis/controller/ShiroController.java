package com.aaa.hgspringbootmybatis.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ShiroController {
    @RequestMapping("/addUser")
    public String toaddUser(){
        System.out.println("--------");
        return "addUser";
    }
    @RequestMapping("/updateUser")
    public String toupdateUser(){
        return "updateUser";

    }
    @RequestMapping("/toLogin")
    public String toLongin(){
        return "Login";
    }
@RequestMapping("/login")
    public String login(String username, String password, Model model){
        System.out.println(username+password);
        //获取shrio的主体
        Subject subject= SecurityUtils.getSubject();
        //构建用户登录令牌
        UsernamePasswordToken token=new UsernamePasswordToken(username,password);
    try {
        subject.login(token);
    } catch (UnknownAccountException e) {
    model.addAttribute("message","用户名错误");
     return "login";
    }catch (IncorrectCredentialsException e){
        model.addAttribute("message","密码错误");
        return "login";
    }
    return "showUserLayui";
    }
}
