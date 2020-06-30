package com.star.service.impl;

import com.star.mapper.CompanyMapper;
import com.star.pojo.Company;
import com.star.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyMapper companyMapper;

    /**
     * 查询全部企业 传入起始位置和页面容量
     *
     * @param currentPage
     * @param pageSize
     * @return lai
     */
    @Override
    public List<Company> getCompanyList(int currentPage, int pageSize) {
        return companyMapper.getCompanyList(currentPage,pageSize);
    }

    /**
     * 总记录数
     *
     * @return lai
     */
    @Override
    public int getTotalCount() {
        return companyMapper.getTotalCount();
    }
}
