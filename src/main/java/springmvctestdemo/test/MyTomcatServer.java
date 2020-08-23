package springmvctestdemo.test;

import org.apache.catalina.Context;
import org.apache.catalina.Lifecycle;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.LifecycleListener;
import org.apache.catalina.startup.Tomcat;
import org.springframework.context.event.ApplicationEventMulticaster;
//import org.springframework.context.event.EventListener;

import java.util.EventListener;

/**
 * @ProjectName: tbhStudy
 * @Package: springmvctestdemo.test
 * @ClassName: MyTomcatServer
 * @Description:
 * @Author: tbf
 * @CreateDate: 2020-06-27 23:11
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-06-27 23:11
 * @UpdateRemark:
 * @Version: 1.0
 */

public class MyTomcatServer {
    public static void main(String[] args) {
       //java.util.EventObject
        //EventListener

                //EventListener
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(9898);
        tomcat.addWebapp("/","d:\\tomc\\");//
      // tomcat.addContext("/","") ;不会调用mydispatcherservlet的onstartup方法
        // 只会去初始化一个context的资源目录  并不会加载web的声明周期
        /**解决办法
         * Context context = tomcat.addContext("/", "");
         * context.addLifecycleListener((LifecycleListener) Class.forName(tomcat.getHost().getConfigClass()).newInstance());
          */
        try {
            tomcat.start();
        } catch (LifecycleException ex) {
            ex.printStackTrace();
        }
        //tomcat就是一个socket连接.所以要使其阻塞
        tomcat.getServer().await();

    }
}
