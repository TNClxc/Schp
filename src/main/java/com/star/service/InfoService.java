package com.star.service;

import com.star.pojo.Info;

import java.util.List;

public interface InfoService {
    /**
     * 分页 传入当前页数 和 页面容量
     * @param currentPage
     * @param pageSize
     * @return
     */
    public List<Info> getInfoList(int currentPage,int tatalCount);


    /**
     * 查询记录数
     * @return
     */
    public int getTotalCount();
}
