package springstudy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext
                = new AnnotationConfigApplicationContext(AppConfigTest.class);
        UserService bean = annotationConfigApplicationContext.getBean(UserService.class);
        System.out.println(bean.getClass().getName());
        //bean.query();
    }
}
