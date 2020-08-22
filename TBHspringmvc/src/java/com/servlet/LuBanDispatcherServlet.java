package com.servlet;

import com.annotation.Controller;
import com.annotation.RequestMapping;
import com.annotation.ResponseBody;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class LuBanDispatcherServlet extends HttpServlet {


    private static String  COMPENT_SCAN_ELEMENT_PACKAGE_NAME= "package";

    private static String COMPENT_SCAN_ELEMENT_NAME = "compentScan";

    private static String XML_PATH_LOCAL= "xmlPathLocal";

    private  static String prefix = "";
    private  static String suffix = "";

    private static String projectPath = LuBanDispatcherServlet.class.getResource("/").getPath();

    private  static Map<String,Method> methodMap = new HashMap<>();


    /**
     * init主要做得事情:
     * 加载配置文件 web.xml 加载spring mvc.xml
     扫描整个项目 根据配置文件给定的目录来扫描
     扫描所有加了@Controller注解的类
     当扫描到加了@Controller注解的类之后遍历里面所有的方法
     拿到方法对象之后 解析方法上面是否加了@RequestMapping注解
     定义一个Map集合  吧@RequstMapping的Value 与方法对象绑定起来
     Map<String,Method>
     * @param config
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        //解析xml  解析web.xml 解析lubanMvc.xml
//        lubanMvc.xml
        //initParameter 就是用户在web.xml里面指定的配置文件的地址 :lubanMvc.xml
//        \\  =\   //  d:\\\\  = d:\\  d://// =
        //projectPath需要进行url转义 空格 会变成%20
//        URLEncoder;
//        URLDecoder;
        projectPath = projectPath.replaceAll("%20"," ");
        String initParameter = config.getInitParameter(XML_PATH_LOCAL);
        //解析xml文件 file:xml 文件对象
        File file = new File(projectPath + "//" + initParameter);
        Document prase = prase(file);
        Element rootElement = prase.getRootElement();
        Element view = rootElement.element("view");
        prefix = view.attribute("prefix").getValue();
        suffix = view.attribute("suffix").getValue();
        //
        Element compentScanEle = rootElement.element(COMPENT_SCAN_ELEMENT_NAME);
        // value：com
        String value = compentScanEle.attribute(COMPENT_SCAN_ELEMENT_PACKAGE_NAME).getValue();
        scanProjectByPath(projectPath+"\\"+value);
        //        element.element("A")
        //扫描项目
//        super.init(config);
    }

    public void scanProjectByPath(String path){
        File file =new File(path);
        //递归解析项目所有文件
        scanFile(file);
    }

    public void scanFile(File file){
        //递归解析项目
        if (file.isDirectory()){
            for (File file1 : file.listFiles()) {
                scanFile(file1);
            }
        }else{
            //如果不是文件夹
            //D://project//com//TestContrller.class
            //D://project//com//controller//TestController.class
            //com.controller.TestController
            String filePath =  file.getPath();
            String suffix =filePath.substring(filePath.lastIndexOf("."));
            if (suffix.equals(".class")){
                String classPath  =  filePath.replace(new File(projectPath).getPath()+"\\","");
                classPath = classPath.replaceAll("\\\\",".");
                String className = classPath.substring(0,classPath.lastIndexOf("."));
                try {
                    Class<?> clazz = Class.forName(className);
                    if (clazz.isAnnotationPresent(Controller.class)) {
                        RequestMapping classRequestMapping = clazz.getAnnotation(RequestMapping.class);
                        String classRequestMappingUrl = "";
                        if (classRequestMapping!=null){
                            classRequestMappingUrl = classRequestMapping.value();
                        }
                        for (Method method : clazz.getDeclaredMethods()) {
                            if (!method.isSynthetic()) {
                                RequestMapping annotation = method.getAnnotation(RequestMapping.class);
                                if (annotation != null) {
                                    String methodRequsetMappingUrl  = "";
                                    methodRequsetMappingUrl  = annotation.value();
                                    System.out.println("类:"+clazz.getName()+"的"+method.getName()+"方法被映射到了"+classRequestMappingUrl+methodRequsetMappingUrl+"上面");
                                    methodMap.put(classRequestMappingUrl+methodRequsetMappingUrl,method);
                                }

                            }
                        }
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }


                //Class.forName
            }

        }
    }

    /**
     *
     * @param file ：你的xml文件对象
     * @return
     */
    public Document prase(File file){
        SAXReader saxReader = new SAXReader();
        try {
           return saxReader.read(file);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return null;

    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doPost(req,resp);
    }

    /**
     * 执行的时候做的事情:
     * 拿到请求URI去map里面get
     * 给参数赋值并调用方法
     * 拿到方法返回值做视图跳转和消息返回
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //拿到请求的URI
        String requestURI = req.getRequestURI();
        Method method = methodMap.get(requestURI);
        if (method!=null){
            //jdk8以前 直接拿参数名称 拿不到
            Parameter[] parameters = method.getParameters();
            Object[] objects = new Object[parameters.length];
            for (int i = 0; i < parameters.length; i++) {
                Parameter parameter = parameters[i];
                String name = parameter.getName();
                Class type = parameter.getType();
                if (type.equals(String.class)){
                    objects[i] = req.getParameter(name);
                }else if(type.equals(HttpServletRequest.class)){
                    objects[i] = req;
                }else if(type.equals(HttpServletResponse.class)){
                    objects[i] = resp;
                }else{
                    try {
                        Object o = type.newInstance();
//                        type.getDeclaredConstructor().newInstance()
                        for (Field field : type.getDeclaredFields()) {
                            field.setAccessible(true);
                            String fieldName = field.getName();
                            field.set(o,req.getParameter(fieldName));
                        }
                        objects[i] = o;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            try {
                Object o= null;
                o = method.getDeclaringClass().newInstance();
                Object invoke = method.invoke(o, objects);
                // 判断返回值是否是Void
                if (!method.getReturnType().equals(Void.class)){
                    ResponseBody annotation = method.getAnnotation(ResponseBody.class);
                    if (annotation!=null){
                        //提供接口来做这个事情
                        resp.getWriter().write(String.valueOf(invoke));
                    }else {
                        // /page/index.html   page/index.html
                        req.getRequestDispatcher(prefix+String.valueOf(invoke)+suffix).forward(req,resp);
                    }

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            resp.setStatus(404);
        }
        //        super.doPost(req, resp);
    }


}
