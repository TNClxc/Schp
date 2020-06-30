package com.star.service;

import com.star.pojo.Company;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CompanyService {

    /**
     * 查询全部企业 传入起始位置和页面容量
     * @param currentPage
     * @param pageSize
     * @return lai
     */
    public List<Company> getCompanyList(int currentPage, int pageSize);


    /**
     * 总记录数
     * @return lai
     */
    public int getTotalCount();
}
