package com.star.service.impl;

import com.star.mapper.UserMapper;
import com.star.pojo.User;
import com.star.service.UserService;
import com.star.utils.Constants;
import com.star.utils.Pageutil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User login(String UserName, String PassWord) {
        return userMapper.login(UserName,PassWord);
    }

    @Override
    public int Register(User user) {
        return userMapper.Register(user);
    }

    @Override
    public int repeat(String userName) {
        return userMapper.repeat(userName);
    }

    @Override
    public int upPwd(String passWord, int id) {
        return userMapper.upPwd(passWord,id);
    }

    @Override
    public User checkPwd(String userName,String passWord) {
        return userMapper.checkPwd(passWord,userName);
    }

    @Override
    public List<User> userList(int currentPage,int totalCount) {
        return userMapper.userList(currentPage,totalCount);
    }

    @Override
    public int getCount() {
        return userMapper.getCount();
    }

    @Override
    public List<User> getUserList(int currentPage, int totalCount, String realName) {
        return userMapper.getUserList(currentPage,totalCount,realName);
    }


}
