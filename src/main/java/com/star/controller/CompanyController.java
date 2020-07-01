package com.star.controller;

import com.star.pojo.Company;
import com.star.service.CompanyService;
import com.star.utils.Pageutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class CompanyController {
    @Autowired
    CompanyService companyService;

    /**
     * 全部企业信息
     *
     * @return hao
     */
    @RequestMapping("/huodong_guanli")
    public String huodong_guanli(HttpServletRequest request,
                                 @RequestParam(value = "currentPage", required = false) String currentPage) {
        if (currentPage == null || currentPage == "") {
            currentPage = "1";
        }
        Pageutil pageutil = pageutil = new Pageutil(Integer.parseInt(currentPage), companyService.getTotalCount());
        List<Company> companyList = companyService.getCompanyList(pageutil.getStartIndex(), Pageutil.PAGE_SIZE);
        for (int i = 0; i < companyList.size(); i++) {
            System.out.println(companyList.get(i));
        }
        request.setAttribute("getCompany", companyList);
        request.setAttribute("pageUtil", pageutil);
        return "huodong_guanli";
    }

    /**
     * 查看企业下的文章及人员
     *
     * @return hao
     */
    @RequestMapping("/huodong_ChaoGuan")
    public String huodong_ChaoGuan() {
        return "huodong_ChaoGuan";
    }

    /**
     * 删除企业
     * @param id
     * @return hao
     */
    @RequestMapping("/delCompanys")
    @ResponseBody
    public void delCompanys(@RequestParam("id")int id, HttpServletResponse response) {

        try {
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = null;
            out = response.getWriter();
            int flag = companyService.delCompany(id);
            if (flag > 0) {
                System.out.println("删除的id为" + id);
                out.print("<script language='javascript'>alert('删除成功');</script>");

            } else {
                out.print("<script language='javascript'>alert('删除失败');</script>");
            }
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
