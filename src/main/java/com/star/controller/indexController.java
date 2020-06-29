package com.star.controller;

import com.star.pojo.User;
import com.star.service.UserService;
import com.star.utils.Pageutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class indexController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String index() {
        return "login";
    }

    @RequestMapping("/dologin")
    public String login(HttpServletRequest request, HttpSession session) {
        String userName =request.getParameter("username");
        String passWord = request.getParameter("password");
        User loginuser = userService.login(userName,passWord);
        if(loginuser!= null){
            session.setAttribute("user",loginuser);
            return "index";
        }else{
            System.out.println("失败");
            request.setAttribute("error","密码输入错误,请检查后重试 ");
            return "login";
        }
    }
    //用户注册
    @RequestMapping("/doregister")
    public String doregister(User user ,HttpServletRequest request){
        System.out.println("注册姓名"+user.getRealName());
        System.out.println("注册用户名"+user.getUserName());
        int flag=userService.Register(user);
        if (flag>0){
            return "login";
        }else{
            request.setAttribute("error","注册失败,请检查信息是否正确");
            return "register";
        }

    }
    //跳转注册方法
    @RequestMapping("/register")
    public String register(){
        return "register";
    }

    //查看登录用户名是否重复
    @RequestMapping("/repeat")
    @ResponseBody
    public String repeat(@RequestParam("userName")String userName){
        String result = (userService.repeat(userName)>0)?"false":"true" ;
            return result;
    }

    //修改密码
    @RequestMapping("/change_psw")
    public String change_psw(@RequestParam("passWord")String passWord,HttpServletRequest request){
        int id=((User)request.getSession().getAttribute("user")).getId();
        int flag=userService.upPwd(passWord,id);
        if (flag>0){
            System.out.println("修改后密码"+passWord);
            return "redirect:/exit";
        }else{
            request.setAttribute("error","修改错误");
            return "change_psw";
        }
    }

    //修改时查询原始密码是否正确
    @RequestMapping("/checkPwds")
    @ResponseBody
    public String checkPwds(@RequestParam("passWord")String passWord,HttpServletRequest request){
        String name=((User)request.getSession().getAttribute("user")).getUserName();
        return (userService.checkPwd(passWord,name)!=null)?"true":"false";
    }



    //人员查询
    @RequestMapping("/UserList")
    public String UserList(HttpServletRequest request, @RequestParam(value = "currentPage",required = false)String currentPage){
        Pageutil pageutil=null;
        if(currentPage==null){
            pageutil = new Pageutil(1, userService.getCount());
            request.setAttribute("infoList", userService.userList(pageutil.getCurrentPage(), Pageutil.PAGE_SIZE));
            request.setAttribute("pageUtil", pageutil);
            return "zixun_Team";
        }else{
            pageutil = new Pageutil(Integer.parseInt(currentPage), userService.getCount());
            request.setAttribute("infoList", userService.userList(pageutil.getCurrentPage(), Pageutil.PAGE_SIZE));
            request.setAttribute("pageUtil", pageutil);
            return "zixun_Team";
        }
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

    //头部公用方法
    @RequestMapping("/header")
    public String header(){
        return "public_header";
    }
    //公用左边方法
    @RequestMapping("/leftAll")
    public String leftAll(){
        return "public_left";
    }
    //修改密码
    @RequestMapping("/upPwd")
    public String upPwd(){
        return "change_psw";
    }
    //退出登录
    @RequestMapping("/exit")
    public String exit(HttpSession session){
        session.removeAttribute("user");
        return "login";
    }
}
