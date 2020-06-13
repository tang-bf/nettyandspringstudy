package springstudy;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Annotated;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.*;
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
@Repository
public class BeanFactoryPostProcessorDemo implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        AnnotatedBeanDefinition indexDao = (AnnotatedBeanDefinition) beanFactory.getBeanDefinition("indexDao");
        indexDao.setScope(ConfigurableBeanFactory.SCOPE_PROTOTYPE);
    }

}
