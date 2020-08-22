package com.test;

import com.controller.TestController;
import com.entity.UserEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 
 */
public class Test {

    public static void main(String[] args) throws Exception {
        Method test = TestController.class.getMethod("test", String.class, HttpServletRequest.class, HttpServletResponse.class, UserEntity.class);
        System.out.println(test.getParameters()[0].getName());
    }
}
