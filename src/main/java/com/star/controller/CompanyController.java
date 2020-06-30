package com.star.controller;

import com.star.pojo.Company;
import com.star.service.CompanyService;
import com.star.utils.Pageutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CompanyController {
    @Autowired
    CompanyService companyService;

    /**
     * 全部企业信息
     *
     * @return lai
     */
    @RequestMapping("/huodong_guanli")
    public String huodong_guanli(HttpServletRequest request,
                                 @RequestParam(value = "currentPage", required = false) String currentPage) {

        if (currentPage == null || currentPage == "") {
            currentPage = "1";
        }
        Pageutil pageutil = pageutil = new Pageutil(Integer.parseInt(currentPage), companyService.getTotalCount());
        List<Company> companyList = companyService.getCompanyList(pageutil.getStartIndex(), Pageutil.PAGE_SIZE);
        request.setAttribute("getCompany", companyList);
        return "huodong_guanli";
    }

    /**
     * 查看企业下的文章及人员
     *
     * @return lai
     */
    @RequestMapping("/huodong_ChaoGuan")
    public String huodong_ChaoGuan() {


        return "huodong_ChaoGuan";
    }
}
