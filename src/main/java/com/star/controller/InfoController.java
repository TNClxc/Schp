package com.star.controller;

import com.star.service.InfoService;
import com.star.utils.Pageutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class InfoController {

    @Autowired
    private InfoService infoService;

    /**
     * 查询所有发布职位
     *
     * @param request
     * @return lai
     */
    @RequestMapping("/infoList")
    public String getInfoList(HttpServletRequest request, @RequestParam(value = "currentPage",required = false)String currentPage) {
        Pageutil pageutil=null;
        if(currentPage==null){
            pageutil = new Pageutil(1, infoService.getTotalCount());
            request.setAttribute("infoList", infoService.getInfoList(pageutil.getCurrentPage(), Pageutil.PAGE_SIZE));
            request.setAttribute("pageUtil", pageutil);
            return "wenzhang_xinwen";
        }else{
            pageutil = new Pageutil(Integer.parseInt(currentPage), infoService.getTotalCount());
            request.setAttribute("infoList", infoService.getInfoList(pageutil.getCurrentPage(), Pageutil.PAGE_SIZE));
            request.setAttribute("pageUtil", pageutil);
            return "wenzhang_xinwen";
        }

    }
}
