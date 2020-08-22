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
@Component
@ComponentScan("springmvctestdemo")
//加上注解mvc实质生效
//@EnableWebMvc
@EnableTransactionManagement
public class AppConfig {//implements  WebMvcConfigurer {
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
//    @Override
//    public void configurePathMatch(PathMatchConfigurer configurer) {
//
//    }
//
//    @Override
//    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//
//    }
//
//    @Override
//    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
//
//    }
//
//    @Override
//    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//
//    }
//
//    @Override
//    public void addFormatters(FormatterRegistry registry) {
//
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//
//    }
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//
//    }
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//
//    }
//
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//
//    }
//
//    @Override
//    public void configureViewResolvers(ViewResolverRegistry registry) {
//        //底层调用的就是public UrlBasedViewResolverRegistration jsp(String prefix, String suffix) {
//        //		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        //		resolver.setPrefix(prefix);
//        //		resolver.setSuffix(suffix);
//        //		this.viewResolvers.add(resolver);
//        //		return new UrlBasedViewResolverRegistration(resolver);
//        //	}
//        registry.jsp();
//
//    }
//
//    @Override
//    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
//
//    }
//
//    @Override
//    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {
//
//    }
//
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        System.out.println("fast json ----");
//        converters.add(new FastJsonHttpMessageConverter());
//
//    }
//
//    @Override
//    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
//
//    }
//
//    @Override
//    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
//
//    }
//
//    @Override
//    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
//
//    }
//
//    @Override
//    public Validator getValidator() {
//        return null;
//    }
//
//    @Override
//    public MessageCodesResolver getMessageCodesResolver() {
//        return null;
//    }
////    public static void main(String[] args) {
////        StringHttpMessageConverter
////    }
}
