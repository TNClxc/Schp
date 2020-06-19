package com.star.controller;

import com.star.pojo.User;
import com.star.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class indexController {

    @Autowired
    private UserService userService;

    //初始页面
    @RequestMapping("/login")
    public String index() {
        return "login";
    }

    //登录验证
    @RequestMapping("/dologin")
    public String login(HttpServletRequest request, HttpSession session) {
        String userName =request.getParameter("username");
        String passWord = request.getParameter("password");
        User loginuser = userService.login(userName,passWord);
        if(loginuser!= null){
            System.out.println("成功");
            //session获取当前用户的信息
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

    //验证用户名是否重复
    @RequestMapping("/repeat")
    @ResponseBody
    public String repeat(@RequestParam("userName")String userName){
        String result = (userService.repeat(userName)>0)?"false":"true" ;
            return result;
    }

    //跳转修改密码方法
    @RequestMapping("/upPwd")
    public String upPwd(){
        return "change_psw";
    }

    //修改密码
    @RequestMapping("/change_psw")
    public String change_psw(@RequestParam("passWord")String passWord,HttpServletRequest request){
        int id=((User)request.getSession().getAttribute("user")).getId();
        int flag=userService.upPwd(passWord,id);
        if (flag>0){
            System.out.println("修改后密码"+passWord);
            return "redirect:/login";
        }else{
            request.setAttribute("error","修改错误");
            return "change_psw";
        }
    }

    //修改时查询原始密码是否正确
    @RequestMapping("/checkPwds")
    @ResponseBody
    public String checkPwds(@RequestParam("passWord")String passWord){
        return (userService.checkPwd(passWord)!=null)?"true":"false";
    }

    //退出方法
    @RequestMapping("/exit")
    public String exit(HttpSession session,HttpServletRequest request){
        //清除session
        session.removeAttribute("user");
        //重定向到登录页面
        return "redirect:/login";
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
    //iframe跳转文章发布界面
    @RequestMapping("/article")
    public String article(){
        return "wenzhang_xinwen";
    }
}
