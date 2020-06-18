package com.star.service;

import com.star.pojo.schp_User;
import org.apache.ibatis.annotations.Param;

public interface UserService {
    public schp_User login(String UserName, String PassWord);
    /**
     * 用户注册
     * */
    public int Register(String realName,String UserName,String PassWord,int sex,String usePhone);
}
