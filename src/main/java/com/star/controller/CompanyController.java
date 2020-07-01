package com.star.controller;

import com.star.pojo.Company;
import com.star.pojo.User;
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
        request.setAttribute("getCompany", companyList);
        request.setAttribute("pageUtil", pageutil);
        return "huodong_guanli";
    }

    /**
     * 查看企业下的文章及人员
     *
     * @return lai
     */
    @RequestMapping("/huodong_ChaoGuan")
    public String huodong_ChaoGuan(HttpServletRequest request, @RequestParam(value = "currentPage", required = false) String currentPage) {
        if (currentPage == null || currentPage == "") {
            currentPage = "1";
        }
        Pageutil pageutil = pageutil = new Pageutil(Integer.parseInt(currentPage), companyService.getTotalCount());
        List<Company> companyMap = companyService.getCompanyMap(pageutil.getStartIndex(), Pageutil.PAGE_SIZE);
        request.setAttribute("companyMap", companyMap);
        request.setAttribute("pageUtil", pageutil);
        return "huodong_ChaoGuan";
    }

    /**
     * 删除企业
     *
     * @param id
     * @return hao
     */
    @RequestMapping("/delCompanys")
    @ResponseBody
    public void delCompanys(@RequestParam("id") int id, HttpServletResponse response, @RequestParam(value = "currentPage") String currentPage) {

        try {
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = null;
            out = response.getWriter();
            int flag = companyService.delCompany(id);
            if (flag > 0) {
                out.print("<script language='javascript'>alert('删除成功');window.location='huodong_guanli?currentPage=" + currentPage + "';</script>");

            } else {
                out.print("<script language='javascript'>alert('删除失败');window.location='huodong_guanli';</script>");
            }
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 跳转新增公司页面
     *
     * @return hao
     */
    @RequestMapping("/company")
    public String company() {
        return "huodong_fabu";
    }

    /**
     * 添加新公司
     *
     * @param company
     * @param response
     * @throws Exception
     */
    @RequestMapping("/inCompany")
    @ResponseBody
    public void inCompany(Company company, HttpServletResponse response) throws Exception {
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = null;
        out = response.getWriter();
        int flag = companyService.insetCompany(company);
        if (flag > 0) {
            out.print("<script language='javascript'>alert('新增成功');window.location='huodong_guanli';</script>");
        } else {
            out.print("<script language='javascript'>alert('新增失败');window.location='company';</script>");
        }

    }

    @RequestMapping("/getCompany")
    public String getCompany(@RequestParam("id") int id, HttpServletRequest request) {
        List<Company> list = companyService.getCompany(id);
        request.setAttribute("list", list);
        return "huodong_dtl";
    }

    @RequestMapping("/back")
    public String roback() {
        return "redirect:/huodong_guanli";
    }

    //模糊搜索公司信息
    @RequestMapping("/getOfCompany")
    public String getOfCompany(@RequestParam(value = "currentPage", required = false) String currentPage, @RequestParam("companyName") String companyName, HttpServletRequest request) {
        if (currentPage == null || currentPage == "") {
            currentPage = "1";
        }
        Pageutil pageutil = pageutil = new Pageutil(Integer.parseInt(currentPage), companyService.getTotalCount());
        List<Company> list = companyService.getListOfCompany(companyName);
        pageutil = new Pageutil(1, list.size());
        request.setAttribute("getCompany", list);
        request.setAttribute("pageUtil", pageutil);
        return "huodong_guanli";
    }


    @RequestMapping("/upOfCompany")
    public String upOfCompany(Company company) {
        int flag = companyService.upOfCompany(company);
        if (flag > 0) {
            return "redirect:/huodong_guanli";
        } else {
            return "huodong_xiugai";
        }
    }

    @RequestMapping("/getCompanyss")
    public String getCompanys(@RequestParam("id") int id, HttpServletRequest request) {
        List<Company> list = companyService.getCompany(id);
        request.setAttribute("list", list);
        return "huodong_xiugai";
    }
}
