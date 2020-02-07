package com.xxyl.security.spring.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * Web安全配置类
 *
 * @author xxyl
 * @version 2020/2/7 13:47
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 返回一个UserDetailService给Spring容器，Spring Security会据此来获取用户信息。
     * 我们暂且使用InMemoryUserDetailsManager实现类，并创建了zhangsan和lisi两个用
     * 户，同时设置了密码和权限。
     * @return
     */
    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("zhangsan").password("123").authorities("p1").build());
        manager.createUser(User.withUsername("lisi").password("456").authorities("p2").build());
        return manager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    /**
     * 配置安全拦截机制
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/resource/r1").hasAuthority("p1") //为资源/resource/r1设置p1权限
                .antMatchers("/resource/r2").hasAuthority("p2") //为资源/resource/r2设置p2权限
                .antMatchers("/resource/**").authenticated()    //url匹配/resource/**资源，经过认证后才能访问
                .anyRequest().permitAll()    //其他url完全开放
                .and()
                .formLogin().successForwardUrl("/login-success");    //支持form表单认证，认证成功后转向/login-success
        super.configure(http);
    }
}
