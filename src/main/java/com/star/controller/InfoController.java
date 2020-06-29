package com.star.controller;

import com.star.pojo.User;
import com.star.service.InfoService;
import com.star.utils.Pageutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    //人员详细信息展示
    @RequestMapping("/getPerson")
    public String getPerson(@RequestParam("id")int id,HttpServletRequest request){
        List<User> list=infoService.getPersonage(id);
        request.setAttribute("list",list);
        return "zixun_dtl";
    }



    //删除人员信息
    @RequestMapping("/delPersons")
    public String delPersons(@RequestParam("id")int id){
        int flag=infoService.delPerson(id);
        if (flag>0){
            System.out.println("删除成功,被删除的Id为"+id);
            return "redirect:/UserList";
        }else {
            System.out.println("删除失败");
            return "zixun_Team";
        }
    }
    //修改人员信息
    @RequestMapping("/upPerson")
    public String upPerson(User upUser){
        int flag=infoService.upPerson(upUser);
        if(flag>0){
            System.out.println("修改后用户"+upUser.getRealName()+upUser.getSex()+upUser.getUsePhone()+upUser.getUserRoleId());
            return "redirect:/UserList";
        }else{
            return "zixun_up";
        }
    }

    //人员修改页面
    @RequestMapping("/zixun_up")
    public String zixun_up(){
        return "zixun_up";
    }

    //修改信息展示
    @RequestMapping("/getPersons")
    public String getPersons(@RequestParam("id")int id,HttpServletRequest request){
        List<User> list=infoService.getPersonage(id);
        request.setAttribute("list",list);
        return "zixun_up";
    }
}
