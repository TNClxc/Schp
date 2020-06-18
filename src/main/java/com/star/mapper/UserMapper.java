package com.star.mapper;

import com.star.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    /**
     * 用户登陆
     * @param UserName
     * @param PassWord
     * @return
     */
    public User login(@Param("userName")String UserName, @Param("passWord")String PassWord);

    /**
     * 用户注册
     * @param
     * @param
     * @return hao
     * */
    public int Register(@Param("user") User user);

    /**
     * 查询登录名是否重复
     * @param
     * @param
     * @return hao
     * */
    public int repeat (@Param("userName")String userName);



}
