package springstudy;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.lang.reflect.Proxy;

/**
 * @ProjectName: tbhStudy
 * @Package: springstudy
 * @ClassName: MyImportBean
 * @Description:
 * @Author: tbf
 * @CreateDate: 2020-06-14 22:22
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-06-14 22:22
 * @UpdateRemark:
 * @Version: 1.0
 */

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
//        BeanDefinition beanDefinition = new BeanDefinition() {
//        }
      UserDao dao = (UserDao) Proxy.newProxyInstance(this.getClass().getClassLoader(),new Class[]{UserDao.class},new MyInvocationHandler());
        //模拟mybatis mapperscan
        // 扫描接口得到dao
        // 产生bd
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(dao.getClass());
        GenericBeanDefinition beanDefinition =(GenericBeanDefinition) beanDefinitionBuilder.getBeanDefinition();
        registry.registerBeanDefinition("userDao",beanDefinition);
    }
}
