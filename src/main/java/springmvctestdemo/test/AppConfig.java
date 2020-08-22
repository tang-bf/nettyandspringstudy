package springmvctestdemo.test;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import java.util.List;

/**
 * @ProjectName: tbhStudy
 * @Package: springmvctestdemo.test
 * @ClassName: AppConfig
 * @Description:
 * @Author: tbf
 * @CreateDate: 2020-06-27 23:02
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-06-27 23:02
 * @UpdateRemark:
 * @Version: 1.0
 */

/**
 * xml方式配置spring mvc
 * 编写web.xml；注册listener、注册servlet、注册servlet-mapping
 * 编写spring-mvc.xml
 * 执行servlet规范：
 * 在"根目录/resources/META-INF/services/"添加配置文件javax.servlet.ServletContainerInitializer
 * 自定义一个类实现spring提供的WebApplicationInitializer接口，实例化&初始化spring容器
 * 自定义controller类和业务逻辑
 * 打包部署到web容器(通常使用tomcat)
 *
 * 零xml配置  内置tomcat 启动spring mvc
 * AppConfig 代替spring-mvc.xml
 * 注解方式驱动springmvc，等同于<annotation:driver>
 * 不加不会解析WebMvcConfigurer接口
 *  如果不加@EnableWebMvc，就要改成extends WebMvcConfigurationSupport
 *  因为@EnableWebMvc  import 的DelegatingWebMvcConfiguration 也是extends WebMvcConfigurationSupport
 */
@Component
@ComponentScan("springmvctestdemo")
//加上注解mvc实质生效
@EnableWebMvc
@EnableTransactionManagement
public class AppConfig implements  WebMvcConfigurer {
//    @Bean
//    public HttpMessageConverter get(){
//        return new FastJsonHttpMessageConverter();
//    }
//    @Bean
//    public InternalResourceViewResolver internalResourceViewResolver(){
//        InternalResourceViewResolver internalResourceViewResolver = (InternalResourceViewResolver) new UrlBasedViewResolver();
//        internalResourceViewResolver.setPrefix("/");
//        internalResourceViewResolver.setSuffix(".jsp");
//        internalResourceViewResolver.setExposeContextBeansAsAttributes(true);
//        return internalResourceViewResolver;
//    }
//    @Bean("multipartResolver")//名字必须是这个，为什么？
//    public CommonsMultipartResolver commonsMultipartResolver(){
//        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
//        return commonsMultipartResolver;
//    }
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {

    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

    }

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {

    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {

    }

    @Override
    public void addFormatters(FormatterRegistry registry) {

    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {

    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        //底层调用的就是public UrlBasedViewResolverRegistration jsp(String prefix, String suffix) {
        //		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        //		resolver.setPrefix(prefix);
        //		resolver.setSuffix(suffix);
        //		this.viewResolvers.add(resolver);
        //		return new UrlBasedViewResolverRegistration(resolver);
        //	}
        registry.jsp();

    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {

    }

    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {

    }
    //// 配置消息转换器 这里用fastjson，
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        System.out.println("fast json ----");
        converters.add(new FastJsonHttpMessageConverter());

    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {

    }

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {

    }

    @Override
    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {

    }

    @Override
    public Validator getValidator() {
        return null;
    }

    @Override
    public MessageCodesResolver getMessageCodesResolver() {
        return null;
    }
//    public static void main(String[] args) {
//        StringHttpMessageConverter
//    }
}
