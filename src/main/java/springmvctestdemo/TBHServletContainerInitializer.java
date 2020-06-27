package springmvctestdemo;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.Set;

/**
 * @ProjectName: tbhStudy
 * @Package: springmvctestdemo
 * @ClassName: TBHServletContainerInitializer
 * @Description:
 * @Author: tbf
 * @CreateDate: 2020-06-27 23:31
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-06-27 23:31
 * @UpdateRemark:
 * @Version: 1.0
 */

public class TBHServletContainerInitializer implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        System.out.println("container invoke");
    }
}
