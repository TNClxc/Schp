package com.star.service;

import com.star.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    //登录
    public User login(String UserName, String PassWord);

    //用户注册
    public int Register(User user);

    //查询登录名是否重复
    public int repeat (String userName);

    //修改密码
    public int upPwd(String passWord,int id);

    //修改时查询密码是否正确
    public User checkPwd(@Param("userName")String userName,@Param("passWord")String passWord);

    //查询用户
    public List<User> userList(int currentPage,int totalCount);

    //查询记录数
    public int getCount();

    //模糊查询人员信息
    public List<User> getUserList(String realName);
}
