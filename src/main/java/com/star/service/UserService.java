package com.star.service;

import com.star.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserService {
    public User login(String UserName, String PassWord);
    /**
     * 用户注册
     * */
    public int Register(User user);
    //查询登录名是否重复
    public int repeat (@Param("userName")String userName);
}
