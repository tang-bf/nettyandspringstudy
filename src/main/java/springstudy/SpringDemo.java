package springstudy;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import thrift.generated.PersonServese;

import javax.annotation.Resource;

/**
 * @ProjectName: tbhStudy
 * @Package: springstudy
 * @ClassName: SpringDemo
 * @Description:
 * @Author: tbf
 * @CreateDate: 2020-06-09 21:30
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-06-09 21:30
 * @UpdateRemark:
 * @Version: 1.0
 */
//@Component
//@Configuration
public class SpringDemo  { //implements   FactoryBean{
    public static void main(String[] args) {
        /**
         * 传入参数为注解配置类的时候  DefaultListableBeanFactory 中
         * Map<String, BeanDefinition> beanDefinitionMap 会有6个rootbean
         * 加上注解类配置的扫描包下面的所有类
         */
//        AnnotationConfigApplicationContext annotationConfigApplicationContext
//                = new AnnotationConfigApplicationContext(AppConfig.class);
        AnnotationConfigApplicationContext annotationConfigApplicationContext
                = new AnnotationConfigApplicationContext();
        //ConfigurableListableBeanFactory   DefaultListableBeanFactory
        //annotationConfigApplicationContext.getBean(SpringDemo.class);
        //单独注册普通bean的时候需要手动refresh，否则报错
        /**
         * AnnotationConfigApplicationContext@51521cc1 has not been refreshed yet
         */
        annotationConfigApplicationContext.register(IndexDao.class);
        annotationConfigApplicationContext.refresh();
        IndexDao dao =(IndexDao) annotationConfigApplicationContext.getBean(IndexDao.class);
        dao.query();
     //   annotationConfigApplicationContext.scan("com.java");

    }

//    @Override
//    public Object getObject() throws Exception {
//        return null;
//    }
//
//    @Override
//    public Class<?> getObjectType() {
//        return null;
//    }
//
//    @Override
//    public boolean isSingleton() {
//        return false;
//    }
}
