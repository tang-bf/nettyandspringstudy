package springstudy;

import org.springframework.context.annotation.*;

/**
 * @ProjectName: tbhStudy
 * @Package: springstudy
 * @ClassName: AppConfig
 * @Description:
 * @Author: tbf
 * @CreateDate: 2020-06-11 22:06
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-06-11 22:06
 * @UpdateRemark:
 * @Version: 1.0
 */

@Configuration
//把这个注释去掉也是能正常的，为什么？为什么没有@Configuration注解的类中的@Bean方法也能被扫描到？
//官方管这两种模式分别叫：Full @Configuration和lite @Bean mode，习惯把称为Spring配置的Full模式和Lite模式更易沟通。 spring终极问题
//加了configuration的认为是full
//一下是lite模式
//类上标注有@Component注解
//类上标注有@ComponentScan注解
//类上标注有@Import注解
//类上标注有@ImportResource注解
//Full @Configuration中的@Bean方法会被CGLIB所代理，
// 而 lite @Bean mode中的@Bean方法不会被CGLIB代理。
@ComponentScan("springstudy")
//@Import(MyImportSelector.class)  //通过import 引入实现了importselector的类
@Import(MyImportBeanDefinitionRegistrar.class)
@EnableAspectJAutoProxy
//@EnableAspectJAutoProxy(proxyTargetClass = false)
public class AppConfig {
   // @Bean
}
