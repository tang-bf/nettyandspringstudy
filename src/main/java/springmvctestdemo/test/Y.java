package springmvctestdemo.test;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ProjectName: tbhStudy
 * @Package: springmvctestdemo.test
 * @ClassName: Y
 * @Description:
 * @Author: tbf
 * @CreateDate: 2020-07-01 20:17
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-07-01 20:17
 * @UpdateRemark:
 * @Version: 1.0
 */

public class Y implements X {
    @Transactional(propagation=Propagation.REQUIRED)
    public  void query(){
        System.out.println("-----------");
    }
}
