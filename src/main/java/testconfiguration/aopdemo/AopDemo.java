package testconfiguration.aopdemo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: tbhStudy
 * @Package: testconfiguration.aopdemo
 * @ClassName: AopDemo
 * @Description:
 * @Author: tbf
 * @CreateDate: 2020-06-26 23:52
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-06-26 23:52
 * @UpdateRemark:
 * @Version: 1.0
 */
@Component
@Aspect//("perthis(target(testconfiguration.aopdemo.ShopService))")//perthis pertarget必须让切面是原型，否则报错
/**
 * Bean with name 'aopDemo' is a singleton, but aspect instantiation model is not singleton
 */
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class AopDemo {
    //作用到具体方法上
    @Pointcut("execution(* testconfiguration.aopdemo.*.*(..))")
    public void pointCutExecution1 (){

    }
    //只能作用到类的级别上
//    @Pointcut("within(testconfiguration.OrderService*)")
//    public void pointCutExecution2 (){
//
//    }
//    @Pointcut("args(java.lang.String)")
//    public void pointCutExecution3 (){
//
//    }
    //this表示代理对象 是shopservice的类的素有方法都会执行
    //target表示目标对象  this target 是否一致取决于用的jdk动态代理还是cglib
    @Pointcut("this(testconfiguration.aopdemo.ShopService)")
    public void pointThis (){

    }
    @Pointcut("target(testconfiguration.aopdemo.ShopService)")
    public void pointTarget (){

    }
//    @Pointcut("target(testconfiguration.OrderService*)")
//    public void pointCutExecution5 (){
//
//    }
//    @Pointcut("execution(* testconfiguration.aopdemo.*.*(..)) && args(java.lang.String,..)")
//    public void pointCutExecution7(){
//
//    }
//    //@within 检查类是不是加注解
//    //检查方法上是不是加注解
//    @Pointcut("@annotation(testconfiguration.aopdemo.CustomConfiguration)")
//    public void pointCutExecution6(){
//
//    }
//    @Pointcut("")
//    public void pointCutExecution8(){
//
//    }
    @Before("pointThis()")
    public void logDemoThis (){
        System.out.println("this  执行......");
    }
    @Before("pointTarget()")
    public void logDemoTarget (){
        System.out.println("target  执行......");
    }
    //自定义注解
//    @Before("pointCutExecution1()")
//    public void logDemo (){
//        System.out.println("增强方法执行，当前切面："+this.hashCode());
//    }
    @Around("pointCutExecution1()")
    public void aroundDemo (ProceedingJoinPoint pj) throws Throwable {
        System.out.println("around 111");
        System.out.println(pj.getArgs().toString());
        pj.proceed();
        System.out.println("around 222");
    }
}
