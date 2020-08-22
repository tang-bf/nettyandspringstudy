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
