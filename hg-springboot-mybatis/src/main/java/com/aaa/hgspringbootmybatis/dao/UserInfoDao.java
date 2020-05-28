package com.aaa.hgspringbootmybatis.dao;

import com.aaa.hgspringbootmybatis.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface UserInfoDao {
    void saveUserInfo(UserInfo userinfo);
    void deleteUserInfoByname(String name);
    void updateUserInfo(UserInfo userinfo);
    UserInfo findUserByName(String name);
    List<UserInfo> selectAllUser();
}
