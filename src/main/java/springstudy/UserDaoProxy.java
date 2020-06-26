package springstudy;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Proxy;

/**
 * @ProjectName: tbhStudy
 * @Package: springstudy
 * @ClassName: UserDaoProxy
 * @Description:
 * @Author: tbf
 * @CreateDate: 2020-06-14 22:58
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-06-14 22:58
 * @UpdateRemark:
 * @Version: 1.0
 */

public class UserDaoProxy  implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        UserDao dao = (UserDao) Proxy.newProxyInstance(this.getClass().getClassLoader(),new Class[]{UserDao.class},new MyInvocationHandler());
        return dao;
    }

    @Override
    public Class<?> getObjectType() {
        return UserDao.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
