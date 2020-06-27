package testconfiguration.aopdemo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: tbhStudy
 * @Package: testconfiguration.aopdemo
 * @ClassName: ShopService
 * @Description:
 * @Author: tbf
 * @CreateDate: 2020-06-27 0:02
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-06-27 0:02
 * @UpdateRemark:
 * @Version: 1.0
 */
@Service("shopService")
public class ShopService implements  ShopInterface{
    public void query(String s1){
        System.out.println("query ------");
    }
    public void query1(String s1,String s2){
        System.out.println("query1 ------");
    }
}
