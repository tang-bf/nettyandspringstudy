package testconfiguration.aopdemo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ProjectName: tbhStudy
 * @Package: testconfiguration.aopdemo
 * @ClassName: CustomConfiguration
 * @Description:
 * @Author: tbf
 * @CreateDate: 2020-06-27 0:52
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-06-27 0:52
 * @UpdateRemark:
 * @Version: 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface CustomConfiguration {
}
