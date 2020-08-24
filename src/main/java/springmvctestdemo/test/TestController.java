package springmvctestdemo.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import sun.security.provider.MD5;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

/**
 * 需要咨询JAVA高级VIP课程的可以加白浅老师的QQ：2207192173
 * 需要视频资料或者咨询课程的可以加若曦老师的QQ：2408349392
 * author：鲁班学院-商鞅老师
 */
//@Controller//   R
//@SessionAttribute()
public class TestController  {




    //1:扫描整个项目
    //2:判断有没有@Controller 或者 @RequestMapping
    //3：扫描方法
    //4:判断有没有直接
    //5:吧注解的值与map绑定起来

    //只能通过反射来执行
    //java 调用一个方法 有哪几种方式？
    //1：new 具体的对象 .方法名（）；
    //2：定义一个接口 需要调用的类实现目标接口  直接调用接口的实现方法
    //3：目标对象是一个Servlet对象 可以吧请求转发给对应的servlet 来调用
    //4：反射

    //反射执行一个方法需要2条件
    //执行方法的对象
    //参数

    //可能有一部分Controller需要拿当前登录用户信息


    //HandlerMethodReturnValueHandler 去判断上面有没有@ResponseBody注解
    //如果有 就由当前handle来处理
    //先判断返回值类型是不是string
    //如果需要消息类型转换 会尝试去找一个用户自定义的消息转换器
    //并且由消息转换器实现消息输出
//    @RequestMapping("/test.do")
//    @ResponseBody                                                   //user 对象  Map
//    public Object test(@UserParam  Map map, String name, HttpServletRequest request, HttpServletResponse response ){
//        System.out.println(map.get("name"));
//        //map<name,value>
//        System.out.println("调用了");
//        //拿当前登录用户的逻辑....
////        request.setAttribute();
//        request.getParameter("name");
//        Map hashMap = new HashMap();
////        response.getWriter()
////        request.setAttribute();
////        {}
//        hashMap.put("key","value");
//        return  hashMap;
//    }
//
//
//    public View view(){
//        //
//        return null;
//    }
//
//
//    @RequestMapping
//    public ModelAndView modelAndView (){
//        ModelAndView modelAndView = new ModelAndView();
////        modelAndView.getModel().put();
//        modelAndView.getModel().put("name","value");
//        modelAndView.setViewName("index");
//
//        return modelAndView;
//    }
//
//    @RequestMapping("/model.do")
////    @ResponseBody
//    public String model(@PathVariable  HttpServletRequest request,HttpServletResponse response) throws Exception{
//        // /page/index.html
////        response.getWriter().close();
//        return "index";
//    }




}
