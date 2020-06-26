package springstudy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ProjectName: tbhStudy
 * @Package: springstudy
 * @ClassName: MyInvocationHandler
 * @Description:
 * @Author: tbf
 * @CreateDate: 2020-06-14 22:44
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-06-14 22:44
 * @UpdateRemark:
 * @Version: 1.0
 */

public class MyInvocationHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(">>>>>>>>>>>>>proxy");
        return null;
    }
}
