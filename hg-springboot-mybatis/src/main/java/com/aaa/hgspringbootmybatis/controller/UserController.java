package com.aaa.hgspringbootmybatis.controller;


import com.aaa.hgspringbootmybatis.service.UserBiz;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.aaa.hgspringbootmybatis.entity.LayUITable;
import com.aaa.hgspringbootmybatis.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserBiz userbizImpl;
    @RequestMapping("/toShowUserpage")
    public String toShowUserpage(Model model) {
        List<UserInfo> userInfoList=userbizImpl.selectAllUser();
        model.addAttribute("userInfoList",userInfoList);

        return "user/showUser";
    }
    @RequestMapping("/toShowUserLayui")
    public String toShowUserLayui(Model model) {
        List<UserInfo> userInfoList=userbizImpl.selectAllUser();
        model.addAttribute("userInfoList",userInfoList);
        return "user/showUserLayui";
    }

    @RequestMapping("/showUserLayui")
    @ResponseBody
    public LayUITable showUserLayui(int page,int limit){
        //开始分页//
        PageHelper.startPage(page,limit);
        List<UserInfo> userInfoList =userbizImpl.selectAllUser();
        //结束分页//
        PageInfo<UserInfo> pageInfo = new PageInfo(userInfoList);
        LayUITable layUITable = new LayUITable();
        layUITable.setCode(0);
        layUITable.setMsg("返回消息");
        layUITable.setCount(pageInfo.getTotal());
        layUITable.setData(pageInfo.getList());
        return layUITable;
    }
}
