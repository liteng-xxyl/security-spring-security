package com.xxyl.security.spring.security.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;


/**
 * 对应web.xml中ContextLoaderListener的配置
 *
 * @author xxyl
 * @version 2020/2/7 9:22
 */
@Configuration
@ComponentScan(
        basePackages = "com.xxyl.security.spring.security",
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class)})
public class ApplicationConfig {

    //todo 在此配置除了controller之外的其他bean，比如：数据库连接池、事务管理器、业务bean等。

}
