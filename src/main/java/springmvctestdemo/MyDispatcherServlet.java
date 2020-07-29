package springmvctestdemo;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import springmvctestdemo.test.AppConfig;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @ProjectName: tbhStudy
 * @Package: springmvctestdemo
 * @ClassName: MyDispatcherServlet
 * @Description: spring 4.x就已经支持不用web.xml可以开发
 * @Author: tbf
 * @CreateDate: 2020-06-27 22:59
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-06-27 22:59
 * @UpdateRemark:
 * @Version: 1.0
 *
 *
 *
 * spring 中
 *  * @HandlesTypes(WebApplicationInitializer.class)
 *  * public class SpringServletContainerInitializer implements ServletContainerInitializer {
 *  spring  mvc >>>springboot零配置是很平滑的过度，只不过我们及很多人没发觉
 */

public class MyDispatcherServlet  implements WebApplicationInitializer {
    @Override
    //为什么能调用到这个方法  由servlet3.0规范下  resource/MEAT-IN
    /**
     * servlet规范中通过ServletContainerInitializer实现此功能。
     * 每个框架要使用ServletContainerInitializer就必须在对应的jar包的META-INF/services
     * 目录创建一个名为javax.servlet.ServletContainerInitializer的文件，
     * 文件内容指定具体的ServletContainerInitializer实现类，那
     * 么，当web容器启动时就会运行这个初始化器做一些组件内的初始化工作。
     * 一般伴随着ServletContainerInitializer一起使用的还有HandlesTypes注解，
     * 通过HandlesTypes可以将感兴趣的一些类注入到ServletContainerInitializerde的onStartup方法作为参数传入。
     * 3、SpringServletContainerInitializer
     * 通过源码发现，配合注解@HandlesTypes它可以将其指定的Class
     * 对象作为参数传递到onStartup方法中。
     * 进而在onStartup方法中获取Class对象的具体实现类，
     * 进而调用实现类中的具体方法。
     * SpringServletContainerInitializer类中@HandlesTypes指定的是Class对象是WebApplicationInitializer.Class。
     * 利用这个机制，若实现WebApplicationInitializer这个接口，我们就可以自定义的注入Servlet，或者Filter，即可以不再依赖web.xml的配置。
     */
    public void onStartup(ServletContext servletContext) throws ServletException {
        System.out.println("init ");
        AnnotationConfigWebApplicationContext webApplicationContext
                =new AnnotationConfigWebApplicationContext();
        webApplicationContext.register(AppConfig.class);
        webApplicationContext.refresh();
        //AbstractAnnotationConfigDispatcherServletInitializer
        // Create and register the DispatcherServlet
        DispatcherServlet servlet = new DispatcherServlet(webApplicationContext);
        ServletRegistration.Dynamic registration = servletContext.addServlet("app", servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("*.do");

    }
}
