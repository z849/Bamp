package com.aaa.controller;

import com.aaa.biz.DeptBiz;
import com.aaa.entity.Dept;
import com.aaa.entity.LayUiTable;
import com.aaa.entity.Role;
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
 * @Date: 2020/5/29 0029 16:27
 * @Version 1.0
 */
@Controller
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptBiz deptBizImpl;
    @RequestMapping("/toShowDept")
    public String  toShowDept(){
        return "dept/showDept";
    }

    @RequestMapping("/showDept")
    @ResponseBody
    public LayUiTable showDept() {
        //开始查询
        List<Dept> deptList = deptBizImpl.selectAllDept();
        LayUiTable layUiTable = new LayUiTable();
        layUiTable.setCode(0);
        layUiTable.setMsg("返回消息");
        layUiTable.setData(deptList);
        return layUiTable;
    }
    @RequestMapping("/saveDept")
    @ResponseBody
    public Object saveRole(Dept dept){
        int i=deptBizImpl.insertSelective(dept);
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
    @RequestMapping("/editDept")
    @ResponseBody
    public Object editDept(Dept dept){
        int i = deptBizImpl.updateByPrimaryKeySelective(dept);
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
    @RequestMapping("/delDept")
    @ResponseBody
    public Object delDept( @RequestParam(value = "ids") String  ids){
        //将json字符串转换成list对象
        List<String> list= (List<String>) JSON.parse(ids);
        int i = deptBizImpl.delDeptByID(list);
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

    //搜索
    @RequestMapping("/searchDeptById")
    @ResponseBody
    public LayUiTable searchDeptById(int deptId){

        System.out.println(deptId);
        List<Dept> list = deptBizImpl.searchDeptById(deptId);
        System.out.println(list);
        LayUiTable layUiTable =new LayUiTable();
        layUiTable.setCode(0);
        layUiTable.setMsg("返回消息");
        //设置分页之后的返回值
        layUiTable.setCount(1);
        layUiTable.setData(list);
        return layUiTable;
    }

}
