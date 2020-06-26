package testconfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ProjectName: tbhStudy
 * @Package: springstudy
 * @ClassName: AppConfigTest
 * @Description:
 * @Author: tbf
 * @CreateDate: 2020-06-26 13:45
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-06-26 13:45
 * @UpdateRemark:
 * @Version: 1.0
 */
@Configuration
@ComponentScan(value = "testconfiguration")
public class AppConfigTest {
    @Bean
    public UserService userService(){
        return new UserService();
        //  System.out.println("init"); 构造方法输出语句
    }
    @Bean
    public OrderService orderService(){
        userService(); //如果没有加@Configuration注解，System.out.println("init")会输出两次，加了之后只打印一次
        //加了@Configuration注解， appConfigTest会被cglib代理AppConfigTest$$EnhancerBySpringCGLIB$$80....，full 模式；不加是lite modle bean
        return new OrderService();
    }

}
