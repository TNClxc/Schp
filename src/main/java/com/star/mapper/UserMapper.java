package com.star.mapper;

import com.star.pojo.schp_User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    /**
     * 用户登陆
     * @param UserName
     * @param PassWord
     * @return
     */
    public schp_User login(@Param("userName")String UserName, @Param("passWord")String PassWord);

    /**
     * 用户注册
     * @param
     * @param
     * @return hao
     * */
    public int Register(@Param("realName")String realName,@Param("userName")String UserName, @Param("passWord")String PassWord,@Param("sex")int sex,@Param("usePhone")String usePhone);



}
