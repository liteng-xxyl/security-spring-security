package com.xxyl.security.spring.security.init;


import com.xxyl.security.spring.security.config.ApplicationConfig;
import com.xxyl.security.spring.security.config.WebConfig;
import com.xxyl.security.spring.security.config.WebSecurityConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 此类相当于web.xml，在servlet3.0之后不需要再定义web.xml
 *
 * @author xxyl
 * @version 2020/2/7 9:38
 */
public class SpringApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {ApplicationConfig.class, WebSecurityConfig.class};    //指定rootContext的配置类
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {WebConfig.class};    //指定servletContext的配置类
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

}
