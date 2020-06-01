package com.aaa.controller;

import com.aaa.biz.MenuBiz;
import com.aaa.entity.LayUiTable;
import com.aaa.entity.LayUiTree;
import com.aaa.entity.Menu;
import com.aaa.util.MyConstants;
import com.alibaba.fastjson.JSON;
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
 * @Date: 2020/5/28 0028 6:59
 * @Version 1.0
 */
@Controller
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuBiz menuBiz;

    @RequestMapping("/toShowMenu")
    public String toShowMenu() {
        return "menu/showMenu";
    }

    @RequestMapping("/selectAllMenu")
    @ResponseBody
    public LayUiTable selectAllMenu(){
        LayUiTable layUiTable= menuBiz.selectAllMenu();
        return layUiTable;
    }

    @RequestMapping("/toSaveMenu")
    @ResponseBody
    public Object saveMenu(Menu record){
        int i=menuBiz.insertSelective(record);
        Map map= new HashMap<>();
        if(i>0){
            map.put("code", MyConstants.successCode);
            map.put("message",MyConstants.saveSuccessMsg);
        }else {
            map.put("code",MyConstants.failCode);
            map.put("message",MyConstants.saveFailMsg);
        }
        return map;
    }

    @RequestMapping("/toEditMenu")
    @ResponseBody
    public Object editMenu(Menu record){
        int i=menuBiz.updateByPrimaryKeySelective(record);
        Map map= new HashMap<>();
        if(i>0){
            map.put("code", MyConstants.successCode);
            map.put("message",MyConstants.editSuccessMsg);
        }else {
            map.put("code",MyConstants.failCode);
            map.put("message",MyConstants.editFailMsg);
        }
        return map;
    }

    @RequestMapping("/toDelSelectMenu")
    @ResponseBody
    public Object delSelectMenu(@RequestParam(value = "ids") String  ids){
        //将json字符串转换成list对象
        List<String> list= (List<String>) JSON.parse(ids);
        int i =menuBiz.deleteById(list);
        Map map= new HashMap<>();
        if(i>0){
            map.put("code", MyConstants.successCode);
            map.put("message",MyConstants.delSuccessMsg);
        }else {
            map.put("code",MyConstants.failCode);
            map.put("message",MyConstants.delFailMsg);
        }
        return map;
    }

    @RequestMapping("/toDelMenu")
    @ResponseBody
    public Object delMenu(@RequestParam(value="id") Integer menuId){
        int i =menuBiz.deleteByPrimaryKey(menuId);
        Map map= new HashMap<>();
        if(i>0){
            map.put("code", MyConstants.successCode);
            map.put("message",MyConstants.delSuccessMsg);
        }else {
            map.put("code",MyConstants.failCode);
            map.put("message",MyConstants.delFailMsg);
        }
        return map;
    }



}
