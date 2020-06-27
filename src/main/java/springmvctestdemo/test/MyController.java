package springmvctestdemo.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.annotation.Retention;

/**
 * @ProjectName: tbhStudy
 * @Package: springmvctestdemo.test
 * @ClassName: MyController
 * @Description:
 * @Author: tbf
 * @CreateDate: 2020-06-27 23:06
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-06-27 23:06
 * @UpdateRemark:
 * @Version: 1.0
 */
@Controller
public class MyController {
    @RequestMapping("/query.do")
    public  String query(){
        System.out.println("query ---");
        return "success";
    }
}
