package springstudy;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

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

public class MyImportBean implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
//        BeanDefinition beanDefinition = new BeanDefinition() {
//        }
//        registry.registerBeanDefinition();
    }
}
