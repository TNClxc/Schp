package com.star.service;

import com.star.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    public User login(String UserName, String PassWord);

    public int Register(User user);

    public int repeat (String userName);

    public int upPwd(String passWord,int id);

    public User checkPwd(@Param("userName")String userName,@Param("passWord")String passWord);
    public List<User> userList(int currentPage,int totalCount);
    public int getCount();

    public List<User> getUserList(int currentPage,int totalCount,String realName);
}
