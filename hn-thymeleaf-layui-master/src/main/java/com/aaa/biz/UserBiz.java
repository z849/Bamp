package com.aaa.biz;

import com.aaa.entity.MyUserInfo;
import com.aaa.entity.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Author: 陈建
 * @Date: 2020/5/22 0022 15:47
 * @Version 1.0
 * 用户相关的业务方法
 */
public interface UserBiz {

    PageInfo<User> selectAllUser(int page, int limit);
    User selectUserByUsername(String username);
    User selectUserByLoginame(String loginame);
    int insertSelective(User record);
    int delUserByID(List<String> ids);
    int updateByPrimaryKeySelective(User record);
    int resetPassword(User record);

    List<User> searchUserById(int userId);
}
