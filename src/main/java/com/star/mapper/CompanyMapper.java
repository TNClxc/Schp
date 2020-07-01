package com.star.mapper;

import com.star.pojo.Company;
import com.star.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CompanyMapper {

    /**
     * 查询全部企业 传入起始位置和页面容量
     * @param currentPage
     * @param pageSize
     * @return hao
     */
    public List<Company> getCompanyList(@Param("currentPage")int currentPage,@Param("pageSize")int pageSize);


    /**
     * 总记录数
     * @return hao
     */
    public int getTotalCount();

    /**
     * 删除企业信息
     * @param id
     * @return
     */
    public int delCompany(@Param("id")int id);



}
