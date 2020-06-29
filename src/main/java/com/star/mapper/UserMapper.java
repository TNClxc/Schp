package com.star.mapper;

import com.star.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    /**
     * 用户登陆
     * @param UserName
     * @param PassWord
     * @return lai
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

    /**
     * 修改密码
     * @param passWord
     * @param id
     * @return hao
     */
    public int upPwd(@Param("passWord")String passWord,@Param("id")int id);

    /**
     * 修改密码时查询密码是否正确
     * @param
     * @param
     * @return hao
     * */
    public User checkPwd(@Param("userName")String userName,@Param("passWord")String passWord);

    /**
     * 查询人员
     * @param currentPage
     * @param pageSize
     * @return hao
     */
    public List<User> userList(@Param("currentPage") int currentPage, @Param("pageSize") int pageSize);

    /**
     * 查询记录数
     * @return hao
     */
    public int getCount();

    /**
     * 根据姓名模糊查询人员信息
     * @param realName
     * @return hao
     */
    public List<User> getUserList(@Param("realName")String realName);





}
