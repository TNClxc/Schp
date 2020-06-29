package com.star.controller;

import com.star.pojo.User;
import com.star.service.InfoService;
import com.star.service.PersonService;
import com.star.service.UserService;
import com.star.utils.Pageutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {

    @Resource
    private PersonService personService;
@Resource
private UserService userService;
    //人员详细信息展示
    @RequestMapping("/getPerson")
    public String getPerson(@RequestParam("id")int id,HttpServletRequest request){
        List<User> list=personService.getPersonage(id);
        request.setAttribute("list",list);
        return "zixun_dtl";
    }



    //删除人员信息
    @RequestMapping("/delPersons")
    public String delPersons(@RequestParam("id")int id){
        int flag=personService.delPerson(id);
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
        int flag=personService.upPerson(upUser);
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
    public String getPersons(@RequestParam("id")int id, HttpServletRequest request){
        List<User> list=personService.getPersonage(id);
        request.setAttribute("list",list);
        return "zixun_up";
    }


    //人员查询
    @RequestMapping("/UserList")
    public String UserList(HttpServletRequest request, @RequestParam(value = "currentPage",required = false)String currentPage){
        if (currentPage == null || currentPage == "") {
            currentPage = "1";
        }
        Pageutil pageutil = pageutil = new Pageutil(Integer.parseInt(currentPage), userService.getCount());
        List<User> list = userService.userList(pageutil.getStartIndex(), Pageutil.PAGE_SIZE);
        request.setAttribute("userList",list );
        request.setAttribute("pageUtil", pageutil);
        return "zixun_Team";


    }
    //人员模糊查询
    @RequestMapping("/getUserList")
    public String getUserList(@RequestParam("realName")String realName,HttpServletRequest request){
        Pageutil pageutil=null;
        List<User> infoList=userService.getUserList(realName);
        pageutil = new Pageutil(1, infoList.size());
        request.setAttribute("infoList",infoList);
        request.setAttribute("pageUtil", pageutil);
        return "zixun_Team";
    }


}
