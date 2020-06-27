package testconfiguration.aopdemo;

/**
 * @ProjectName: tbhStudy
 * @Package: testconfiguration.aopdemo
 * @ClassName: CustomService
 * @Description:
 * @Author: tbf
 * @CreateDate: 2020-06-27 0:55
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-06-27 0:55
 * @UpdateRemark:
 * @Version: 1.0
 */

public class CustomService {
    @CustomConfiguration
    public  void custom(){
        System.out.println("custom aop test");
    }

    public  void custom2(String s1,Integer integer,boolean TRUE){
        System.out.println("custom aop test");
    }
    public  void custom3(String s1,boolean TRUE){
        System.out.println("custom aop test");
    }
}
