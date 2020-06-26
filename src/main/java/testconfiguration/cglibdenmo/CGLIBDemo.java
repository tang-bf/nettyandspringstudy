package testconfiguration.cglibdenmo;

//import org.springframework.cglib.core.SpringNamingPolicy;
import org.springframework.cglib.proxy.Enhancer;
//import org.springframework.context.annotation.ConfigurationClassEnhancer;

/**
 * @ProjectName: tbhStudy
 * @Package: testconfiguration.cglibdenmo
 * @ClassName: CGLIBDemo
 * @Description:
 * @Author: tbf
 * @CreateDate: 2020-06-26 15:01
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-06-26 15:01
 * @UpdateRemark:
 * @Version: 1.0
 */

public class CGLIBDemo  {
    public static void main(String[] args) {
        /**
         * 参照spring 通过cglib代理
         */
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Buyer.class);
//        enhancer.setInterfaces(new Class<?>[] {EnhancedConfiguration.class});
//        enhancer.setUseFactory(false);
//        enhancer.setNamingPolicy(SpringNamingPolicy.INSTANCE);
//        enhancer.setStrategy(new ConfigurationClassEnhancer.BeanFactoryAwareGeneratorStrategy(classLoader));
//        enhancer.setCallbackFilter(CALLBACK_FILTER);
//        enhancer.setCallbackTypes(CALLBACK_FILTER.getCallbackTypes());
        enhancer.create();

    }
}
