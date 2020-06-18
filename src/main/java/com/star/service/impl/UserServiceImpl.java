package com.star.service.impl;

import com.star.mapper.UserMapper;
import com.star.pojo.schp_User;
import com.star.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public schp_User login(String UserName, String PassWord) {
        return userMapper.login(UserName,PassWord);
    }

    @Override
    public int Register(String realName, String UserName, String PassWord, int sex, String usePhone) {
        return userMapper.Register(realName, UserName, PassWord, sex, usePhone);
    }
}
