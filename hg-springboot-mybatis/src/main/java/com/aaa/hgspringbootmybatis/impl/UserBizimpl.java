package com.aaa.hgspringbootmybatis.impl;

import com.aaa.hgspringbootmybatis.dao.UserInfoDao;
import com.aaa.hgspringbootmybatis.entity.UserInfo;
import com.aaa.hgspringbootmybatis.service.UserBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBizimpl implements UserBiz {
    @Autowired
    private UserInfoDao userInfoDao;
    @Override
    public UserInfo findUserByName(String name) {
        UserInfo userInfo=userInfoDao.findUserByName(name);
        return userInfo;
    }
    @Override
    public List<UserInfo> selectAllUser() {
        return userInfoDao.selectAllUser();
    }
}
