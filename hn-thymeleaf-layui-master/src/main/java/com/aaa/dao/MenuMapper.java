package com.aaa.dao;

import com.aaa.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MenuMapper {
    int deleteByPrimaryKey(Integer menuId);

    int deleteById(@Param("ids") List<String> ids);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer menuId);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    List<Menu> selectAllMenu();

    List<Menu>  selectAllMenuByName(String loginName);
}