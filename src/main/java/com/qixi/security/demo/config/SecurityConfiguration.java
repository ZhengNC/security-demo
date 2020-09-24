package com.qixi.security.demo.config;

import com.qixi.security.demo.config.handler.*;
import com.qixi.security.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;

/**
 * @author ZhengNC
 * @date 2020/6/22 16:46
 */
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Autowired
    private SuccessHandler successHandler;

    @Autowired
    private FailureHandler failureHandler;

    @Autowired
    private MyAuthenticationEntryPoint authenticationEntryPoint;

    @Autowired
    private MyAccessDeniedHandler accessDeniedHandler;

    @Autowired
    private MyLogoutSuccessHandler logoutSuccessHandler;

    @Bean("passwordEncoder")
    PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    /**
     * 身份验证
     *
     * @return
     */
    AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //身份验证
                .authenticationProvider(authenticationProvider())
                .httpBasic()
                //未登录的处理
                .authenticationEntryPoint(authenticationEntryPoint)
                .and()
                .authorizeRequests()
                .anyRequest()
                //必须授权才能返回
                .authenticated()
                .and()
                //使用自带的登录
                .formLogin()
                .permitAll()
                //登录成功的处理逻辑
                .successHandler(successHandler)
                //登录失败的处理逻辑
                .failureHandler(failureHandler)
                .and()
                .exceptionHandling()
                //权限验证
                .accessDeniedHandler(accessDeniedHandler)
                .and()
                .logout()
                //注销登录的处理逻辑
                .logoutSuccessHandler(logoutSuccessHandler)
                .permitAll()
                .and()
                //开启跨域访问
                .cors().disable()
                //开启模拟请求，比如API POST测试工具的测试，不开启时，API POST为报403错误
                .csrf().disable();
    }
}
