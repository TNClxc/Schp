package com.star.service.impl;

import com.star.mapper.UserMapper;
import com.star.pojo.User;
import com.star.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
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


}
