package testconfiguration.aopdemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @ProjectName: tbhStudy
 * @Package: testconfiguration.aopdemo
 * @ClassName: TBHAspect
 * @Description:
 * @Author: tbf
 * @CreateDate: 2020-06-26 23:40
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-06-26 23:40
 * @UpdateRemark:
 * @Version: 1.0
 */
@Configuration
@ComponentScan("testconfiguration.aopdemo*")
@EnableAspectJAutoProxy(proxyTargetClass = false)
/**
 * proxyTargetClass
 * true
 * 目标对象实现了接口 – 使用CGLIB代理机制
 * 目标对象没有接口(只有实现类) – 使用CGLIB代理机制
 * false
 * 目标对象实现了接口 – 使用JDK动态代理机制(代理所有实现了的接口)
 * 目标对象没有接口(只有实现类) – 使用CGLIB代理机制
 */

public class TBHAspect  {
    /**
     * Spring AOP支持AspectJ的singleton、perthis、pertarget实例化模型（目前不支持percflow、percflowbelow 和pertypewithin）。
     * perthis：每个切入点表达式匹配的连接点对应的AOP对象都会创建一个新切面实例；
     * pertarget：每个切入点表达式匹配的连接点对应的目标对象都会创建一个新的切面实例；
     */

}
