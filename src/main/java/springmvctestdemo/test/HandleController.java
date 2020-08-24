package springmvctestdemo.test;

import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * controller实现方式
 */
@Component("/test3") //BeanName
//<bean name="test1.,son">
public class HandleController implements HttpRequestHandler {

    //默认会识别两种Controller
    //一种是以BeanName 声明的URL的的bean
    //一种是@Controller
    //在dispatcherservlet中 getHandler handlerMappings 有
    // requestmappinghandlemapping (mappingregistry registry(map requsetmappinginfo query.do bean=mycontroller method query  ))
    // beannameurlhandlermapping (handlermap beannamecontroller user.do test3)
    // getHandlerAdapter 会有三个requestmappinghandleradapter  httprequesthand...  simplecontrollerhand...
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("111");
    }
}
