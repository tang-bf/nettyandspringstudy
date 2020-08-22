package com.controller;

import com.annotation.Controller;
import com.annotation.RequestMapping;
import com.annotation.ResponseBody;
import com.entity.UserEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/test")
public class TestController {


    @RequestMapping("/test.do")
    @ResponseBody
    public Object test(String name, HttpServletRequest request, HttpServletResponse response, UserEntity userEntity){
        request.getParameter("name");
        //Setting > Build,Execution,Depoyment > Compiler > Java Compiler ，在"Additional command line parameters"中加上"-parameters"参数
        //需要jdk8指定-parameters 反射调用才能获取到方法上的参数名字，jdk7以前都是arg0 arg1
        System.out.println(name);
        System.out.println(request);
        System.out.println(response);
        System.out.println(userEntity);
        return  "test";

    }


    @RequestMapping("/model.do")
    public Object model(){

        return "index";
    }


}
