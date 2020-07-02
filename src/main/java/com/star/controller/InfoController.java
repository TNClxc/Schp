package com.star.controller;


import com.star.pojo.Info;
import com.star.pojo.Praise;

import com.star.pojo.User;
import com.star.service.InfoService;
import com.star.service.PraiseService;
import com.star.utils.Pageutil;
import com.sun.deploy.net.HttpResponse;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;


@Controller
public class InfoController {

    @Autowired
    private InfoService infoService;
    @Autowired
    private PraiseService praiseService;

    /**
     * 查询所有发布职位
     *
     * @param request
     * @return lai
     */
    @RequestMapping("/infoList")
    public String getInfoList(HttpServletRequest request, @RequestParam(value = "currentPage", required = false) String currentPage) {
        if (currentPage == null || currentPage == "") {
            currentPage = "1";
        }
        Pageutil pageutil = pageutil = new Pageutil(Integer.parseInt(currentPage), infoService.getTotalCount());
        request.setAttribute("infoList", infoService.getInfoList(pageutil.getStartIndex(), Pageutil.PAGE_SIZE));
        request.setAttribute("pageUtil", pageutil);
        return "wenzhang_xinwen";

    }

    /**
     * 删除文章
     *
     * @param id
     * @param response
     * @return lai
     */
    @RequestMapping("/delInfo")
    @ResponseBody
    public void delInfo(@RequestParam("id") int id, HttpServletResponse response
            , HttpServletRequest request, @RequestParam(value = "currentPage") String currentPage) {
        try {
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            int result = infoService.delInfo(id);
            if (result > 0) {
                System.out.println("编号：" + id + "   删除成功   当前页数" + currentPage);
                out.print("<script language='javascript'>alert('删除成功');window.location='infoList?currentPage=" + currentPage + "';</script>");
            } else {
                out.print("<script language='javascript'>alert('删除失败');window.location='infoList';</script>");
            }
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 跳转☞☞☞☞☞☞☞☞文章发布页面
     * 加载文章类型
     *
     * @param request
     * @return lai
     */
    @RequestMapping("/xinwen_fabu")
    public String xinwen_fabu(HttpServletRequest request) {
        request.setAttribute("infoTypeList", infoService.getInfoTypeList());
        return "wenzhang_xinwen_fabu";
    }

    /**
     * 文章发布
     *
     * @param info
     * @param session
     * @return lai
     */
    @RequestMapping("/xinwenfabu")
    public String xinwenfabu(Info info, HttpSession session) {
        //获取发布人ID
        info.setUserId(((User) session.getAttribute("user")).getId());
        int result = infoService.infoAdd(info);
        if (result > 0) {
            System.out.println("职位添加成功");
        } else {
            System.out.println("职位添加失败");
        }
        return "redirect:infoList";
    }


    /**
     * 传入点赞人ID和文章ID
     * 检查是否有过点赞
     *
     * @param session
     * @param infoId
     * @return lai
     */
    @RequestMapping("/checkPraise")
    @ResponseBody
    public String checkPraise(HttpSession session, @RequestParam("infoId") int infoId) {
        int userId = ((User) session.getAttribute("user")).getId();
        if (praiseService.checkPraise(userId, infoId) > 0) {
            //已有点赞记录 ，无法点赞
            return "false";
        } else {
            //可以点赞
            return "true";
        }
    }

    /**
     * 点赞
     *
     * @param session
     * @param infoId
     * @return lai
     */
    @RequestMapping("/doPraise")
    @ResponseBody
    public String doPraise(HttpSession session, @RequestParam("infoId") int infoId) {
        int userId = ((User) session.getAttribute("user")).getId();
        int result = praiseService.addPraise(userId, infoId);
        System.out.println("用户编号：" + userId + "  信息编号：" + infoId + "     点赞" + (result > 0 ? "成功" : "失败"));
        return "addSuccess";
    }

    /**
     * 取消点赞
     *
     * @param session
     * @param infoId
     * @return lai
     */
    @RequestMapping("/delPraise")
    @ResponseBody
    public String delPraise(HttpSession session, @RequestParam("infoId") int infoId) {
        int userId = ((User) session.getAttribute("user")).getId();
        int result = praiseService.delPraise(userId, infoId);
        System.out.println("用户编号：" + userId + "  信息编号：" + infoId + "     取消点赞" + (result > 0 ? "成功" : "失败"));
        return result > 0 ? "delSuccess" : "";
    }

    /**
     * 跳转修改页面
     *
     * @param id
     * @return lai
     */
    @RequestMapping("/updateInfo")
    public String update(@RequestParam("id") int id,HttpServletRequest request) {

        request.setAttribute("infoTypeList",infoService.getInfoTypeList());
        request.setAttribute("info",infoService.getInfoById(id));
        return "wenzhang_xiugai";
    }

    /**
     * 修改发布信息
     *
     * @param request
     * @param info
     * @return lai
     */
    @RequestMapping("/doUpInfo")
    @ResponseBody
    public void updateInfo(HttpServletRequest request, Info info,HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        int result = infoService.upInfo(info);
        if (result > 0) {
            out.print("<script language='javascript'>alert('修改成功');window.location='infoList';</script>");
        } else {
            out.print("<script language='javascript'>alert('修改失败');</script>");
            //window.location='updateInfo'
        }
        out.flush();
        out.close();
    }
}
