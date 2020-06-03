package com.aaa.biz;

import com.aaa.entity.LayUiTable;
import com.aaa.entity.LayUiTree;
import com.aaa.entity.LayUiTree1;
import com.aaa.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuBiz {
    int deleteByPrimaryKey(@Param("id")Integer menuId);

    int deleteById(@Param("ids") List<String> ids);

    int insert(Menu record);

    int insertSelective(Menu record);
    Menu selectByPrimaryKey(Integer menuId);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    List<LayUiTree>  selectAllMenu();
    //根据用户登录名查询对应的所有菜单
    List<LayUiTree>  selectAllMenuByName(String loginName);

    //List<LayUiTree> selectAllMenu(String loginName);
}