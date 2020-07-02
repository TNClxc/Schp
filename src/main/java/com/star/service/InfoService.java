package com.star.service;

import com.star.pojo.Info;
import com.star.pojo.User;
import com.star.pojo.InfoType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InfoService {
    /**
     * 分页 传入当前页数 和 页面容量
     * @param currentPage
     * @param totalCount
     * @return lai
     */
    public List<Info> getInfoList(int currentPage,int totalCount);


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
    public List<User> getPersonage( int id);

    /**
     * 删除人员信息
     * @param id
     * @return hao
     */
    public int delPerson(int id);

    /**
     *人员信息修改
     * @param upUser
     * @return hao
     */
    public int upPerson(@Param("upUser")User upUser);
     /*删除发布职位信息
     * @param infoId
     * @return lai
     */
    public int delInfo(int infoId);

    /**
     * 查询文章分类
     * @return lai
     */
    public List<InfoType> getInfoTypeList();

    /**
     * 新增发布信息
     * @param info
     * @return lai
     */
    public int infoAdd(Info info);

    /**
     * 修改发布信息
     * @param info
     * @return lai
     */
    public int upInfo(@Param("info") Info info);

    /**
     * 按ID查询info信息
     * @param id
     * @return
     */
    public Info getInfoById(int id);

}
