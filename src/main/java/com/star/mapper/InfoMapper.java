package com.star.mapper;

import com.star.pojo.Info;
import com.star.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InfoMapper {

    /**
     * 分页 传入当前页数 和 页面容量
     * @param currentPage
     * @param pageSize
     * @return lai
     */
    public List<Info> getInfoList(@Param("currentPage") int currentPage, @Param("pageSize") int pageSize);


    /**
     * 查询记录数
     * @return lai
     */
    public int getTotalCount();

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
