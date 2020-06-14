package springstudy;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

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
@ComponentScan("springstudy")
//@Import(MyImportSelector.class)  //通过import 引入实现了importselector的类
@Import(MyImportBeanDefinitionRegistrar.class)
//@EnableAspectJAutoProxy(proxyTargetClass = false)
public class AppConfig {
}
