package com.star.mapper;

import com.star.pojo.Info;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InfoMapper {

    /**
     * 分页 传入当前页数 和 页面容量
     * @param currentPage
     * @param pageSize
     * @return
     */
    public List<Info> getInfoList(@Param("currentPage") int currentPage, @Param("pageSize") int pageSize);


    /**
     * 查询记录数
     * @return
     */
    public int getTotalCount();

}
