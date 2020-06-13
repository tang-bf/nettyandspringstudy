package springstudy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @ProjectName: tbhStudy
 * @Package: springstudy
 * @ClassName: BeanPostProcessorDemo
 * @Description:
 * @Author: tbf
 * @CreateDate: 2020-06-13 22:47
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-06-13 22:47
 * @UpdateRemark:
 * @Version: 1.0
 */
@Component
public class BeanPostProcessorDemo implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        if(beanName.equals("IndexDao")){
            System.out.println("before initi");

//        }
        return  bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("after initi");

        return bean;
    }
}
