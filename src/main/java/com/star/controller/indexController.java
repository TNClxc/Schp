package com.star.controller;

import com.star.pojo.schp_User;
import com.star.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class indexController {

    @Autowired
    private UserService userService;

    @RequestMapping("/lo")
    public String index() {
        return "login";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request) {
        String userName =request.getParameter("username");
        String passWord = request.getParameter("password");
        schp_User loginuser = userService.login(userName,passWord);
        if(loginuser!= null){
            System.out.println("成功");
            return "index";
        }else{
            System.out.println("失败");
            request.setAttribute("error","密码输入错误,请检查后重试 ");
            return "login";
        }
    }
    //用户注册
    @RequestMapping("/Regis")
    public String Regis(@RequestParam("realName")String realName, @RequestParam("UserName")String UserName, @RequestParam("PassWord")String PassWord, @RequestParam("sex")int sex, @RequestParam("usePhone")String usePhone,HttpServletRequest request){
        int flag=userService.Register(realName, UserName, PassWord, sex, usePhone);
        if (flag>0){
            System.out.println("注册姓名"+realName);
            System.out.println("注册用户名"+UserName);
            System.out.println("注册密码"+PassWord);
            System.out.println("注册电话号"+usePhone);
            return "login";
        }else{
            request.setAttribute("error","注册失败,请检查信息是否正确");
            return "register";
        }

    }
    @RequestMapping("/re")
    public String re(){
        return "register";
    }
}
