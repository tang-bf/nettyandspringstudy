package testconfiguration.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import testconfiguration.AppConfigTest;
import testconfiguration.OrderService;

/**
 * @ProjectName: tbhStudy
 * @Package: testconfiguration.aopdemo
 * @ClassName: TestAopDemo
 * @Description:
 * @Author: tbf
 * @CreateDate: 2020-06-27 15:30
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-06-27 15:30
 * @UpdateRemark:
 * @Version: 1.0
 */

public class TestAopDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext
                = new AnnotationConfigApplicationContext(TBHAspect.class);
        ShopInterface bean = (ShopInterface) annotationConfigApplicationContext.getBean("shopService");

        System.out.println(bean.getClass().getName());
        bean.query("sq");
        bean.query1("s1","s2");
        AopDemo aopDemo = annotationConfigApplicationContext.getBean(AopDemo.class);
        AopDemo aopDemo1 = annotationConfigApplicationContext.getBean(AopDemo.class);
        System.out.println(aopDemo == aopDemo1);
    }
}
