package com.aaa.hgspringbootmybatis.service;

import com.aaa.hgspringbootmybatis.entity.UserInfo;

import java.util.List;

public interface UserBiz {
    UserInfo findUserByName(String name);
    List<UserInfo> selectAllUser();
}
