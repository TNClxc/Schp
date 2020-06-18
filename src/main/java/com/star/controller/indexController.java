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

@Controller
public class indexController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String index() {
        return "login";
    }

    @RequestMapping("/dologin")
    public String login(HttpServletRequest request) {
        String userName =request.getParameter("username");
        String passWord = request.getParameter("password");
        User loginuser = userService.login(userName,passWord);
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

    @RequestMapping("/repeat")
    @ResponseBody
    public String repeat(@RequestParam("userName")String userName){

        String result = (userService.repeat(userName)>0)?"false":"true" ;
            return result;
    }
}
