package springmvctestdemo.test;

import org.apache.catalina.Lifecycle;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

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
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(9898);
        tomcat.addWebapp("/","d:\\tomc\\");
        try{
            tomcat.start();
            //tomcat就是一个socket连接.所以要使其阻塞
            tomcat.getServer().await();
        }catch (LifecycleException e){
            e.printStackTrace();
        }finally{

        }
    }
}
