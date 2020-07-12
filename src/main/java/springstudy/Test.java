package springstudy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.PropertyPlaceholderHelper;

/**
 * @ProjectName: tbhStudy
 * @Package: springstudy
 * @ClassName: Test
 * @Description:
 * @Author: tbf
 * @CreateDate: 2020-06-14 23:00
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-06-14 23:00
 * @UpdateRemark:
 * @Version: 1.0
 */
@MapperScan
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext
                = new AnnotationConfigApplicationContext(AppConfig.class);
        //annotationConfigApplicationContext
        //ClassPathXmlApplicationContext
        UserDao userDao = (UserDao) annotationConfigApplicationContext.getBean("userDao");
        userDao.query("aaaaa");
        //BeanDefinition bd = new BeanDefinition()；
        //BeanUtils.get
        }
       // BeanFactory
        //BeanDefinitionReader
        //DefaultListableBeanFactory
      //  PropertyPlaceholderHelper.PlaceholderResolver
    //}
}
