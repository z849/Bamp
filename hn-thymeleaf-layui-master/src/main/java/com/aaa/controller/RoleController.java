package com.aaa.controller;

import com.aaa.biz.RoleBiz;
import com.aaa.biz.impl.RoleBizImpl;
import com.aaa.entity.LayUiTable;
import com.aaa.entity.Role;
import com.aaa.entity.User;
import com.aaa.util.MyConstants;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: 陈建
 * @Date: 2020/5/29 0029 16:27
 * @Version 1.0
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleBiz roleBizImpl;
    @RequestMapping("/toShowRole")
    public String  toShowRole(){
        return "role/showRole";
    }
    @RequestMapping("/searchRoleById")
    @ResponseBody
    public LayUiTable searchRoleById(int roleId){

        System.out.println(roleId);
        List<Role> list = roleBizImpl.searchRoleById(roleId);
        System.out.println(list);
        LayUiTable layUiTable =new LayUiTable();
        layUiTable.setCode(0);
        layUiTable.setMsg("返回消息");
        //设置分页之后的返回值
        layUiTable.setCount(1);
        layUiTable.setData(list);
        return layUiTable;
    }

    @RequestMapping("/showRole")
    @ResponseBody
    public LayUiTable showRoleLayui() {
        //开始查询
        List<Role> roleList = roleBizImpl.selectAllRole();
        LayUiTable layUiTable = new LayUiTable();
        layUiTable.setCode(0);
        layUiTable.setMsg("返回消息");
        layUiTable.setData(roleList);
        return layUiTable;
    }
    @RequestMapping("/saveRole")
    @ResponseBody
    public Object saveRole(Role role){
        int i=roleBizImpl.insertSelective(role);
        Map map=new HashMap<>();
        if (i>0){
            map.put("code", MyConstants.successCode);
            map.put("message",MyConstants.saveSuccessMsg);
        }else{
            map.put("code",MyConstants.failCode);
            map.put("message",MyConstants.saveFailMsg);
        }
        return map;
    }
    @RequestMapping("/editRole")
    @ResponseBody
    public Object editRole(Role role){
        int i = roleBizImpl.updateByPrimaryKeySelective(role);
        Map map= new HashMap<>();
        if(i>0){
            map.put("code",MyConstants.successCode);
            map.put("message",MyConstants.editSuccessMsg);
        }else {
            map.put("code",MyConstants.failCode);
            map.put("message",MyConstants.editFailMsg);
        }
        return map;
    }
    @RequestMapping("/delRole")
    @ResponseBody
    public Object delUser( @RequestParam(value = "ids") String  ids){
        //将json字符串转换成list对象
        List<String> list= (List<String>) JSON.parse(ids);
        int i = roleBizImpl.delRoleByID(list);
        Map map= new HashMap<>();
        if(i>0){
            map.put("code",MyConstants.successCode);
            map.put("message",MyConstants.delSuccessMsg);
        }else {
            map.put("code",MyConstants.failCode);
            map.put("message",MyConstants.delFailMsg);
        }
        return map;
    }

}
