package com.aaa.hgspringbootmybatis.controller;

import com.aaa.hgspringbootmybatis.dao.UserInfoDao;
import com.aaa.hgspringbootmybatis.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.*;

 @Controller
public class TestController {
    @Autowired
    private UserInfoDao userInfoDao;



 @RequestMapping("/saveUser")
    @ResponseBody
    public Object saveUser(){
        System.out.println("=================");
        UserInfo userinfo= new UserInfo();
        userinfo.setUsername("小青");
        userinfo.setUserid(13);
        userinfo.setPassword("135");
        userInfoDao.saveUserInfo(userinfo);
        Map map = new HashMap<String,Object>();
        map.put("code",0);
        map.put("message","保存成功");
        return map;

    }
}
/*
@Controller
public class TestController {
    @Autowired
    private UserInfoDao userInfoDao;

    @RequestMapping("/saveUser")
    @ResponseBody
    public void saveUser() {
        System.out.println("==========*****==------");
        UserInfo userinfo = new UserInfo();
        userinfo.setName("xiaohuang");
        userinfo.setAge(18);
        userInfoDao.saveUserInfo(userinfo);

    }
}
*/

