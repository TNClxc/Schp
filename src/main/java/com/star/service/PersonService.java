package com.star.service;

import com.star.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PersonService {
    /**
     * 查询人员的详细信息
     * @param id
     * @return hao
     */
    public List<User> getPersonage(@Param("id") int id);

    /**
     * 删除人员信息
     * @param id
     * @return hao
     */
    public int delPerson(@Param("id")int id);

    /**
     *人员信息修改
     * @param upUser
     * @return hao
     */
    public int upPerson(@Param("upUser")User upUser);
}
