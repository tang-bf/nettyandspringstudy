package testconfiguration;

import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;

import java.io.IOException;

/**
 * @ProjectName: tbhStudy
 * @Package: springstudy
 * @ClassName: TestConfiguration
 * @Description:
 * @Author: tbf
 * @CreateDate: 2020-06-26 13:54
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-06-26 13:54
 * @UpdateRemark:
 * @Version: 1.0
 */

public class TestConfiguration {
    static {
        //生成jdk动态代理类
       // System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        //生成cglib动态代理类   会有三个类  一个代理类  两个继承了fastclass的类  会为方法建立索引
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\cglib");
    }
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext
                = new AnnotationConfigApplicationContext(AppConfigTest.class);
        OrderService bean = annotationConfigApplicationContext.getBean(OrderService.class);
        System.out.println(bean.getClass().getName());
        //bean.query();
        AppConfigTest appConfigTest = annotationConfigApplicationContext.getBean(AppConfigTest.class);
//        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\cglib");
//        try {
//            System.in.read();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
       // ConfigurationClassPostProcessor
        //AutowiredAnnotationBeanPostProcessor 处理autowired自动注入
        //CommonAnnotationBeanPostProcessor resource自动注入
    }
}
