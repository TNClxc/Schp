package com.star.mapper;

import com.star.pojo.Info;

import com.star.pojo.User;

import com.star.pojo.InfoType;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InfoMapper {

    /**
     * 分页 传入当前页数 和 页面容量
     *
     * @param currentPage
     * @param pageSize
     * @return lai
     */
    public List<Info> getInfoList(@Param("currentPage") int currentPage, @Param("pageSize") int pageSize);


    /**
     * 查询记录数
     *
     * @return lai
     */
    public int getTotalCount();

    /**
     * 查询人员的详细信息
     *
     * @param id
     * @return hao
     */
    public List<User> getPersonage(@Param("id") int id);

    /**
     * 删除人员信息
     *
     * @param id
     * @return hao
     */
    public int delPerson(@Param("id") int id);

    /**
     * 人员信息修改
     *
     * @param upUser
     * @return hao
     */
    public int upPerson(@Param("upUser") User upUser);

    /**
     * 删除发布职位信息
     * @param infoId
     * @return lai
     */
    public int delInfo(@Param("id") int infoId);

    /**
     * 新增发布信息
     *
     * @param info
     * @return lai
     */
    public int infoAdd(@Param("info") Info info);

    /**
     * 查询文章分类
     *
     * @return lai
     */
    public List<InfoType> getInfoTypeList();

    /**
     * 修改发布信息
     *
     * @param info
     * @return lai
     */
    public int upInfo(@Param("info") Info info);


    /**
     * 按ID查询info信息
     * @param id
     * @return
     */
    public Info getInfoById(@Param("id")int id);

}
