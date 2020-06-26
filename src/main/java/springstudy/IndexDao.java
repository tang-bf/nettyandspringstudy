package springstudy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @ProjectName: tbhStudy
 * @Package: springstudy
 * @ClassName: IndexDao
 * @Description:
 * @Author: tbf
 * @CreateDate: 2020-06-11 22:01
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-06-11 22:01
 * @UpdateRemark:
 * @Version: 1.0
 */
@Repository
public class IndexDao {
    @Autowired
    AppConfig appConfig;
    public void query(){
        System.out.println("test");
    }
}
